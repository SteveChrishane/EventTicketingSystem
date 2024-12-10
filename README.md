# Event Ticketing System

This repository contains the backend and Java CLI components of the Event Ticketing System.

## Backend

The backend is a Spring Boot application that manages the ticketing system.

### Features

- Manage ticket pool
- Handle vendor and customer interactions
- Start and stop ticketing simulation

### Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher

### Setup

1. Clone the repository:

   ```sh
   git clone https://github.com/your-repo/event-ticketing-system.git
   cd event-ticketing-system/backend
   ```

2. Build the project:

   ```sh
   ./mvnw clean install
   ```

3. Run the application:
   ```sh
   ./mvnw spring-boot:run
   ```

### Configuration

The backend configuration is managed through the `Config` class in [backend/src/main/java/com/example/backend/config/Config.java](backend/src/main/java/com/example/backend/config/Config.java).

### Ticketing Service

The main service for managing the ticketing system is the `TicketingService` class in [backend/src/main/java/com/example/backend/service/TicketingService.java](backend/src/main/java/com/example/backend/service/TicketingService.java).

## Java CLI

The Java CLI is a command-line interface for interacting with the ticketing system.

### Features

- Load and save configuration
- Update configuration
- Simulate ticketing process

### Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher

### Setup

1. Navigate to the Java CLI directory:

   ```sh
   cd event-ticketing-system/Java CLI
   ```

2. Build the project:

   ```sh
   mvn clean install
   ```

3. Run the application:
   ```sh
   java -jar target/EventTicketingSystem-1.0-SNAPSHOT.jar
   ```

### Configuration

The CLI configuration is managed through the `Configuration` class in [Java CLI/src/main/java/com/company/Configuration.java](Java CLI/src/main/java/com/company/Configuration.java).

### Logger

The application logs are managed by the `Logger` class in [Java CLI/src/main/java/com/company/Logger.java](Java CLI/src/main/java/com/company/Logger.java).
