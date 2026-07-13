# Kolor ERP API

REST API for the Kolor Smoothies ERP System.

Built using Spring Boot following layered architecture and RESTful design principles.

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- JWT Authentication
- Maven
- Lombok

---

## Architecture

```
Controller
      ↓
Service
      ↓
Repository
      ↓
Database
```

Project follows:

- DTO Pattern
- Mapper Pattern
- Service Layer
- Repository Layer
- Global Exception Handling
- JWT Security
- Role Based Authorization

---

## Modules

### Authentication

- Login
- JWT Token Generation
- User Authentication

### User Management

- CRUD
- Role Management

### Category

- Create
- Update
- Delete
- Search
- Pagination

### Product

- Create
- Update
- Delete
- Search
- Pagination

---

## Features

- JWT Authentication
- Spring Security
- Role-Based Access Control
- Validation
- Global Exception Handling
- Standard API Response
- Pagination
- Search APIs
- Audit Fields
- Soft Delete Support

---

## Project Structure

```
src/main/java
 ├── auth
 ├── category
 ├── common
 ├── config
 ├── exception
 ├── product
 ├── security
 ├── user
 └── util
```

---

## Database

MySQL

Configure database in

```
application.properties
```

Example

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/kolor_erp
spring.datasource.username=root
spring.datasource.password=******
```

---

## Run Application

```bash
mvn spring-boot:run
```

Application runs on

```
http://localhost:8080
```

---

## API Base URL

```
http://localhost:8080/api
```

---

## Security

Protected using JWT.

Authorization Header

```
Authorization: Bearer <token>
```

---

## Status

Completed

- Authentication
- User Module
- Category Module
- Product Module

Upcoming

- Inventory
- Purchase
- Sales
- Finance
- Reports
- Settings

---

## Author

Pravalika Voorakkara
