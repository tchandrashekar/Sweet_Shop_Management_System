**🍬 Sweet Shop Management System – Backend (Spring Boot)
📌 Project Overview**

The Sweet Shop Management System is a Spring Boot RESTful backend application designed to manage sweets inventory, user authentication, purchasing, and restocking operations.
The application is secured using JWT-based authentication and role-based authorization.

This repository contains only the backend implementation. The frontend will be integrated later.

**🛠️ Tech Stack**

Java

Spring Boot

Spring Security

JWT Authentication

Spring Data JPA

MySQL

Hibernate

Maven

**✨ Features**

User Registration & Login

JWT Token Generation

Role-based Authorization (ADMIN / USER)

Sweet Management (CRUD)

Purchase Sweets

Restock Sweets

Secure APIs using Spring Security

Exception Handling

RESTful API Design

**🔐 Authentication & Authorization**

Authentication is implemented using JWT tokens

Tokens must be sent in the Authorization header:

Authorization: Bearer <JWT_TOKEN>


Role-based access control:

ADMIN: Add, update, delete, restock sweets

USER: View sweets and purchase sweets

📂 **Project Structure**
com.sweetshop.Sweet_Shop_Management
│
├── Config          → Security & CORS configuration

├── Controller      → REST Controllers

├── Service         → Business logic

├── Repository      → JPA Repositories

├── Entity          → Database entities

├── DTO             → Request & Response objects

├── Exception       → Custom exception handling

└── SweetShopApplication.java

**🔗 API Endpoints**
🔑 Authentication
Method	Endpoint	Description
POST	/api/auth/register	Register new user
POST	/api/auth/login	Login & get JWT token
🍭 Sweet Management
Method	Endpoint	Access
GET	/api/sweets	USER, ADMIN
POST	/api/sweets	ADMIN
PUT	/api/sweets/{id}	ADMIN
DELETE	/api/sweets/{id}	ADMIN
POST	/api/sweets/restock/{id}	ADMIN
POST	/api/sweets/purchase/{id}	USER

**⚙️ Configuration**
Application Properties

Update application.properties with your DB credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/sweetshop
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

**▶️ How to Run the Project**

Clone the repository

git clone https://github.com/your-username/sweet-shop-backend.git


Open the project in NetBeans / IntelliJ

Update database configuration

Run:

mvn spring-boot:run


Server will start at:

http://localhost:8080

**🧪 Testing**

APIs can be tested using Postman

Use JWT token in request headers after login

**🚀 Future Enhancements**

React frontend integration

Pagination & sorting

API documentation using Swagger

**👤 Author**

Tanneeru Chandrashekar
Backend Developer | Java | Spring Boot
Dockerization


**OutPut ScreenShots**
<img width="1861" height="794" alt="Screenshot 2025-12-14 181545" src="https://github.com/user-attachments/assets/7167892c-d95e-4c09-9c21-90ac866ac874" />

<img width="1913" height="744" alt="Screenshot 2025-12-14 181559" src="https://github.com/user-attachments/assets/ea6f2b81-c574-478c-afc8-590d1be68c54" />

<img width="1904" height="808" alt="Screenshot 2025-12-14 181613" src="https://github.com/user-attachments/assets/a39496fe-6a7c-4a8a-bad3-012ed10dc82a" />

<img width="1919" height="870" alt="Screenshot 2025-12-14 181629" src="https://github.com/user-attachments/assets/91bd0b22-9f73-45f5-80b2-8f8bc87355de" />

<img width="1888" height="911" alt="Screenshot 2025-12-14 181644" src="https://github.com/user-attachments/assets/2cfd224e-7172-4841-82ac-ceb1fa7a3644" />

<img width="1900" height="849" alt="Screenshot 2025-12-14 181658" src="https://github.com/user-attachments/assets/2a9d4feb-ceae-48c0-a9a7-8f92c412d582" />

<img width="1919" height="821" alt="Screenshot 2025-12-14 181713" src="https://github.com/user-attachments/assets/f80df4b7-1c66-4f73-843d-ed0cc278c00c" />

<img width="1848" height="844" alt="Screenshot 2025-12-14 181726" src="https://github.com/user-attachments/assets/1a9dfaab-c358-49b6-9187-131be6a5be2b" />

<img width="1903" height="742" alt="Screenshot 2025-12-14 181813" src="https://github.com/user-attachments/assets/4c4df0b7-6a50-42c6-97dc-eff86dcb2026" />

<img width="1659" height="892" alt="Screenshot 2025-12-14 184134" src="https://github.com/user-attachments/assets/4f2f20e8-1262-4e7c-83f9-d88230d5d0bc" />
