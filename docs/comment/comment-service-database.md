# Comment Service Database Design

## Tables

### 1. **Comments**
| Column        | Type     | Description                                       |
|---------------|----------|---------------------------------------------------|
| `id`          | UUID     | Unique identifier for the comment.               |
| `post_id`     | UUID     | Identifier of the associated post.               |
| `user_id`     | UUID     | Identifier of the user who made the comment.     |
| `comment`     | String   | The content of the comment.                      |
| `created_at`  | DateTime | Timestamp when the comment was created.          |
| `updated_at`  | DateTime | Timestamp when the comment was last updated.     |

## Relations

- **Comments - Post**: Many-to-One (Each comment is associated with one post, but a post can have multiple comments.)
- **Comments - User**: Many-to-One (Each comment is made by one user, but a user can make multiple comments.)
