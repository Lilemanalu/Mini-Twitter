# Mini Twitter API Documentation (Follow Service)

Welcome to the Mini Twitter API documentation. This guide provides a comprehensive overview of the available API endpoints for the **Follow Service**, including detailed descriptions, example requests, and responses.

<details>
<a id="follow-user"></a>
<summary><b>Follow a User</b></summary>

**Endpoint:** `POST /api/users/{userId}/follow`

**Description:** Follows a specific user.

**Request Parameters::**
- userId (Path Parameter): ID of the user to follow. This parameter is used to specify the user who will be followed.

**Response Body (Success):**
```json
{
  "message": "You are now following user-123."
}
```

**Response Body (Failed):**
```json
{
  "errors": "You are already following this user."
}
```
</details>

<details>
<a id="unfollow-user"></a>
<summary><b>Unfollow a User</b></summary>

**Endpoint:** `DELETE /api/users/{userId}/follow`

**Description:** Unfollows a specific user.

**Request Parameters::**
- userId (Path Parameter): ID of the user to unfollow. This parameter is used to specify the user who will be unfollowed.

**Response Body (Success):**
```json
{
  "message": "You have unfollowed user-123."
}
```

**Response Body (Failed):**
```json
{
  "errors": "You are not following this user."
}
```
</details>

<details>
<a id="fetch-followers"></a>
<summary><b>Fetch User Followers</b></summary>

**Endpoint:** `GET /api/users/{userId}/followers`

**Description:** Retrieves a list of users who follow the specified user.

**Request Parameters::**
- userId (Path Parameter): ID of the user whose followers are to be fetched. This parameter is used to specify the user whose followers you want to retrieve.

**Response Body (Success):**
```json
{
  "data": [
    {
      "id": "user-456",
      "username": "janedoe",
      "bio": "Tech enthusiast."
    },
    {
      "id": "user-789",
      "username": "alice",
      "bio": "Loves coding."
    }
  ]
}
```

**Response Body (Failed):**
```json
{
  "errors": "No followers found for this user."
}
```
</details>

<details>
<a id="fetch-following"></a>
<summary><b>Fetch Following Users</b></summary>

**Endpoint:** `GET /api/users/{userId}/following`

**Description:**  Retrieves a list of users that the specified user is following.

**Request Parameters::**
- userId (Path Parameter): ID of the user whose following list is to be fetched. This parameter is used to specify the user whose following list you want to retrieve.

**Response Body (Success):**
```json
{
  "data": [
    {
      "id": "user-456",
      "username": "janedoe",
      "bio": "Tech enthusiast."
    },
    {
      "id": "user-789",
      "username": "alice",
      "bio": "Loves coding."
    }
  ]
}
```

**Response Body (Failed):**
```json
{
  "errors": "This user is not following anyone."
}
```
</details>
