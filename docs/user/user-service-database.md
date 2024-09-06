# User Service Database Design

## Tables:

### 1. **Users**
| Column        | Type     | Description                           |
|---------------|----------|---------------------------------------|
| `id`          | UUID     | Unique identifier for the user.       |
| `username`    | String   | Unique username for the user.         |
| `email`       | String   | User's email address (unique).        |
| `password`    | String   | Hashed password for authentication.   |
| `bio`         | String   | Short biography of the user.          |
| `created_at`  | DateTime | Timestamp when the user was created.  |

### 2. **Followers**
| Column          | Type     | Description                                             |
|-----------------|----------|---------------------------------------------------------|
| `id`            | UUID     | Unique identifier for the follower record.              |
| `follower_id`   | UUID     | Identifier of the user who is following.                |
| `following_id`  | UUID     | Identifier of the user being followed.                  |
| `created_at`    | DateTime | Timestamp when the follow relationship was created.     |

## Relationships:
- One user can follow many others through the **Followers** table, which has a self-referencing relationship.
