# Mini Twitter API Documentation (Comment Service)

Welcome to the Mini Twitter API documentation. This guide provides a comprehensive overview of the available API endpoints for the **Comment Service**, including detailed descriptions, example requests, and responses.

<details>
<a id="add-comment"></a>
<summary><b>Add a Comment</b></summary>

**Endpoint:** `POST /api/posts/{postId}/comments`

**Description:** Adds a new comment to a post.

**Request Parameters::**
- postId: ID of the post to which the comment is being added.

**Request Body:**
```json
{
  "user_id": "user-123",
  "comment": "Great post!"
}
```

**Response Body (Success):**
```json
{
  "data": {
    "id": "comment-456",
    "post_id": "post-789",
    "user_id": "user-123",
    "comment": "Great post!",
    "created_at": "2024-09-06T15:00:00Z"
  }
}
```

**Response Body (Failed):**
```json
{
  "errors": "Comment cannot be empty."
}
```
</details>

<details>
<a id="fetch-comments-for-post"></a>
<summary><b>Fetch Comments for a Specific Post</b></summary>

**Endpoint:** `GET /api/posts/{postId}/comments`

**Description:**  Fetches all comments associated with a specific post.

**Request Parameters::**
- postId: ID of the post whose comments are being fetched.

**Response Body (Success):**
```json
{
  "data": [
    {
      "id": "comment-123",
      "postId": "post-456",
      "userId": "user-789",
      "content": "This is a great post!",
      "createdAt": "2024-09-07T10:00:00Z"
    },
    {
      "id": "comment-124",
      "postId": "post-456",
      "userId": "user-654",
      "content": "Thanks for sharing!",
      "createdAt": "2024-09-07T10:05:00Z"
    }
  ]
}
```

**Response Body (Failed):**
```json
{
  "errors": "No comments found for this post."
}
```
</details>

<details>
<a id="delete-comment-from-post"></a>
<summary><b>Delete Comment from Post</b></summary>

**Endpoint:** `DELETE /api/posts/{postId}/comments/{commentId}`

**Description:**  Deletes a specific comment from a post.

**Request Parameters::**
- postId: ID of the post from which the comment will be deleted.
- commentId: ID of the comment to be deleted.

**Response Body (Success):**
```json
{
  "message": "Comment deleted successfully."
}
```

**Response Body (Failed):**
```json
{
  "errors": "Comment not found or you are not authorized to delete this comment."
}
```

**Response Body (Failed):**
```json
{
  "errors": "Unauthorized access. You can only delete your own comments."
}
```
</details>


