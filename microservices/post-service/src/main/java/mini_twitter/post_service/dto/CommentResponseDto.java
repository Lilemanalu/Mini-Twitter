package mini_twitter.post_service.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CommentResponseDto {

    private String id;

    private String userId;

    private String postId;

    private String comment;

    private LocalDateTime createdAt;

}