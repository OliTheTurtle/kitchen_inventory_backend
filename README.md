# Kitchen Inventory Backend

This project is a backend service for managing a kitchen inventory, built with Java and Spring Boot. It provides RESTful APIs to manage items and locations, and is designed to be run in a containerized environment.

## Features
- CRUD operations for inventory items
- CRUD operations for locations
- Sorting and filtering of items (e.g., by best-before date, name)
- Validation and error handling
- Docker support for easy deployment

## Project Structure
```
java_backend/
  ├── src/
  │   ├── main/java/de/gras/java_backend/
  │   │   ├── API/controllers/         # REST controllers
  │   │   ├── API/mappers/             # DTO mappers
  │   │   ├── API/models/              # Request/response models
  │   │   ├── BIZ/                     # Business logic
  │   │   ├── DATA/orm/                # ORM entities
  │   │   └── DATA/repositories/       # Data repositories
  │   └── resources/                   # Application config, static, templates
  ├── Dockerfile                       # Docker build file
  ├── DockerBuild.sh                   # Docker build script
  ├── pom.xml                          # Maven project file
  └── ...
psql_ddl/
  ├── ddl/                             # SQL DDL scripts for PostgreSQL
  ├── Dockerfile                       # Docker build file for DB
  └── DockerBuild.sh                   # Docker build script for DB
```

## Getting Started

### Prerequisites
- Java 17+
- Maven
- Docker (for containerized deployment)
- PostgreSQL (or use the provided DDL scripts)

### Build and Run (Locally)
1. Clone the repository:
   ```bash
   git clone <repo-url>
   cd kitchen_inventory_backend/java_backend
   ```
2. Build the project:
   ```bash
   ./mvnw clean package
   ```
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
4. The API will be available at `http://localhost:8080`.

### Build and Run (Docker)
1. Build the Docker image:
   ```bash
   ./DockerBuild.sh
   ```
2. Run the container:
   ```bash
   docker compose up -d
   ```

## API Endpoints
- `GET /items` - List all items (supports sorting: `orderBy`, `direction`)
- `GET /items/{itemId}` - Get item by ID
- `POST /items` - Create a new item
- `PUT /items/{itemId}` - Update an item
- `DELETE /items/{itemId}` - Delete an item
- Similar endpoints for locations

## Database
- PostgreSQL is used as the database.
- DDL scripts are provided in `psql_ddl/ddl/`.

## Testing
- Unit and integration tests are located in `src/test/java/`.
- To run tests:
  ```bash
  ./mvnw test
  ```

---
Feel free to contribute or open issues for improvements!
