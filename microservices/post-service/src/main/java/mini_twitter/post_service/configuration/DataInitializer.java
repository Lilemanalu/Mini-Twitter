package mini_twitter.post_service.configuration;

import lombok.extern.slf4j.Slf4j;
import mini_twitter.post_service.entity.Post;
import mini_twitter.post_service.repository.PostRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Configuration
public class DataInitializer {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private PostRepository postRepository;

    @Bean
    public CommandLineRunner initPostData() {
        return args -> {
            try {
                LocalDateTime now = LocalDateTime.now();

                postRepository.save(new Post(
//                        UUID.randomUUID().toString(), // ID
                        "1",
                        "1", // userId
                        "This is my first post!", // content
                        now, // createdAt
                        now // updatedAt
                ));

                postRepository.save(new Post(
//                        UUID.randomUUID().toString(),
                        "2",
                        "2",
                        "Hi!",
                        now,
                        now
                ));

                postRepository.save(new Post(
//                        UUID.randomUUID().toString(),
                        "3",
                        "3",
                        "Hello, this is another post!",
                        now,
                        now
                ));

                postRepository.save(new Post(
//                        UUID.randomUUID().toString(),
                        "4",
                        "4",
                        "Just another post content here.",
                        now,
                        now
                ));

                postRepository.save(new Post(
//                        UUID.randomUUID().toString(),
                        "5",
                        "1",
                        "A second post from the same user.",
                        now,
                        now
                ));

                postRepository.save(new Post(
                        "6",
                        "2",
                        "What’s everyone reading these days? Any recommendations?",
                        now,
                        now
                ));

                postRepository.save(new Post(
                        "7",
                        "3",
                        "Had a great day out today! Here’s a pic from my adventure!",
                        now,
                        now
                ));

                postRepository.save(new Post(
                        "8",
                        "4",
                        "Feeling inspired! Can’t wait to share my new project soon.",
                        now,
                        now
                ));

                postRepository.save(new Post(
                        "9",
                        "1",
                        "Just finished a great workout! Staying healthy is key.",
                        now,
                        now
                ));

                logger.info("Post data initialized successfully");
            } catch (Exception e) {
                logger.error("Failed to initialize post data", e);
            }
        };
    }
}
