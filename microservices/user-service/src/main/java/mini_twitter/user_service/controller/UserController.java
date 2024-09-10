package mini_twitter.user_service.controller;

import mini_twitter.user_service.dto.RegisterUserRequest;
import mini_twitter.user_service.dto.WebResponse;
import mini_twitter.user_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody RegisterUserRequest request) {
        logger.info("Received registration request for username: {}", request.getUsername());

        try {
            userService.register(request);
            logger.info("Successfully registered user: {}", request.getUsername());
            return WebResponse.<String>builder().data("OK").build();
        } catch (Exception e) {
            logger.error("Error registering user: {}", request.getUsername(), e);
            throw e;
        }
    }
}
