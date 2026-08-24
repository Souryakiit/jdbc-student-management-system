package org.org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    static String url = "jdbc:mysql://localhost:3306/projectjdbc";
    static String username = "root";
    static String pass = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, pass);
    }
}