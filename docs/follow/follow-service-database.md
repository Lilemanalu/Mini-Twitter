# Follow Service Database Design

## Tables:

### 1. **Followers**
| Column          | Type     | Description                                             |
|-----------------|----------|---------------------------------------------------------|
| `id`            | UUID     | Unique identifier for the follower record.              |
| `follower_id`   | UUID     | Identifier of the user who is following.                |
| `following_id`  | UUID     | Identifier of the user being followed.                  |
| `created_at`    | DateTime | Timestamp when the follow relationship was created.     |

## Relationships:
- A user can follow many others, and this relationship is tracked in the **Followers** table with a self-referencing foreign key.
