# Post Service Database Design

## Table:

### 1. **Posts**
| Column        | Type     | Description                                       |
|---------------|----------|---------------------------------------------------|
| `id`          | UUID     | Unique identifier for the post.                   |
| `user_id`     | UUID     | Identifier of the user who created the post.       |
| `content`     | String   | Content of the post (text).                        |
| `created_at`  | DateTime | Timestamp when the post was created.               |

## Relationships:
Each post is associated with a user, but the likes and comments data will be fetched from their respective services.
