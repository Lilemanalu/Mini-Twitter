# User Service Database Design

## Table

### 1. **Users**
| Column        | Type     | Description                                       |
|---------------|----------|---------------------------------------------------|
| `id`          | UUID     | Unique identifier for the user.                  |
| `username`    | String   | Unique username for the user.                    |
| `email`       | String   | User's email address (unique).                   |
| `password`    | String   | Hashed password for authentication.              |
| `bio`         | String   | Short biography of the user.                     |
| `created_at`  | DateTime | Timestamp when the user was created.             |
| `updated_at`  | DateTime | Timestamp when the user information was last updated. |

## Relations

- **User - Post**: One-to-Many (A user can create multiple posts.)
- **User - Comment**: One-to-Many (A user can make multiple comments.)
