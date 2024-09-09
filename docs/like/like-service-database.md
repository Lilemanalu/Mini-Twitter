# Like Service Database Design

## Tables

### 1. **PostLikes**
| Column        | Type     | Description                                       |
|---------------|----------|---------------------------------------------------|
| `id`          | UUID     | Unique identifier for the post like record.      |
| `post_id`     | UUID     | Identifier of the liked post.                    |
| `user_id`     | UUID     | Identifier of the user who liked the post.       |
| `created_at`  | DateTime | Timestamp when the like was created.             |

### 2. **CommentLikes**
| Column        | Type     | Description                                       |
|---------------|----------|---------------------------------------------------|
| `id`          | UUID     | Unique identifier for the comment like record.   |
| `comment_id`  | UUID     | Identifier of the liked comment.                 |
| `user_id`     | UUID     | Identifier of the user who liked the comment.    |
| `created_at`  | DateTime | Timestamp when the like was created.             |

## Relations

- **PostLikes - Post**: Many-to-One (Each like is associated with one post, but a post can have multiple likes.)
- **CommentLikes - Comment**: Many-to-One (Each like is associated with one comment, but a comment can have multiple likes.)
