# Comment Service Database Design

## Tables

### 1. **Comments**
| Column        | Type     | Description                                       | Constraints                                   |
|---------------|----------|---------------------------------------------------|-----------------------------------------------|
| `id`          | UUID     | Unique identifier for the comment.                | Primary Key                                   |
| `post_id`     | UUID     | Identifier of the associated post.                | Foreign Key referencing `Posts(id)`, Not Null |
| `user_id`     | UUID     | Identifier of the user who made the comment.      | Foreign Key referencing `Users(id)`, Not Null |
| `comment`     | String   | The content of the comment.                       | Not Null, Max Length (e.g., 500 characters)   |
| `created_at`  | DateTime | Timestamp when the comment was created.           | Not Null                                      |
| `updated_at`  | DateTime | Timestamp when the comment was last updated.      | Not Null                                      |

## Relations

- **Comments - Post**: Many-to-One (Each comment is associated with one post, but a post can have multiple comments.)
- **Comments - User**: Many-to-One (Each comment is made by one user, but a user can make multiple comments.)
