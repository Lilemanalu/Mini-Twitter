package mini_twitter.follow_service.controller;

import mini_twitter.follow_service.dto.WebResponseDto;
import mini_twitter.follow_service.service.FollowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowController {

    private static final Logger logger = LoggerFactory.getLogger(FollowController.class);

    @Autowired
    private FollowService followService;

    @PostMapping(
            path = "/api/users/{userId}/follow",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponseDto<String> followUser(@PathVariable String userId, @RequestHeader("X-API-TOKEN") String token) {
        logger.info("Request to follow user ID: {} with token: {}", userId, token);

        try {
            WebResponseDto<String> response = followService.followUser(userId, token);
            logger.info("Successfully followed user ID: {}", userId);
            return response;
        } catch (Exception e) {
            logger.error("Error following user ID: {}", userId, e);
            throw e;
        }
    }

}
