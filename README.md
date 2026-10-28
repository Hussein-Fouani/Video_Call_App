# Video Call Application

A video meeting web app with a Spring Boot user API and a static HTML/JavaScript front end. Video calls, in-call text chat and screen sharing are provided by the [ZEGOCLOUD UIKit](https://www.zegocloud.com/) prebuilt component.

## Tech Stack

- Java 17, Spring Boot 3.1 (Spring Web)
- Lombok
- HTML, CSS, vanilla JavaScript
- ZEGOCLOUD UIKit Prebuilt (video conferencing, text chat, screen sharing)

## Features

- Register, log in and log out (users are kept in memory, three demo users are created at startup)
- List registered users with their online/offline status
- Create a new meeting or join an existing one by room ID
- In the meeting: camera/microphone toggles, text chat, screen sharing, user list (max 2 participants)

Note: users are stored in an in-memory list, so all data is lost on restart. There is no database and passwords are stored and compared in plain text; this is a learning project, not production code.

## Getting Started

### Prerequisites

- JDK 17

### Run

```bash
git clone https://github.com/Hussein-Fouani/Video_Call_App.git
cd Video_Call_App
./mvnw spring-boot:run
```

Open `http://localhost:8080/login.html`. You can register a new account or log in with a demo user, e.g. `hsen@gmail.com` / `AAA`.

To use your own ZEGOCLOUD project, replace `appID` and `serverSecret` in `src/main/resources/static/videocall.html`.

## API Endpoints

| Method | Path | Body | Description |
|--------|------|------|-------------|
| POST | `/api/v1/users` | `{ "username", "email", "password" }` | Register a user |
| POST | `/api/v1/users/login` | `{ "email", "password" }` | Log in, returns the user |
| POST | `/api/v1/users/logout` | `{ "email" }` | Mark the user offline |
| GET | `/api/v1/users` | | List all users |
