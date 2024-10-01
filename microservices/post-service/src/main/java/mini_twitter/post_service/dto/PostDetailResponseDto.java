package mini_twitter.post_service.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostDetailResponseDto {
    private String id;
    private String userId;
    private String content;
    private LocalDateTime createdAt;
//    private int likes;
}

