# demoapi - Item Management System (Spring Boot)

## Project Overview
This project is a simple Java Spring Boot RESTful API developed to manage a collection of items. It demonstrates backend development using REST principles, input validation, and in-memory data storage. The API allows users to create, retrieve, update, and delete items similar to an e-commerce or movie management system.

## Technologies Used
- Java 17
- Spring Boot
- Maven
- REST API
- Git & GitHub

## Features
- Add a new item
- Get item by ID
- Get all items
- Update an item
- Delete an item
- Input validation
- Global exception handling
- In-memory data storage using ArrayList

## How to Run the Application

1. Clone the repository:
git clone https://github.com/rathig123/demoapi.git

2. Go to the project directory:
cd demoapi

3. Run the application:
mvn spring-boot:run

The server will start at:
http://localhost:8080

## API Endpoints

Add Item (POST):
/api/items

Sample Request Body:
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 60000
}

Get All Items (GET):
/api/items

Get Item by ID (GET):
/api/items/{id}

Update Item (PUT):
/api/items/{id}

Sample Request Body:
{
  "name": "Updated Laptop",
  "description": "Updated Description",
  "price": 65000
}

Delete Item (DELETE):
/api/items/{id}

## Validation Rules
- name is required
- description is required
- price is required
If validation fails, the API returns meaningful error messages.

## Implementation Details
- Layered architecture (Controller, Service, Model)
- RESTful API design
- In-memory storage using ArrayList
- Exception handling using @RestControllerAdvice
- Unique ID generation using AtomicLong

## Live Demo (Deployed Application)
https://demoapi-35vc.onrender.com

## Author
Developed by Rathi G
