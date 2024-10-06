package mini_twitter.follow_service.configuration;

import lombok.extern.slf4j.Slf4j;
import mini_twitter.follow_service.entity.Follow;
import mini_twitter.follow_service.repository.FollowRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Slf4j
@Configuration
public class DataInitializer {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private FollowRepository followRepository;

    @Bean
    public CommandLineRunner initFollowData() {
        return args -> {
            try {
                LocalDateTime now = LocalDateTime.now();

                followRepository.save(new Follow(
                        "1", // ID
                        "1", // userId
                        "2", // followerId
                        now // createdAt
                ));

                followRepository.save(new Follow(
                        "2",
                        "1",
                        "3",
                        now
                ));

                followRepository.save(new Follow(
                        "3",
                        "3",
                        "1",
                        now
                ));

                followRepository.save(new Follow(
                        "4",
                        "4",
                        "2",
                        now
                ));

                followRepository.save(new Follow(
                        "5",
                        "5",
                        "3",
                        now
                ));

                logger.info("Follow data initialized successfully");
            } catch (Exception e) {
                logger.error("Failed to initialize follow data", e);
            }
        };
    }
}
