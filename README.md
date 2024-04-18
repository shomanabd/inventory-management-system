# Inventory Management System

This project is an Inventory Management System designed to track and manage inventory items across warehouses, orders, and users.

## Description

The Inventory Management System consists of the following core resources:

1. **Warehouse**: Represents the physical locations where inventory is stored.
2. **Product**: Represents the individual products or items being managed in the inventory.
3. **Order**: Represents a request to purchase or move inventory.
4. **User**: Represents individuals who interact with the inventory management system (e.g., customers, staff).

Each resource has relationships with other resources, allowing for the tracking, storage, and movement of inventory items across various locations and orders.

[Inventory Management System API - Swagger Hub](https://app.swaggerhub.com/apis/ABOSALAMEABD/inventory-management-system/1.0.0#/)

| HTTP Request       | Operation Description          | HTTP Status Codes            | Request Sample        | Response Sample                                 |
|--------------------|--------------------------------|------------------------------|-----------------------|------------------------------------------------|
| GET /warehouse   | Retrieves all warehouses      | 200: Success <br> 500: Internal server error | GET /warehouses | ```json { "warehouses": [ { "id": 1, "name": "Warehouse 1", "location": "Location 1" }, { "id": 2, "name": "Warehouse 2", "location": "Location 2" } ] }``` |
| POST /warehouse  | Creates a new warehouse       | 201: Created <br> 400: Bad request <br> 500: Internal server error | POST /warehouses | ```json { "id": 1, "name": "Warehouse 1", "location": "Location 1" }``` |
| GET /warehouse/{id} | Retrieves a specific warehouse by ID | 200: Success <br> 404: Not found <br> 500: Internal server error | GET /warehouses/1 | ```json { "id": 1, "name": "Warehouse 1", "location": "Location 1" }``` |
| PUT /warehouse/{id} | Updates an existing warehouse | 200: Success <br> 400: Bad request <br> 404: Not found <br> 500: Internal server error | PUT /warehouses/1 | ```json { "id": 1, "name": "Updated Warehouse", "location": "Updated Location" }``` |
| DELETE /warehouse/{id} | Deletes a warehouse by ID   | 204: No content <br> 404: Not found <br> 500: Internal server error | DELETE /warehouses/1 | No content |

| GET /product      | Retrieves all products        | 200: Success <br> 500: Internal server error | GET /product | ```json { "product": [ { "id": 1, "name": "Product 1", "description": "Description 1", "price": 10.0 }, { "id": 2, "name": "Product 2", "description": "Description 2", "price": 20.0 } ] }``` |
| POST /product     | Creates a new product         | 201: Created <br> 400: Bad request <br> 500: Internal server error | POST /product | ```json { "id": 1, "name": "Product 1", "description": "Description 1", "price": 10.0 }``` |
| GET /product/{id} | Retrieves a specific product by ID | 200: Success <br> 404: Not found <br> 500: Internal server error | GET /product/1 | ```json { "id": 1, "name": "Product 1", "description": "Description 1", "price": 10.0 }``` |
| PUT /product/{id} | Updates an existing product   | 200: Success <br> 400: Bad request <br> 404: Not found <br> 500: Internal server error | PUT /product/1 | ```json { "id": 1, "name": "Updated Product", "description": "Updated Description", "price": 20.0 }``` |
| DELETE /product/{id} | Deletes a product by ID     | 204: No content <br> 404: Not found <br> 500: Internal server error | DELETE /product/1 | No content |

| GET /order       | Retrieves all orders          | 200: Success <br> 500: Internal server error | GET /order| ```json { "order": [ { "id": 1, "productId": 1, "quantity": 5, "status": "pending" }, { "id": 2, "productId": 2, "quantity": 10, "status": "shipped" } ] }``` |
| POST /order       | Creates a new order           | 201: Created <br> 400: Bad request <br> 500: Internal server error | POST /order | ```json { "id": 1, "productId": 1, "quantity": 5, "status": "pending" }``` |
| GET /order/{id}   | Retrieves a specific order by ID | 200: Success <br> 404: Not found <br> 500: Internal server error | GET /order/1 | ```json { "id": 1, "productId": 1, "quantity": 5, "status": "pending" }``` |
| PUT /order/{id}   | Updates an existing order     | 200: Success <br> 400: Bad request <br> 404: Not found <br> 500: Internal server error | PUT /order/1 | ```json { "id": 1, "productId": 1, "quantity": 10, "status": "shipped" }``` |
| DELETE /order/{id} | Deletes an order by ID      | 204: No content <br> 404: Not found <br> 500: Internal server error | DELETE /order/1 | No content |

| GET /user         | Retrieves all users           | 200: Success <br> 500: Internal server error | GET /user | ```json { "user": [ { "id": 1, "username": "user1", "email": "user1@example.com" }, { "id": 2, "username": "user2", "email": "user2@example.com" } ] }``` |
| POST /user        | Creates a new user            | 201: Created <br> 400: Bad request <br> 500: Internal server error | POST /user | ```json { "id": 1, "username": "user1", "email": "user1@example.com" }``` |
| GET /user/{id}    | Retrieves a specific user by ID | 200: Success <br> 404: Not found <br> 500: Internal server error | GET /user/1 | ```json { "id": 1, "username": "user1", "email": "user1@example.com" }``` |
| PUT /user/{id}    | Updates an existing user      | 200: Success <br> 400: Bad request <br> 404: Not found <br> 500: Internal server error | PUT /user/1 | ```json { "id": 1, "username": "updated_user1", "email": "updated_user1@example.com" }``` |
| DELETE /user/{id} | Deletes a user by ID         | 204: No content <br> 404: Not found <br> 500: Internal server error | DELETE /user/1 | No content |

## How to Run the Application

To run the application:

1. Clone the repository to your local machine.
2. **Build and run the application**:
   - Open a command line or terminal.
   - Navigate to the project directory.
   - Use Gradle to build and run the application:
     - For MacOS/Linux: `./gradlew bootRun`
     - For Windows: `.\gradlew.bat bootRun`
3. **Access the endpoint**:
   - Once the application is running, open your web browser.
   - Navigate to [http://localhost:8080/hello](http://localhost:8080/hello) to see a hello world message.

## ER diagram

![ER Diagram](https://github.com/shomanabd/inventory-management-system/assets/103745119/95bc986f-4d58-4311-88f1-4b8b3dc0d16f)


