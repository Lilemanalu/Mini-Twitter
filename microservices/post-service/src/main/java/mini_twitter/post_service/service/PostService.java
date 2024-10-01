package mini_twitter.post_service.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mini_twitter.post_service.dto.PostRequestDto;
import mini_twitter.post_service.dto.PostResponseDto;
import mini_twitter.post_service.dto.WebResponseDto;
import mini_twitter.post_service.entity.Post;
import mini_twitter.post_service.repository.PostRepository;
import mini_twitter.post_service.webclient.UserServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private UserServiceClient userServiceClient;

    @Transactional
    public WebResponseDto<PostResponseDto> createPost(String token, PostRequestDto request) {
        logger.info("Create Post Request: {}, Token: {}", request, token);

        // Validate the post content
        if (request.getContent() == null || request.getContent().trim().isEmpty()) {
            logger.error("Failed to create post: Content cannot be empty.");
            return WebResponseDto.<PostResponseDto>builder()
                    .errors("Content cannot be empty.")
                    .build();
        }

        // Retrieve userId from token
        String userId = userServiceClient.getUserIdFromToken(token);
        logger.info("User ID retrieved from token: {}", userId);

        // Create and save the new post
        Post post = new Post();
        post.setId(UUID.randomUUID().toString());
        post.setUserId(userId);
        post.setContent(request.getContent());
        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);

        logger.info("Post created successfully: {}", post);

        // Create response DTO
        PostResponseDto responseDto = toPostResponse(post);
        return WebResponseDto.<PostResponseDto>builder()
                .data(responseDto)
                .build();
    }

    private PostResponseDto toPostResponse(Post post) {
        return PostResponseDto.builder()
                .id(post.getId())
                .userId(post.getUserId())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
