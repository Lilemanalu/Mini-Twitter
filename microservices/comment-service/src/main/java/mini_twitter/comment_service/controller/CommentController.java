package mini_twitter.comment_service.controller;

import mini_twitter.comment_service.dto.CommentRequestDto;
import mini_twitter.comment_service.dto.CommentResponseDto;
import mini_twitter.comment_service.dto.WebResponseDto;
import mini_twitter.comment_service.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @PostMapping(
            path = "/api/posts/{postId}/comments",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponseDto<CommentResponseDto> createComment(@RequestHeader("X-API-TOKEN") String token,
                                                            @PathVariable String postId,
                                                            @RequestBody CommentRequestDto request) {
        logger.info("Received request to create comment for postId: {}. Request Body: {}, Token: {}", postId, request, token);

        try {
            WebResponseDto<CommentResponseDto> response = commentService.createComment(token, postId, request);

            if (response.getErrors() == null || response.getErrors().isEmpty()) {
                logger.info("Comment created successfully for postId: {} by userId: {}", postId, response.getData().getUserId());
            } else {
                logger.warn("Comment creation failed for postId: {}. Errors: {}", postId, response.getErrors());
            }
            return response;
        } catch (Exception e) {
            logger.error("Error occurred while creating comment for postId: {}. Error: {}", postId, e.getMessage(), e);
            throw e;
        }
    }

}
