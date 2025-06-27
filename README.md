# Chat App Backend

A Spring Boot backend for a real-time chat application supporting private messaging, contacts/friends management, and notifications using WebSocket (STOMP).

---

##  Features

* User registration and login with JWT authentication.
* One-on-one (private) chat creation.
* Real-time messaging using WebSocket (STOMP protocol).
* Friend request system (send, accept, reject).
* Notification system for messages and friend actions.
* Persistent message storage.

---

## Technologies Used

* Java 
* Spring Boot 
* Spring Security + JWT
* Spring Data JPA (Hibernate)
* WebSocket (STOMP protocol)
* H2/PostgreSQL/MySQL (JPA-compatible DB)
* Lombok

---

##  Getting Started

### Prerequisites

* Java 17+
* Maven
* A compatible database (e.g., H2, PostgreSQL)

### Run the App

```bash
./mvnw spring-boot:run
```

Or via your IDE (IntelliJ, Eclipse)

---

## 🔎 API Reference

### 🔑 Authentication

**POST** `/api/auth/register`

* Register a new user

```json
{
  "firstName": "sofia",
  "lastName": "yussef",
  "email": "sofia@gmail.com",
  "password": "123456"
}
```

**POST** `/api/auth/login`

* Authenticate and return JWT

```json
{
  "email": "sofia@gmail.com",
  "password": "123456"
}
```

---

### 💬 Chat

**POST** `/api/chats`

* Create a chat (group or private)

```json
{
  "chatName": "",
  "group": false,
  "participantEmails": ["sofia@gmail.com", "ahmed@gmail.com"]
}
```

**POST** `/api/chats/private?user1={receiverEmail}`

* Get or create a private chat with another user

**GET** `/api/chats/{chatId}/messages`

* Get messages in a chat

---

### 📨 Messaging

**STOMP Endpoint** `/ws`

**Client Sends** to: `/app/chat.send`

```json
{
  "chatId": 1,
  "senderEmail": "sofia@gmail.com",
  "content": "Hello!",
  "messageType": "TEXT"
}
```

**Subscribed Users Receive** at: `/user/queue/messages`

---

###  Contacts

**POST** `/api/contacts/request`

* Send friend request

```json
{
  "receiver": "ahmed@gmail.com"
}
```

**GET** `/api/contacts/request/pending`

* Get pending requests sent to current user

**GET** `/api/contacts/request/accepted`

* Get accepted friends list

**PATCH** `/api/contacts/{senderEmail}/response?action=ACCEPTED|REJECTED`

* Accept or reject a request

---

###  Notifications (WebSocket)

* Friend request sent: `/topic/friend-request`
* Friend request response: `/topic/friend-request-response`
* New message: `/user/queue/messages`

---

##  Database Schema Overview

* **User**: Basic user info, credentials.
* **Chat**: Represents a conversation.
* **ChatParticipant**: Many-to-many join of users to chats.
* **Message**: Chat messages.
* **Contact**: Friend request/relationship.

---

##  Security

* JWT-based authentication for all endpoints.
* STOMP WebSocket authentication using JWT in handshake headers.

---

##  Future Enhancements

* Group chat admin roles
* Message deletion/editing
* Seen/read indicators
* Typing indicators

---

## 💼 Author

**Mai Atef Elkheshen**

---

## ✅ License

MIT License
