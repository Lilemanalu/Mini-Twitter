# Mini Twitter API Documentation (Like Service)

Welcome to the Mini Twitter API documentation. This guide provides a comprehensive overview of the available API endpoints for the **Like Service**, including detailed descriptions, example requests, and responses.

<details>
<a id="like-post"></a>
<summary><b>Like a Post</b></summary>

**Endpoint:** `POST /api/posts/{postId}/like`

**Description:** Likes a specific post.

**Request Parameters::**
- postId (Path Parameter): The unique identifier of the post to be liked.

**Response Body (Success):**
```json
{
  "message": "Post liked successfully."
}
```

**Response Body (Failed):**
```json
{
  "errors": "You have already liked this post."
}
```
</details>

<details>
<a id="unlike-post"></a>
<summary><b>Unlike a Post</b></summary>

**Endpoint:** `DELETE /api/posts/{postId}/like`

**Description:** Unlikes a specific post.

**Request Parameters::**
- postId (Path Parameter): The unique identifier of the post to be unliked.

**Response Body (Success):**
```json
{
  "message": "Post unliked successfully."
}
```

**Response Body (Failed):**
```json
{
  "errors": "You have not liked this post."
}
```
</details>

<details>
<a id="like-comment"></a>
<summary><b>Like a Comment</b></summary>

**Endpoint:** `POST /api/comments/{commentId}/like`

**Description:**  Likes a specific comment.

**Request Parameters::**
- commentId (Path Parameter): The unique identifier of the comment to be liked.

**Response Body (Success):**
```json
{
  "message": "Comment liked successfully."
}
```

**Response Body (Failed):**
```json
{
  "errors": "You have already liked this comment."
}
```
</details>

<details>
<a id="unlike-comment"></a>
<summary><b>Unlike a Comment</b></summary>

**Endpoint:** `DELETE /api/comments/{commentId}/like`

**Description:** Unlikes a specific comment.

**Request Parameters::**
- commentId (Path Parameter): The unique identifier of the comment to be unliked.

**Response Body (Success):**
```json
{
  "message": "Comment unliked successfully."
}
```

**Response Body (Failed):**
```json
{
  "errors": "You have not liked this comment."
}
```
</details>

<details>
<a id="fetch-number-of-likes-on-a-post"></a>
<summary><b>Fetch the Number of Likes on a Post</b></summary>

**Endpoint:** `GET /api/posts/{postId}/likes`

**Description:** Fetches the total number of likes on a specific post.

**Request Parameters::**
- postId (Path Parameter): The unique identifier of the post to fetch the number of likes for.

**Response Body (Success):**
```json
{
  "data": {
    "postId": "post-123",
    "likeCount": 25
  }
}
```

**Response Body (Failed):**
```json
{
  "errors": "Post not found."
}
```
</details>

<details>
<a id="fetch-number-of-likes-on-a-comment"></a>
<summary><b>Fetch the Number of Likes on a Comment</b></summary>

**Endpoint:** `GET /api/comments/{commentId}/likes`

**Description:** Fetches the total number of likes on a specific comment.

**Request Parameters:**
- commentId (Path Parameter): The unique identifier of the comment to fetch the number of likes for.

**Response Body (Success):**
```json
{
  "data": {
    "commentId": "comment-456",
    "likeCount": 10
  }
}
```

**Response Body (Failed):**
```json
{
  "errors": "Comment not found."
}
```
</details>
