# Airline Reservation System

A Java web application for managing airline passengers, built with **Servlets, JSP, and JDBC** on top of **MySQL**. The project follows a layered structure (Controller → DAO → Entity → Utility) and includes a data-access layer for both passengers and flights.

## Features

- Passenger registration form (name, contact, email, password)
- Passenger list view that reads records from MySQL
- DAO layer for passengers: add, update, remove, fetch by ID, list all
- DAO layer for flights: add, update, remove, fetch by ID, list all
- Database schema and table setup through JDBC utility classes
- MySQL connection handled through Connector/J

## Tech Stack

| Layer        | Technology                         |
|--------------|------------------------------------|
| Language     | Java                               |
| Web          | Servlets, JSP (Java EE / Jakarta)  |
| Database     | MySQL 8, JDBC (Connector/J 8.0.31) |
| Server       | Apache Tomcat                      |
| IDE / Tools  | Eclipse (Dynamic Web Project), Git |

## Project Structure

```
Airline-Reservation-System/
├── src/main/java/
│   ├── Controler/      # Servlets and setup classes (addpassenger, passengerlistservlet, Schema, Createtable)
│   ├── Dao/            # DAO interfaces and implementations (Passenger_dao, Search_dao)
│   ├── Entitites/      # Entity classes (Passenger_entites, Search_entites)
│   └── util/           # DB constants and SQL queries (Passenger_Dbutils, Flight_Dbutils)
└── src/main/webapp/
    ├── Index.jsp
    ├── Addpassenger.jsp
    ├── Passengerlist.jsp
    ├── Message.jsp
    └── WEB-INF/
        ├── web.xml
        └── lib/mysql-connector-j-8.0.31.jar
```

## Database Design

**passenger**

| Column   | Type         | Notes                     |
|----------|--------------|---------------------------|
| id       | INT          | Primary key, auto-increment |
| name     | VARCHAR(30)  | Not null                  |
| contact  | INT          | Not null                  |
| email_id | VARCHAR(100) | Not null                  |
| password | VARCHAR(100) | Not null                  |

**Search (flights)**

| Column          | Type         |
|-----------------|--------------|
| Flight_id       | INT (PK, auto-increment) |
| Flight_name     | VARCHAR(225) |
| Departure_date  | DATE         |
| Departure_time  | TIME         |
| Arrival_time    | TIME         |
| origin          | VARCHAR(30)  |
| Destination     | VARCHAR(30)  |
| Seats_available | INT          |
| Price_seat      | INT          |

## Getting Started

### Prerequisites

- JDK 8 or later
- Apache Tomcat 9
- MySQL Server 8+
- Eclipse IDE for Enterprise Java Developers (or any IDE with Tomcat support)

### Setup

1. Clone the repository
   ```bash
   git clone https://github.com/kartikthapa249-ux/Airline-Reservation-System.git
   ```
2. Create the database and passenger table in MySQL
   ```sql
   CREATE DATABASE IF NOT EXISTS Munmun;
   USE Munmun;
   CREATE TABLE IF NOT EXISTS passenger (
       id INT NOT NULL AUTO_INCREMENT,
       name VARCHAR(30) NOT NULL,
       contact INT NOT NULL,
       email_id VARCHAR(100) NOT NULL,
       password VARCHAR(100) NOT NULL,
       PRIMARY KEY (id)
   );
   ```
3. Set your MySQL credentials in `src/main/java/util/Passenger_Dbutils.java` (and `Flight_Dbutils.java`)
   ```java
   public static final String USERNAME = "YOUR_USERNAME";
   public static final String PASSWORD = "YOUR_PASSWORD";
   ```
4. Import the project into Eclipse as an existing project and add Apache Tomcat as the server runtime.
5. Make sure `mysql-connector-j-8.0.31.jar` is on the classpath (it is included in `WEB-INF/lib`).
6. Run the project on Tomcat and open `http://localhost:8080/Airline-Reservation-System/Index.jsp`.

## Current Status and Roadmap

This project is a work in progress. The passenger module and the DAO layers are in place, and the following are planned:

- [ ] Flight search page connected to the flight DAO
- [ ] Ticket booking and cancellation
- [ ] Passenger login with authentication
- [ ] Password hashing (for example BCrypt) instead of plain text
- [ ] Move database credentials to a config file or environment variables
- [ ] Input validation and better error pages
- [ ] Migrate to Spring Boot with Spring Data JPA

## Author

**Kartik Thapa**
GitHub: [kartikthapa249-ux](https://github.com/kartikthapa249-ux)
