# 🛒 E-commerce API (Spring Boot)

## 📌 Overview

This project is a backend **E-commerce API** built using Spring Boot. It provides RESTful endpoints to manage customers, products, sellers, and orders, along with features like category-based filtering, price range queries, and stock management.

---

## 🚀 Tech Stack

* Java
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Maven

---

## 🧱 Project Structure

The project follows a layered architecture:

* **Controller** → Handles API requests
* **Service** → Business logic
* **Repository** → Database interaction using JPA
* **Model** → Entity classes
* **DTOs** → Data transfer objects
* **Converters** → Entity ↔ DTO conversion
* **Exceptions** → exception handling

---

## 🔗 Entity Relationships

* **Aadhar ↔ Customer** → One-to-One
* **Customer → Orders** → One-to-Many
* **Seller → Products** → One-to-Many
* **Order ↔ Products** → Many-to-Many

---

## ✨ Features

### 👤 Customer

* Add customer
* Get customer details

### 📦 Product

* Add product
* Get products by category
* Get products within price range (min–max)
* Get out-of-stock products
* Get in-stock products

### 🛍️ Order

* Place order
* Get order details

### 🏪 Seller

* Add seller
* Get seller by ID
* Update seller by ID
* Delete seller by ID

### 🆔 Aadhar

* Add Aadhar details

---

## 📡 API Endpoints (Sample)

### Customer APIs

* `POST /api/v1/customer`
* `GET /api/v1/customer?id=`

### Product APIs

* `POST /api/v1/product`
* `GET /api/v1/product?category=`
* `GET /api/v1/product/min/{min}/max/{max}`
* `GET /api/v1/product/outOfStock`
* `GET /api/v1/product/inStock`

### Order APIs

* `POST /api/v1/order?customer-id=`
* `GET /orders?value=`

### Seller APIs

* `POST /api/v1/seller`
* `GET /api/v1/seller/id/{id}`
* `PUT /api/v1/seller/id/{id}?mobNo=?`
* `DELETE /api/v1/seller/id/{id}`

### Aadhar API

* `POST /api/v1/aadhar`

---

## 🗄️ Database

* MySQL is used as the database
* JPA/Hibernate is used for ORM
* Entity relationships are implemented using annotations like:

  * `@OneToOne`
  * `@OneToMany`
  * `@ManyToMany`

---

## ▶️ How to Run the Project

1. Clone the repository
2. Open in IntelliJ
3. Configure MySQL database in `application.properties`
4. Run the Spring Boot application
5. Use Postman to test APIs

---

## ⚙️ Key Concepts Used

* REST API design
* DTO pattern for clean responses
* Layered architecture
* Exception handling
* JPA derived query methods
* Relationship mapping

---

## 🔮 Future Improvements

* Add authentication & authorization (JWT)
* Add pagination & sorting
* Implement cart functionality
* Add payment integration
* Improve validation and error handling

---

## 📬 Author

Developed as part of backend learning using Spring Boot.

---
