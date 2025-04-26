Rittima Microservices Project

This project is a Spring Boot Microservices Architecture featuring multiple services communicating with each other, built with Java, Spring Cloud, Spring Security, MongoDB, and integrated payment via Razorpay.
🚀 Technologies Used
Java 8+

Spring Boot

Spring Cloud (Eureka, Zuul)

Spring Security

MongoDB

Razorpay Payment Gateway

Maven

⚙️ How to Run
Start the Discovery Server

Run the discovery-server application first.

URL: http://localhost:8761/

Start Other Microservices

Start admin, customer, washer, order, spring-razorpay services.

Start Zuul API Gateway

Run zuul-security service.

API Gateway will route requests to other services.

Access Application

API Gateway URL: http://localhost:8080/

All routes should be prefixed through Zuul.

📸 MongoDB & UML
MongoDB is used as the main database for microservices.

UML diagrams and screenshots for database structure and services are included in the repository.

📚 Setup Requirements
Java JDK 8+

Maven

MongoDB (local or Atlas cloud)

Razorpay account (for payment integration)

✨ Author
Rittima


