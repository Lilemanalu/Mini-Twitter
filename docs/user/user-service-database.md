# User Service Database Design

## Table

### 1. **Users**
| Column        | Type     | Description                                       | Constraints                                   |
|---------------|----------|---------------------------------------------------|-----------------------------------------------|
| `id`          | UUID     | Unique identifier for the user.                   | Primary Key                                   |
| `username`    | String   | Unique username for the user.                     | Unique, Not Null, Max Length (e.g., 255)      |
| `email`       | String   | User's email address (unique).                    | Unique, Not Null, Max Length (e.g., 255)      |
| `password`    | String   | Hashed password for authentication.               | Not Null                                      |
| `name`        | String   | Full name of the user.                            | Not Null, Max Length (e.g., 255)              |
| `bio`         | String   | Short biography of the user.                      | Optional, Max Length (e.g., 500)              |
| `created_at`  | DateTime | Timestamp when the user was created.              | Not Null, Automatically set by system         |
| `updated_at`  | DateTime | Timestamp when the user information was last updated. | Not Null, Automatically updated by system    |
| `token`       | String   | Token for user authentication (optional).          | Nullable                                      |
| `token_expired_at` | Long | Timestamp when the token expires (optional).      | Nullable                                      |

## Relations

- **User - Post**: One-to-Many (A user can create multiple posts.)
- **User - Comment**: One-to-Many (A user can make multiple comments.)
