# Follow Service Database Design

## Tables

### 1. **Followers**
| Column          | Type     | Description                                             |
|-----------------|----------|---------------------------------------------------------|
| `id`            | UUID     | Unique identifier for the follower record.             |
| `follower_id`   | UUID     | Identifier of the user who is following.               |
| `following_id`  | UUID     | Identifier of the user being followed.                 |
| `created_at`    | DateTime | Timestamp when the follow relationship was created.    |

## Relations

- **Followers - User (Follower)**: Many-to-One (Each follow relationship is associated with one follower, but a user can have multiple followers.)
- **Followers - User (Following)**: Many-to-One (Each follow relationship is associated with one user being followed, but a user can be followed by multiple users.)
