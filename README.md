# Mood-Related Weather

Mood-Related Weather --- это веб‑приложение, которое показывает текущую
погоду в выбранном городе и отображает случайный мем, соответствующий
типу погоды.

Проект состоит из backend части на Java Spring Boot и frontend части на
React.

---

## Технологии

Backend: - Java 19 - Spring Boot - Spring Security - JWT
Authentication - JPA / Hibernate - PostgreSQL

Frontend: - React - Vite - Tailwind CSS

Инфраструктура: - Docker - Docker Compose

API: - OpenWeather API

---

## Функциональность

Приложение позволяет:

- зарегистрироваться пользователю
- авторизоваться и получить JWT токен
- запросить погоду по названию города
- получить случайный мем, подходящий под текущую погоду

Типы погоды, которые поддерживаются:

- RAIN
- SNOW
- HOT
- COLD
- WIND
- CLOUDY
- CLEAR

Для каждого типа погоды в базе данных хранится набор мемов.

---

## Архитектура проекта

Проект разделён на две основные части:

Backend (Spring Boot) Frontend (React)

---

## Запуск проекта

### 1. Клонирование репозитория

git clone `<repository_url>`{=html}

cd mood-related-weather

---

### 2. Настройка OpenWeather API

Получите API ключ на сайте: https://openweathermap.org/

Добавьте его в application.yaml:

openweather:
api:
key: YOUR_API_KEY

---

### 3. Запуск через Docker

docker-compose up --build

После запуска:

Backend будет доступен на: http://localhost:8080

Frontend будет доступен на: http://localhost:5173

База данных PostgreSQL: порт 5432

---

## API

### Регистрация

POST /api/auth/register

пример запроса:

{ "username": "user", "email": "email@email.com "password": "password" }

---

### Логин

POST /api/auth/login

пример запроса:

{ "username": "user", "password": "password" }

ответ:

{ "token": "jwt_token" }

---

### Получение погоды

GET /api/weather/{city}

пример ответа:

{ "city": "Moscow", "temperature": 4.15, "description": "scattered
clouds", "meme": { "id": 18, "imageUrl":
"https://i.imgflip.com/3pnmg.jpg", "description": "Clouds everywhere",
"weatherType": "CLOUDY", "rating": 3 } }

---

## Инициализация данных

При первом запуске приложения автоматически:

- создаётся администратор
- в базу данных добавляются мемы
- каждый мем содержит:
  - ссылку на изображение
  - описание
  - тип погоды
  - рейтинг

Если таблица уже содержит данные, повторная инициализация не
выполняется.

---

## Frontend

Frontend написан на React.

Основные компоненты:

Weather --- отображает погоду MemeCard --- отображает мем

MemeCard показывает:

- изображение мема
- описание

---

## Безопасность

Для защиты API используется:

JWT (JSON Web Token)

После логина пользователь получает токен, который должен передаваться в
заголовке:

Authorization: Bearer TOKEN
