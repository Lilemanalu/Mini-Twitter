# 🐦 Mini Twitter - Social Media Platform

## Overview
**Mini Twitter** is a lightweight social media platform designed with a **microservices architecture** using Spring Boot. The platform allows users to create posts (tweets), like and comment on posts, and follow/unfollow other users. Each service is independently scalable, ensuring robust performance and flexibility.

## ✨ Features

### User Management:
- 🔍 View user profiles.
- ✍️ Register and log in using email and password.
- 👥 Follow/unfollow other users.
- 🔐 JWT-based secure authentication.

### Post Management:
- 📝 Create new posts (tweets) with text content.
- 🔍 View individual posts by ID.
- 🗑️ Delete posts created by the user.
- 📰 Fetch all posts by a specific user.

### Comment Management:
- 💬 Add comments to posts.
- 🔍 Fetch comments for a specific post.
- 🗑️ Delete comments from posts.

### Like Management:
- ❤️ Like or unlike posts.
- 🔍 Fetch the number of likes on a post.

### Follow Management:
- 👥 Follow/unfollow other users.
- 🔍 View followers and following lists.

---

## 🏗️ Microservices Architecture

Each feature is implemented as an independent microservice:
1. **User Service** - Handles user registration, login, and profile management.
2. **Post Service** - Manages tweet-related operations.
3. **Comment Service** - Handles post comments.
4. **Like Service** - Manages likes on posts.
5. **Follow Service** - Manages user follow/unfollow relationships.

Each service has its own database for data isolation and consistency, communicating via REST APIs.

---


## 📑 API Endpoints
Detailed information for each API endpoint can be found in the [API Specification Document](docs/api-spec.md).

## 🚀 Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Lilemanalu/mini-twitter.git