# Like Service Database Design

## Tables

### 1. **PostLikes**
| Column        | Type     | Description                                       | Constraints                                   |
|---------------|----------|---------------------------------------------------|-----------------------------------------------|
| `id`          | UUID     | Unique identifier for the post like record.       | Primary Key                                   |
| `post_id`     | UUID     | Identifier of the liked post.                     | Foreign Key referencing `Posts(id)`, Not Null |
| `user_id`     | UUID     | Identifier of the user who liked the post.        | Foreign Key referencing `Users(id)`, Not Null |
| `created_at`  | DateTime | Timestamp when the like was created.              | Not Null                                      |

### 2. **CommentLikes**
| Column        | Type     | Description                                       | Constraints                                   |
|---------------|----------|---------------------------------------------------|-----------------------------------------------|
| `id`          | UUID     | Unique identifier for the comment like record.    | Primary Key                                   |
| `comment_id`  | UUID     | Identifier of the liked comment.                  | Foreign Key referencing `Comments(id)`, Not Null |
| `user_id`     | UUID     | Identifier of the user who liked the comment.     | Foreign Key referencing `Users(id)`, Not Null |
| `created_at`  | DateTime | Timestamp when the like was created.              | Not Null                                      |

## Relations

- **PostLikes - Post**: Many-to-One (Each like is associated with one post, but a post can have multiple likes.)
- **CommentLikes - Comment**: Many-to-One (Each like is associated with one comment, but a comment can have multiple likes.)
