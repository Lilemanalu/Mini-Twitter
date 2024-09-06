# Post Service Database Design

## Tables:

### 1. **Posts**
| Column        | Type     | Description                                       |
|---------------|----------|---------------------------------------------------|
| `id`          | UUID     | Unique identifier for the post.                   |
| `user_id`     | UUID     | Identifier of the user who created the post.       |
| `content`     | String   | Content of the post (text).                        |
| `created_at`  | DateTime | Timestamp when the post was created.               |

### 2. **PostLikes**
| Column        | Type     | Description                                       |
|---------------|----------|---------------------------------------------------|
| `id`          | UUID     | Unique identifier for the post like record.       |
| `post_id`     | UUID     | Identifier of the liked post.                     |
| `user_id`     | UUID     | Identifier of the user who liked the post.        |
| `created_at`  | DateTime | Timestamp when the like was created.              |

## Relationships:
- Each post is associated with a user and can have many likes.
- The **PostLikes** table records which users liked which posts.
