# Grocery Store API

This is a RESTful API for a **grocery store management system**, built with **Java**, **Spring Boot**, **Maven**, and **MongoDB**. It includes **stateless authentication** using **JWT** and input **validation** for secure and reliable data handling.

## 🔧 Technologies Used

- Java 17
- Spring Boot
- Spring Security (JWT - stateless auth)
- Maven
- MongoDB (NoSQL)
- Jakarta Validation (for request validation)
- Lombok 
- Swagger (OpenAPI)

## 📦 Features

The API supports full CRUD operations (Create, Read, Update, Delete) for the following entities:

- ✅ Categories  
- ✅ Employees  
- ✅ Suppliers  
- ✅ Sales  
- ✅ Products  
- ✅ Stock

  ### 🛡️ Authentication & Authorization

- **JWT-based stateless authentication**
- Role-based access control with customizable roles (e.g., `ADMIN`, `USER`)
- Endpoints are secured using Spring Security
- Users must authenticate to access protected routes


