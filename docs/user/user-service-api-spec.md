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
  "name": "John Doe",
  "bio": "A passionate coder."
}
```

**Response Body (Success):**
```json
{
  "data": "OK"
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
<a id="login-user"></a>
<summary><b>Login User</b></summary>

**Endpoint:** `POST /api/auth/login`

**Description:**  uthenticates a user and returns a token.

- **Request Body:**
```json
{
  "username": "johndoe",
  "password": "password123"
}
```

**Response Body (Success):**
```json
{
  "data": {
    "token": "jwt-token-example",
    "expiredAt": 1694538000000
  }
}
```

**Response Body (Failed):**
```json
{
  "errors": "Username or password wrong."
}
```
</details>

<details>
<a id="logout"></a>
<summary><b>Logout User</b></summary>

**Endpoint:** `DELETE /api/auth/logout`

**Description:**  Logs out a user by invalidating their token.

**Request Header:**
- `X-API-TOKEN`: The user's authentication token (Mandatory).

**Response Body (Success):**
```json
{
  "data": "OK"
}
```

**Response Body (Failed):**
```json
{
  "errors": "Error logging out user."
}
```
</details>

<details>
<a id="update-user"></a>
<summary><b>Update User</b></summary>

**Endpoint:** `PUT /api/users/{userId}`

**Description:**  Updates the information of an existing user. The user must be authenticated to update their profile.

**Request Parameters:**:
- `useId` : The unique identifier of the user whose profile is being updated.

**Request Header:**
- `X-API-TOKEN`: The user's authentication token (Mandatory).

- **Request Body:**
```json
{
  "email": "newemail@example.com",
  "password": "newpassword123",
  "name": "New Name",
  "bio": "Updated bio."
}
```

**Response Body (Success):**
```json
{
  "data": {
    "id": "user-123",
    "username": "johndoe",
    "email": "newemail@example.com",
    "name": "New Name",
    "bio": "Updated bio."
  }
}
```

**Response Body (Failed):**
```json
{
  "errors": "User not found or validation error."
}
```
</details>

<details>
<a id="fetch-user-profile"></a>
<summary><b>Fetch User Profile</b></summary>

**Endpoint:** `GET /api/users/{userId}`

**Description:**  Retrieves details of a specific user by their ID.

**Request Parameters::**
- `userId`: The unique identifier of the user whose profile is being fetched.

**Response Body (Success):**
```json
{
  "data": {
    "id": "user-123",
    "username": "johndoe",
    "email": "johndoe@example.com",
    "name": "John Doe",
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
