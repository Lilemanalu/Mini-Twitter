package mini_twitter.user_service.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mini_twitter.user_service.dto.RegisterUserRequest;
import mini_twitter.user_service.entity.User;
import mini_twitter.user_service.repository.UserRepository;
import mini_twitter.user_service.security.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@Slf4j
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public void register(RegisterUserRequest request) {
        logger.info("Starting user registration process for username: {}", request.getUsername());

        validationService.validate(request);
        logger.debug("Validation passed for username: {}", request.getUsername());

        if (userRepository.existsById(request.getUsername())) {
            logger.warn("Username {} is already registered", request.getUsername());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
        }

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());
        user.setBio(request.getBio());

        userRepository.save(user);
        logger.info("User registration successful for username: {}", request.getUsername());
    }
}
