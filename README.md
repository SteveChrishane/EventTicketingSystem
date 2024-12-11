# Event Ticketing System 🎟️

This repository contains the backend, Java CLI, and frontend components of the Event Ticketing System.


## Tech Stack 🛠️ 

**CLI:** Java

**Backend:** Spring Boot

**Frontend:** React, TypeScript, Vite


## ✅ Prerequisites 

- Java 17 or higher
- Maven 3.6.3 or higher
- Node.js 16 or higher

## Java CLI 🖥️

The Java CLI is a command-line interface for interacting with the ticketing system.

### 🔍 Features 

- Load and save configuration
- Update configuration
- Simulate ticketing process
- Logging functionality

### ⚙️ Setup

1. Clone the repository:

   ```sh
   git clone https://github.com/SteveChrishane/EventTicketingSystem.git
   ```

2. Navigate to the Java CLI directory:

   ```sh
   cd EventTicketingSystem/Java CLI
   ```

3. Build the project:

   ```sh
   mvn clean install
   ```

4. Run the CLI application:
   ```sh
   java -cp target/EventTicketingSystem-1.0-SNAPSHOT.jar com.company.Main
   ```


## Backend 🗄️

The backend is a Spring Boot application that manages the ticketing system.

### 🔍 Features

- Manage ticket pool
- Handle vendor and customer interactions
- Start and stop ticketing simulation

### ⚙️ Setup

1. Navigate to the Java Backend directory:

   ```sh
   cd EventTicketingSystem/backend
   ```

2. Build the project:

   ```sh
   mvn clean install
   ```

3. Run the application:
   ```sh
   mvnw.cmd spring-boot:run
   ```

### 🔗 API Endpoints
- Start Simulation: `POST http://localhost:8080/ticketing/start`
- Stop Simulation: `POST http://localhost:8080/ticketing/stop`
- Set config values: `POST http://localhost:8080/ticketing/config`
- Get Status: `GET http://localhost:8080/ticketing/status`

## Frontend 🌐

The frontend is a React application that provides a user interface for interacting with the ticketing system.

### 🔍 Features

- Display ticket pool status
- Control panel to start and stop the simulation
- Configuration form to set system parameters
- Log display to show system logs

### ⚙️ Setup

1. Navigate to the frontend directory:

   ```sh
   cd EventTicketingSystem/Frontend
   ```

2. Install dependencies:

   ```sh
   npm install
   ```

3. Start the development server:

   ```sh
   npm run dev
   ```

4. Open your browser and navigate to `http://localhost:5173`
