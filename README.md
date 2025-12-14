# Airline Management System (Java + JDBC)

## Overview
The **Airline Management System** is a console-based Java application developed using
Object-Oriented Programming principles.  
It uses **JDBC** to interact with a relational database and allows users to manage
airline flight data through a menu-driven interface.

This project was developed as part of a Java OOP assessment and demonstrates
CRUD operations, database connectivity, and user input handling.

---

## Features
The application provides the following functionalities through console options:

1. Create Flight Table  
2. Insert Flight Details  
3. Find Flights by Source and Destination  
4. Change Source City  
5. Find Cheapest Flight between Source and Destination  
6. Find Shortest Duration Flight  
7. Update Flight Fare (Economy, First Class, Business Class)  
8. Print All Flights Data  
9. Exit Application  

The system also handles invalid inputs such as wrong source or destination cities.

---

## Technologies Used
- Java (Core Java, OOP)
- JDBC
- PostgreSQL (or compatible RDBMS)
- IntelliJ IDEA
- Git & GitHub


---

## How to Run the Project
1. Open the project in IntelliJ IDEA.
2. Ensure database connection details are correctly set in `connection.properties`.
3. Run the `AirlineRunner` class.
4. The console menu will appear.
5. Enter the desired option number to perform operations.

---

## Database Operations
- Flight records are stored in a database table.
- Users can insert, update, search, and display flight details.
- Fare updates apply to Economy, First Class, and Business Class.
- The program handles cases where no flight is found for given routes.

---

## Sample Flow
- Create table → Insert flight data
- Search flights using source and destination
- Update fare for an existing flight
- Display all flight records
- Exit safely using menu option 9

---

## Author
**Utkarsh Dilip Pardhi**
 GitHub: https://github.com/UtkarshPardhi
---

## Notes
- This is a console-based application.
- Designed to demonstrate Java OOP concepts and JDBC usage.

---

## Project Structure
