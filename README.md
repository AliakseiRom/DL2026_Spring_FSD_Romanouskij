# Mood Weather App 🌦️😂

A full-stack web application that shows the current weather for a selected city and displays a random meme related to that weather.

The project combines a **Spring Boot backend**, **React frontend**, **PostgreSQL database**, and **Docker** for containerized deployment.

---

# 📌 Project Idea

The goal of the project is to make weather information more entertaining.

Instead of showing only temperature and weather description, the application also displays a **random meme that matches the current weather conditions**.

For example:

| Weather | Meme        |
| ------- | ----------- |
| Rain    | Rain memes  |
| Snow    | Snow memes  |
| Clear   | Sunny memes |
| Cloudy  | Cloud memes |

---

# 🛠 Tech Stack

## Backend

- Java 19
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- PostgreSQL
- Lombok
- RestTemplate
- OpenWeather API

## Frontend

- React
- Vite
- Axios
- TailwindCSS

## DevOps

- Docker
- Docker Compose

---

# 🏗 Project Architecture

```
frontend (React)
        |
        | HTTP REST API
        |
backend (Spring Boot)
        |
        | JPA
        |
PostgreSQL
        |
External API
(OpenWeather API)
```

---

# 📂 Project Structure

```
project-root
│
├── src(backend)
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── dto
│   ├── config
│   └── util
│
├── front-end
│   ├── components
│   ├── pages
│   ├── services
│   └── context
│
├── docker-compose.yml
├── Dockerfile.backend
└── README.md
```

---

# 🔐 Authentication

Authentication is implemented using **JWT tokens**.

User flow:

1. User registers
2. User logs in
3. Backend generates JWT token
4. Token is stored in frontend
5. Token is sent in requests to protected endpoints

Protected endpoints require authentication.

---

# 🌤 Weather API Integration

Weather data is fetched from:

**OpenWeather API**

```
https://api.openweathermap.org
```

The backend converts weather conditions into internal enum types:

```
RAIN
SNOW
CLEAR
CLOUDY
COLD
HOT
WIND
```

Then a **random meme** with the corresponding weather type is selected from the database.

---

# 😂 Meme System

Memes are stored in the database with the following fields:

```
id
imageUrl
description
weatherType
rating
```

Example meme:

```
description: "When it rains and you forgot umbrella"
imageUrl: https://i.imgflip.com/30b1gx.jpg
weatherType: RAIN
rating: 5
```

When the weather endpoint is called, the backend:

1. Gets weather from OpenWeather
2. Maps weather to WeatherType
3. Selects a random meme
4. Returns weather + meme

---

# 📡 API Endpoints

## Authentication

### Register

```
POST /api/auth/register
```

### Login

```
POST /api/auth/login
```

---

## Weather

Get weather and meme.

```
GET /api/weather/{city}
```

Example:

```
GET /api/weather/Moscow
```

Response:

```json
{
  "city": "Moscow",
  "temperature": 12.3,
  "description": "scattered clouds",
  "meme": {
    "id": 5,
    "imageUrl": "https://i.imgflip.com/3pnmg.jpg",
    "description": "Clouds everywhere",
    "weatherType": "CLOUDY",
    "rating": 3
  }
}
```

---

## Memes

Get all memes:

```
GET /api/memes
```

Add meme:

```
POST /api/memes
```

Delete meme:

```
DELETE /api/memes/{id}
```

---

# 🗄 Database

Database: **PostgreSQL**

Docker configuration:

```
POSTGRES_DB=mood_weather
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
```

Memes are automatically initialized on first application startup.

---

# 🐳 Running with Docker

Start the entire project using Docker Compose:

```
docker-compose up --build
```

Services:

| Service    | Port |
| ---------- | ---- |
| Frontend   | 5173 |
| Backend    | 8080 |
| PostgreSQL | 5432 |

---

# 🌍 Application URLs

Frontend:

```
http://localhost:5173
```

Backend API:

```
http://localhost:8080/api
```

---

# 📜 License

This project is open source and available under the MIT License.
