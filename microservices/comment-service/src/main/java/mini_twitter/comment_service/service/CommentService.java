package mini_twitter.comment_service.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mini_twitter.comment_service.dto.CommentRequestDto;
import mini_twitter.comment_service.dto.CommentResponseDto;
import mini_twitter.comment_service.dto.WebResponseDto;
import mini_twitter.comment_service.entity.Comment;
import mini_twitter.comment_service.repository.CommentRepository;
import mini_twitter.comment_service.webclient.UserServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class CommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private UserServiceClient userServiceClient;

    @Transactional
    public WebResponseDto<CommentResponseDto> createComment(String token, String postId, CommentRequestDto request) {
        logger.info("Received request to create a comment for postId: {}, with request body: {}", postId, request);

        // Validate the comment content
        if (request.getComment() == null || request.getComment().trim().isEmpty()) {
            logger.warn("Validation failed: Comment content is empty for postId: {}", postId);
            return WebResponseDto.<CommentResponseDto>builder()
                    .errors("Comment cannot be empty.")
                    .build();
        }

        // Retrieve userId from token
        String userId;
        try {
            userId = userServiceClient.getUserIdFromToken(token);
            if (userId == null) {
                logger.error("Failed to retrieve userId from token for postId: {}. Token: {}", postId, token);
                return WebResponseDto.<CommentResponseDto>builder()
                        .errors("Invalid token, could not retrieve user ID.")
                        .build();
            }
            logger.info("Successfully retrieved userId: {} from token for postId: {}", userId, postId);
        } catch (Exception e) {
            logger.error("Error occurred while retrieving userId from token for postId: {}. Error: {}", postId, e.getMessage());
            return WebResponseDto.<CommentResponseDto>builder()
                    .errors("Token validation failed.")
                    .build();
        }

        // Create and save the new comment
        Comment comment = new Comment();
        comment.setId(UUID.randomUUID().toString());
        comment.setUserId(userId);
        comment.setPostId(postId);
        comment.setComment(request.getComment());
        comment.setCreatedAt(LocalDateTime.now());

        try {
            commentRepository.save(comment);
            logger.info("Comment successfully created for postId: {} by userId: {}. CommentId: {}", postId, userId, comment.getId());
        } catch (Exception e) {
            logger.error("Failed to save comment for postId: {} by userId: {}. Error: {}", postId, userId, e.getMessage());
            return WebResponseDto.<CommentResponseDto>builder()
                    .errors("Unable to save comment. Please try again later.")
                    .build();
        }

        // Create response DTO
        CommentResponseDto responseDto = toCommentResponse(comment);
        logger.info("Returning response for created commentId: {} for postId: {}", comment.getId(), postId);

        return WebResponseDto.<CommentResponseDto>builder()
                .data(responseDto)
                .build();
    }

    private CommentResponseDto toCommentResponse(Comment comment) {
        return CommentResponseDto.builder()
                .id(comment.getId())
                .userId(comment.getUserId())
                .postId(comment.getPostId())
                .comment(comment.getComment())
                .createdAt(comment.getCreatedAt())
                .build();
    }

}
