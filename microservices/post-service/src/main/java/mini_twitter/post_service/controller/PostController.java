package mini_twitter.post_service.controller;

import mini_twitter.post_service.dto.PostRequestDto;
import mini_twitter.post_service.dto.PostResponseDto;
import mini_twitter.post_service.dto.WebResponseDto;
import mini_twitter.post_service.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @PostMapping(
            path = "/api/posts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponseDto<PostResponseDto> createPost(@RequestHeader("X-API-TOKEN") String token,
                                                      @RequestBody PostRequestDto request) {
        logger.info("Request to create post with token: {}", token);

        try {
            WebResponseDto<PostResponseDto> response = postService.createPost(token, request);
            logger.info("Post created successfully with user ID: {}", response.getData().getUserId());
            return response;
        } catch (Exception e) {
            logger.error("Error creating post: {}", e.getMessage(), e);
            throw e;
        }
    }
}
