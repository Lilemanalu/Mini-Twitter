# Post Service Database Design

## Table

### 1. **Posts**
| Column        | Type     | Description                                       | Constraints                                   |
|---------------|----------|---------------------------------------------------|-----------------------------------------------|
| `id`          | UUID     | Unique identifier for the post.                   | Primary Key                                   |
| `user_id`     | UUID     | Identifier of the user who created the post.      | Foreign Key referencing `Users(id)`, Not Null |
| `content`     | String   | Content of the post (text).                       | Not Null, Max Length (e.g., 1000 characters)  |
| `created_at`  | DateTime | Timestamp when the post was created.              | Not Null                                      |
| `updated_at`  | DateTime | Timestamp when the post was last updated.         | Not Null                                      |

## Relations

- **Post - User**: Many-to-One (Each post is created by one user, but a user can create multiple posts.)
- **Post - PostLike**: One-to-Many (A post can be liked by multiple users, and each like is associated with one post.)
- **Post - Comment**: One-to-Many (A post can have multiple comments, and each comment is associated with one post.)
