# Chiro - Personal Finance Manager (Backend)

Chiro is a robust API built with Spring Boot for personal finance management, allowing users to track their income, expenses, and categorize transactions efficiently.

---
[**Leer en Español 🇪🇸**](README.es.md)
## 🛠 Technologies Used

![Java](https://img.shields.io/badge/Java-21-red?logo=openjdk)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-6DB33F?logo=springboot)  
![Spring Security](https://img.shields.io/badge/Spring%20Security-Security-6DB33F?logo=springsecurity)  
![JWT](https://img.shields.io/badge/JWT-Java%20Web%20Token-black?logo=jsonwebtokens)  
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?logo=postgresql)  
![Hibernate](https://img.shields.io/badge/Hibernate-JPA-59666C?logo=hibernate)  
![Lombok](https://img.shields.io/badge/Lombok-IDEA-orange)

---

## 🚀 API Endpoints & Postman Testing

The base URL for all endpoints is: `http://localhost:8080/api/v1`

---

### 🔐 Authentication (`/auth`)

| Method | Endpoint | Description | Request Body (JSON) |
| :--- | :--- | :--- | :--- |
| POST | `/auth/register` | Register a new user | `{ "username": "user", "password": "123", "confirmPassword": "123" }` |
| POST | `/auth/login` | User login | `{ "username": "user", "password": "123" }` |
| POST | `/auth/refresh-token` | Refresh access token | Sends `refreshToken` cookie automatically. |
| POST | `/auth/logout` | User logout | Clears browser cookies. |
| GET | `/auth/me` | Get current user info | Requires authentication (`accessToken` cookie). |

---

### 📂 Categories (`/category`)

| Method | Endpoint | Description | Request Body (JSON) |
| :--- | :--- | :--- | :--- |
| GET | `/category` | List user categories | N/A |
| POST | `/category` | Create a new category | `{ "name": "Food", "type": "EXPENSE" }` |

---

### 💸 Transactions (`/transaction`)

| Method | Endpoint | Description | Request Body / Params |
| :--- | :--- | :--- | :--- |
| GET | `/transaction/all` | List all transactions | N/A |
| GET | `/transaction/filter` | Filter by type (`INCOME` or `EXPENSE`) | `?type=INCOME` |
| POST | `/transaction` | Create a transaction | `{ "categoryId": 1, "amount": 50.0, "description": "Lunch", "transactionDate": "2023-10-27" }` |

---

## 📝 How to Test in Postman

1. The application uses **HttpOnly Cookies** for authentication (`accessToken` and `refreshToken`).
2. Send a `POST` request to `/auth/register` or `/auth/login`.
3. Check Postman cookies tab to confirm tokens are stored.
4. Use protected endpoints normally; cookies are sent automatically.

---

## 📋 Pending Tasks

| Functionality / Pending Task | Responsible | Status         |
| :--- | :--- |:---------------|
| Implementation of controllers for the `Dashboard` module | <img src="https://github.com/Code-D-Garcia.png" width="24"/> [Code-D-Garcia](https://github.com/Code-D-Garcia) | 🚧 In progress |
| Endpoint `GET /category/{id}` en `CategoryController` | <img src="https://github.com/Code-D-Garcia.png" width="24"/> [Code-D-Garcia](https://github.com/Code-D-Garcia)                                                                                                         | ✅ Check        |
| Endpoint `PUT /category/{id}` en `CategoryController` | <img src="https://github.com/Code-D-Garcia.png" width="24"/> [Code-D-Garcia](https://github.com/Code-D-Garcia)                                                                                                                | ✅ Check        |
| Endpoint `DELETE /category/{id}` en `CategoryController` | <img src="https://github.com/Code-D-Garcia.png" width="24"/> [Code-D-Garcia](https://github.com/Code-D-Garcia)  | ✅ Check        |
| `GET /transaction/{id}` endpoint in `TransactionController` | <img src="https://github.com/InPopularDev.png" width="24"/> [InPopularDev](https://github.com/InPopularDev)   | ✅ Check     |
| `PUT /transaction/{id}` endpoint in `TransactionController` | <img src="https://github.com/InPopularDev.png" width="24"/> [InPopularDev](https://github.com/InPopularDev) | ✅ Check     |
| `DELETE /transaction/{id}` endpoint in `TransactionController` | <img src="https://github.com/InPopularDev.png" width="24"/> [InPopularDev](https://github.com/InPopularDev) | ✅ Check     |
| Refactoring `CategoryController` to use `CategoryService` instead of direct implementation | [   ] | ⏳ Pending      |
| Global error handling (`orElseThrow` customization) | [   ] | ⏳ Pending      |

---

## 🔮 Future Improvements

- Dynamic Dashboard module with analytics and charts
- Recurring transactions automation
- Export data to PDF/CSV
- Budget system per category with alerts
- Email notifications for financial insights  