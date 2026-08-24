# JDBC Student Management System

A console-based Student Management System built using Java, JDBC, and MySQL.

## 🚀 Features

- Add a new student
- View all students
- Search student by ID
- Update student details
- Delete student
- Console-based menu
- MySQL database integration
- PreparedStatement for SQL operations

## 🛠️ Technologies Used

- Java
- JDBC
- MySQL
- Maven
- IntelliJ IDEA

## 🗄️ Database

The project uses MySQL for storing student information.

### Student Table

```sql
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    course VARCHAR(100) NOT NULL,
    marks DOUBLE
);