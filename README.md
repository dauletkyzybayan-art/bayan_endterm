Library API

This project is a simple backend application for managing a library system.
It was created as part of a university assignment to practice working with Spring Boot, REST APIs, and PostgreSQL.

The application provides basic CRUD functionality for books and demonstrates how a layered backend structure works in practice.

Project Goal

The main goal of this project was:

to build a RESTful API using Spring Boot

to connect the application to a PostgreSQL database

to organize the project using controller–service–repository architecture

to implement clean and understandable backend logic

Technologies

The project uses:

Java 17

Spring Boot

Spring Data JPA

PostgreSQL

Maven

All dependencies are managed through Maven.

Project Structure

The application follows a standard layered structure:

com.example.libraryapi
│
├── controller
│     └── BookController
│
├── service
│     └── BookService
│
├── repository
│     └── BookRepository
│
├── model
│     └── Book
│
└── LibraryApiApplication


Explanation:

Controller layer handles HTTP requests and responses

Service layer contains the business logic

Repository layer communicates with the database

Model represents the database entity

This separation makes the code easier to understand and maintain.

Database Setup

The project uses PostgreSQL.

Before running the application, you need to:

Install PostgreSQL

Create a database (for example: library)

Example configuration in application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/library
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


You can change the database name and credentials according to your local setup.

ddl-auto=update allows Hibernate to automatically create/update tables based on the entity classes.

API Endpoints

The application provides the following endpoints:

Method	Endpoint	Description
GET	/books	Get all books
GET	/books/{id}	Get book by ID
POST	/books	Add a new book
PUT	/books/{id}	Update existing book
DELETE	/books/{id}	Delete book by ID

All endpoints return JSON responses.

You can test the API using Postman or any REST client.

Example JSON (POST request)
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "year": 2008
}

How to Run

Clone the repository

Open the project in IntelliJ IDEA

Make sure PostgreSQL is running

Update database credentials in application.properties

Run LibraryApiApplication

After startup, the application will run on:

http://localhost:8080

What Was Implemented

REST controller with basic CRUD operations

Service layer for business logic

JPA repository for database access

Entity mapping with Hibernate

PostgreSQL integration

Clear project structure

Notes

This project focuses on backend development and database interaction.
It does not include frontend implementation.

The code is written in a straightforward way to keep it readable and easy to understand.
