package mini_twitter.user_service.configuration;

import lombok.extern.slf4j.Slf4j;
import mini_twitter.user_service.entity.User;
import mini_twitter.user_service.repository.UserRepository;
import mini_twitter.user_service.security.BCrypt;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Configuration
public class DataInitializer {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            try {
                LocalDateTime now = LocalDateTime.now();

                userRepository.save(new User(
                        "1", // ID
                        "johndoe", // username
                        "johndoe@example.com", // email
                        BCrypt.hashpw("password123", BCrypt.gensalt()), // password (hashed)
                        "John Doe", // name
                        "A passionate coder.", // bio
                        now,
                        now,
                        null,
                        null
                ));

                userRepository.save(new User(
                        UUID.randomUUID().toString(),
                        "janedoe",
                        "janedoe@example.com",
                        "password123",
                        "Jane Doe",
                        "Loves to write code.",
                        now,
                        now,
                        null,
                        null
                ));

                userRepository.save(new User(
                        UUID.randomUUID().toString(),
                        "alexsmith",
                        "alexsmith@example.com",
                        BCrypt.hashpw("password123", BCrypt.gensalt()),
                        "Alex Smith",
                        "Tech enthusiast.",
                        now,
                        now,
                        null,
                        null
                ));

                userRepository.save(new User(
                        UUID.randomUUID().toString(),
                        "emilyjones",
                        "emilyjones@example.com",
                        BCrypt.hashpw("password123", BCrypt.gensalt()),
                        "Emily Jones",
                        "Software developer and blogger.",
                        now,
                        now,
                        null,
                        null
                ));

                userRepository.save(new User(
                        UUID.randomUUID().toString(),
                        "michaelbrown",
                        "michaelbrown@example.com",
                        BCrypt.hashpw("password123", BCrypt.gensalt()),
                        "Michael Brown",
                        "AI and machine learning expert.",
                        now,
                        now,
                        null,
                        null
                ));

                logger.info("User data initialized successfully");
            } catch (Exception e) {
                logger.error("Failed to initialize user data", e);
            }
        };
    }
}
