# Post Service Database Design

## Table

### 1. **Posts**
| Column        | Type     | Description                                       |
|---------------|----------|---------------------------------------------------|
| `id`          | UUID     | Unique identifier for the post.                  |
| `user_id`     | UUID     | Identifier of the user who created the post.     |
| `content`     | String   | Content of the post (text).                      |
| `created_at`  | DateTime | Timestamp when the post was created.             |
| `updated_at`  | DateTime | Timestamp when the post was last updated.        |

## Relations

- **Post - User**: Many-to-One (Each post is created by one user, but a user can create multiple posts.)
- **Post - PostLike**: One-to-Many (A post can be liked by multiple users, and each like is associated with one post.)
- **Post - Comment**: One-to-Many (A post can have multiple comments, and each comment is associated with one post.)
