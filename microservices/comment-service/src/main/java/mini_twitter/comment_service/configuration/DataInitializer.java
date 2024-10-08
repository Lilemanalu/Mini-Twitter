package mini_twitter.comment_service.configuration;

import lombok.extern.slf4j.Slf4j;
import mini_twitter.comment_service.entity.Comment;
import mini_twitter.comment_service.repository.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Slf4j
@Configuration
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private CommentRepository commentRepository;

    @Bean
    public CommandLineRunner initCommentData() {
        return args -> {
            try {
                LocalDateTime now = LocalDateTime.now();

                commentRepository.save(new Comment(
                        "1",
                        "1",
                        "1",
                        "Great post! Looking forward to more updates.",
                        now,
                        now
                ));

                commentRepository.save(new Comment(
                        "2",
                        "2",
                        "2",
                        "Interesting thoughts! I had the same idea.",
                        now,
                        now
                ));

                commentRepository.save(new Comment(
                        "3",
                        "3",
                        "3",
                        "Thanks for sharing this! It really helped.",
                        now,
                        now
                ));

                commentRepository.save(new Comment(
                        "4",
                        "1",
                        "4",
                        "Could you elaborate more on this topic?",
                        now,
                        now
                ));

                commentRepository.save(new Comment(
                        "5",
                        "4",
                        "1",
                        "Excited to see where this project is going!",
                        now,
                        now
                ));

                commentRepository.save(new Comment(
                        "6",
                        "5",
                        "2",
                        "Awesome content, as always.",
                        now,
                        now
                ));

                logger.info("Comment data initialized successfully");
            } catch (Exception e) {
                logger.error("Failed to initialize comment data", e);
            }
        };
    }
}
