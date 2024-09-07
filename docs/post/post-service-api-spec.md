# Mini Twitter API Documentation (Post Service)

Welcome to the Mini Twitter API documentation. This guide provides a comprehensive overview of the available API endpoints for the **Post Service**, including detailed descriptions, example requests, and responses.

<details>
<a id="create-post"></a>
<summary><b>Create a Post</b></summary>

**Endpoint:** `POST /api/posts`

**Description:** Creates a new post for a user.

**Request Body:**
```json
{
  "user_id": "user-123",
  "content": "This is my first post!"
}
```

**Response Body (Success):**
```json
{
  "data": {
    "id": "post-456",
    "user_id": "user-123",
    "content": "This is my first post!",
    "created_at": "2024-09-06T12:00:00Z"
  }
}
```

**Response Body (Failed):**
```json
{
  "errors": "Content cannot be empty."
}
```
</details>

<details>
<a id="view-individual-post-by-id"></a>
<summary><b>View Individual Post by ID</b></summary>

**Endpoint:** `GET /api/posts/{postId}`

**Description:**  Retrieves details of a specific post by its ID.

**Request Parameters::**
- postId: ID of the post to be fetched.

**Response Body (Success):**
```json
{
  "data": {
    "id": "post-123",
    "userId": "user-456",
    "content": "This is my first post!",
    "createdAt": "2024-09-07T09:00:00Z",
    "likes": 15,
    "comments": [
      {
        "id": "comment-789",
        "content": "Great post!",
        "userId": "user-789",
        "createdAt": "2024-09-07T09:30:00Z"
      }
    ]
  }
}
```

**Response Body (Failed):**
```json
{
  "errors": "Post not found"
}
```
</details>

<details>
<a id="fetch-user-posts"></a>
<summary><b>Fetch User Posts</b></summary>

**Endpoint:** `GET /api/users/{userId}/posts`

**Description:**  Retrieves all posts made by a specific user.

**Request Parameter:**
- userId : The unique identifier of the user whose posts are to be fetched.

**Response Body (Success):**
```json
{
  "data": [
    {
      "id": "post-456",
      "user_id": "user-123",
      "content": "This is my first post!",
      "created_at": "2024-09-06T12:00:00Z"
    },
    {
      "id": "post-789",
      "user_id": "user-123",
      "content": "Excited to share more updates.",
      "created_at": "2024-09-06T14:00:00Z"
    }
  ]
}
```

**Response Body (Failed):**
```json
{
  "errors": "No posts found for this user."
}
```
</details>

<details>
<a id="delete-user-post"></a>
<summary><b>Delete Post Created by the User</b></summary>

**Endpoint:** `DELETE /api/users/{userId}/posts/{postId}`

**Description:** Delete Post Created by the User

**Request Parameter:**
- userId: ID of the user.
- postId: ID of the post to be deleted.

**Response Body (Success):**
```json
{
  "message": "Post deleted successfully."
}
```

**Response Body (Failed):**
```json
{
  "errors": "Post not found or you are not authorized to delete this post."
}
```

**Response Body (Unauthorized):**
```json
{
  "errors": "Unauthorized access. You can only delete your own posts."
}
```
</details>
