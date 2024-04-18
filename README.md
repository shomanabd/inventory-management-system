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
| GET /warehouses   | Retrieves all warehouses      | 200: Success <br> 500: Internal server error | GET /warehouses | ```json { "warehouses": [ { "id": 1, "name": "Warehouse 1", "location": "Location 1" }, { "id": 2, "name": "Warehouse 2", "location": "Location 2" } ] }``` |
| POST /warehouses  | Creates a new warehouse       | 201: Created <br> 400: Bad request <br> 500: Internal server error | POST /warehouses | ```json { "id": 1, "name": "Warehouse 1", "location": "Location 1" }``` |
| GET /warehouses/{id} | Retrieves a specific warehouse by ID | 200: Success <br> 404: Not found <br> 500: Internal server error | GET /warehouses/1 | ```json { "id": 1, "name": "Warehouse 1", "location": "Location 1" }``` |

*Continue the table with the rest of the API endpoints...*

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
   - Navigate to [http://localhost:808/hello](http://localhost:808/hello) to see a hello world message.

## ER diagram

![ER diagram](https://github.com/shomanabd/inventory-management-system/assets/103745119/95bc986f-4d58-4311-88f1-4b8b3dc0d16f)
