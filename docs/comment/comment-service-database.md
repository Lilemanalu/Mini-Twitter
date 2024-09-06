# Comment Service Database Design

## Tables:

### 1. **Comments**
| Column        | Type     | Description                                       |
|---------------|----------|---------------------------------------------------|
| `id`          | UUID     | Unique identifier for the comment.                |
| `post_id`     | UUID     | Identifier of the associated post.                |
| `user_id`     | UUID     | Identifier of the user who made the comment.      |
| `comment`     | String   | The content of the comment.                       |
| `created_at`  | DateTime | Timestamp when the comment was created.           |

## Relationships:
- A post can have many comments. Each comment is associated with a user and a post.
