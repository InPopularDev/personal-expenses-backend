# Chiro - Gestor de Finanzas Personales (Backend)

Chiro es una API robusta construida con Spring Boot para la gestión de finanzas personales, permitiendo a los usuarios rastrear sus ingresos, gastos y categorizar sus transacciones de manera eficiente.

## 🛠 Tecnologías Utilizadas

![Java](https://img.shields.io/badge/Java-21-red?logo=openjdk)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-6DB33F?logo=springboot)  
![Spring Security](https://img.shields.io/badge/Spring%20Security-Security-6DB33F?logo=springsecurity)  
![JWT](https://img.shields.io/badge/JWT-Java%20Web%20Token-black?logo=jsonwebtokens)  
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?logo=postgresql)  
![Hibernate](https://img.shields.io/badge/Hibernate-JPA-59666C?logo=hibernate)  
![Lombok](https://img.shields.io/badge/Lombok-IDEA-orange)

## 🚀 Endpoints y Pruebas en Postman

La URL base para todos los endpoints es: `http://localhost:8080/api/v1`

### 🔐 Autenticación (`/auth`)

| Método | Endpoint | Descripción | Cuerpo de la Petición (JSON) |
| :--- | :--- | :--- | :--- |
| POST | `/auth/register` | Registro de nuevo usuario | `{ "username": "user", "password": "123", "confirmPassword": "123" }` |
| POST | `/auth/login` | Inicio de sesión | `{ "username": "user", "password": "123" }` |
| POST | `/auth/refresh-token` | Refrescar el Access Token | Envía la cookie `refreshToken` automáticamente. |
| POST | `/auth/logout` | Cierre de sesión | Limpia las cookies del navegador. |
| GET | `/auth/me` | Obtener info del usuario actual | Requiere estar autenticado (Cookie `accessToken`). |

### 📂 Categorías (`/category`)

| Método | Endpoint | Descripción | Cuerpo de la Petición (JSON) |
| :--- | :--- | :--- | :--- |
| GET | `/category` | Listar categorías del usuario | N/A |
| POST | `/category` | Crear una nueva categoría | `{ "name": "Comida", "type": "EXPENSE" }` |

### 💸 Transacciones (`/transaction`)

| Método | Endpoint | Descripción | Cuerpo de la Petición (JSON) |
| :--- | :--- | :--- | :--- |
| GET | `/transaction/all` | Listar todas las transacciones | N/A |
| GET | `/transaction/filter` | Filtrar por tipo (`INCOME` o `EXPENSE`) | Query Param: `?type=INCOME` |
| POST | `/transaction` | Crear una transacción | `{ "categoryId": 1, "amount": 50.0, "description": "Almuerzo", "transactionDate": "2023-10-27" }` |

### 📝 Cómo probar en Postman

1. **Importante**: La aplicación utiliza `HttpOnly Cookies` para el `accessToken` y `refreshToken`. Postman maneja estas cookies automáticamente tras el login/registro.
2. Realiza un `POST` a `/auth/register` o `/auth/login`.
3. Verifica en la pestaña "Cookies" de Postman que se hayan guardado `accessToken` y `refreshToken`.
4. Para los endpoints protegidos (Categorías y Transacciones), simplemente realiza la petición; Postman enviará las cookies de sesión automáticamente.

---

## 📋 Lo que falta (Implementación pendiente)

| Funcionalidad / Tarea Pendiente | Responsable                                                                                                    | Status          |
| :--- |:---------------------------------------------------------------------------------------------------------------|:----------------|
| Implementación de controladores para el módulo `Dashboard` | <img src="https://github.com/Code-D-Garcia.png" width="24"/> [Code-D-Garcia](https://github.com/Code-D-Garcia) | 🚧 En progreso  |
| Endpoint `GET /category/{id}` en `CategoryController` | [   ]                                                                                                          | ⏳ Pendiente   |
| Endpoint `PUT /category/{id}` en `CategoryController` | [   ]                                                                                                                | ⏳ Pendiente     |
| Endpoint `DELETE /category/{id}` en `CategoryController` | [   ]  | ⏳ Pendiente     |
| Endpoint `GET /transaction/{id}` en `TransactionController` |[   ]  | ⏳ Pendiente     |
| Endpoint `PUT /transaction/{id}` en `TransactionController` | [   ]  | ⏳ Pendiente     |
| Endpoint `DELETE /transaction/{id}` en `TransactionController` | [   ] | ⏳ Pendiente     |
| Refactorización de `CategoryController` usando `CategoryService` | [   ]  | ⏳ Pendiente     |
| Manejo global de errores (`orElseThrow` personalizado) | [   ]  | ⏳ Pendiente     |

---

## 🔮 Futuras Mejoras

- **Módulo de Dashboard Dinámico**: Endpoints para obtener balances mensuales, gastos por categoría (gráficos) e historial comparativo.
- **Transacciones Recurrentes**: Automatización de gastos fijos (alquiler, suscripciones).
- **Exportación de Datos**: Generación de reportes en formato PDF o Excel (CSV).
- **Sistema de Presupuestos**: Establecer límites de gasto mensual por categoría y recibir alertas.
- **Notificaciones**: Alertas por correo electrónico sobre balances bajos o metas alcanzadas.

