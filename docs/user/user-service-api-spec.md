# Mini Twitter API Documentation (User Service)

Welcome to the Mini Twitter API documentation. This guide provides a comprehensive overview of the available API endpoints for the **User Service**, including detailed descriptions, example requests, and responses.

<details>
<a id="create-user"></a>
<summary><b>Create a User</b></summary>

**Endpoint:** `POST /api/users`

**Description:** Creates a new user in the system.

**Request Body:**
```json
{
  "username": "johndoe",
  "email": "johndoe@example.com",
  "password": "password123",
  "bio": "A passionate coder."
}
```

**Response Body (Success):**
```json
{
  "data": {
    "id": "user-123",
    "username": "johndoe",
    "email": "johndoe@example.com",
    "bio": "A passionate coder."
  }
}
```

**Response Body (Failed):**
```json
{
  "errors": "Username or email already exists."
}
```
</details>

<details>
<a id="fetch-user-profile"></a>
<summary><b>Fetch User Profile</b></summary>

**Endpoint:** `GET /api/users/{userId}`

**Description:**  Retrieves details of a specific user by their ID.

**Request Parameters::**
- userId: The unique identifier of the user whose profile is being fetched.

**Response Body (Success):**
```json
{
  "data": {
    "id": "user-123",
    "username": "johndoe",
    "email": "johndoe@example.com",
    "bio": "A passionate coder."
  }
}
```

**Response Body (Failed):**
```json
{
  "errors": "User not found."
}
```
</details>

