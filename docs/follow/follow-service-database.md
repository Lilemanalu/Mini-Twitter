# Follow Service Database Design

## Tables

### 1. **Follows**
| Column           | Type     | Description                                                | Constraints                                |
|------------------|----------|------------------------------------------------------------|--------------------------------------------|
| `id`             | UUID     | Unique identifier for the follow record.                   | Primary Key                                |
| `user_id`        | UUID     | Identifier of the user being followed.                     | Foreign Key referencing `Users(id)`        |
| `follower_id`    | UUID     | Identifier of the user who is following (the follower).    | Foreign Key referencing `Users(id)`        |
| `created_at`     | DateTime | Timestamp when the follow relationship was created.        | Not Null                                   |

## Relations

- **Follows - User (Follower)**: Many-to-One (Each follow relationship is associated with one follower, but a user can follow multiple users.)
- **Follows - User (Following)**: Many-to-One (Each follow relationship is associated with one user being followed, but a user can be followed by multiple followers.)
