package mini_twitter.like_service.repository;

import mini_twitter.like_service.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<CommentLike, String> {
}
