# Professional Full Stack Authentication System
Professional authentication system built with Spring Boot, React,Typescript and jwt authentication.

**Features:**
- JWT Authentication
- Email Verification
- Secure HTTP-only Cookie
- Role-Based Authorization

## Tech Stack
### Backend:
- Java 21
- Spring Boot
- Spring Security
- JWT 
- PostgreSQL
- Maven
- Docker
- Redis
- RabbitMQ

### Frontend:
- React
- Vite
- Typescript
- Tailwind CSS
- shadcn/ui
- Zustand
- React Router DOM
- Axios
- Zod

## Project Structure
```markdown
authorization
|
|──backend
|   |──src/
|       |──config/
|       |──constant/
|       |──controller/
|       |──dto/
|       |──entity/
|       |──exception/
|       |──producer/
|       |──repository/
|       |──service/
|       |──util/
|   |──pom.xml
|   |──Dockerfile
|
|──frontend
|   |──src/
|       |──app/
|       |──entities/
|       |──features/
|       |──pages/
|       |──shared/
|       |──widgets/
|   |──Dockerfile
|   |nginx.conf
|
|
└── docker-compose.yml
```

Agar FSD architecture ishlatilsa:

```markdown
frontend/src
│
├── app
├── pages
├── widgets
├── features
├── entities
├── shared
```
## Features
- User Registration
- Login/Logout
- Refresh Token Rotation
- Role-Based Access Control
- Email Verification
- Forgot Password
- Reset Password

## Authentication Flow
1. User login in with email and password
2. Backend validates credentials
3. Access token is returned
4. Refresh token stored in HTTP-only cookie

## Environment Variables
#### Backend
```dotenv
PORT=
DB_NAME=
DB_HOST=
DB_PORT=
DB_USER=
DB_PASS=
JWT_SECRET=
JWT_ACCESS_TIME=
JWT_REFRESH_TIME=
SMTP_USER=
SMTP_PASS=
```
#### Frontend
```dotenv
VITE_API_URL=http://localhost:8080/api/v1
```
## Installation

#### Backend:
```text
cd backend
mvn clean install
mvn spring-boot:run
```
#### Frontend
```text
cd frontend
npm install
npm run dev
```
#### Docker
```text
docker compose up --build
```