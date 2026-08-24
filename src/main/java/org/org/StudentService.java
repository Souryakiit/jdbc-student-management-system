package org.org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService {

    public void addStudent(student student) {

        String sql = """
                INSERT INTO student (name, email, course, marks)
                VALUES (?, ?, ?, ?)
                """;

        try {
            Connection connection = DBConfig.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getCourse());
            preparedStatement.setDouble(4, student.getMarks());

            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected > 0) {
                System.out.println("Student added successfully");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void viewAllStudent() {

        String sql = "SELECT * FROM student";

        try {
            Connection connection = DBConfig.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println();
            System.out.println("Student Records");
            System.out.println("-----------------------------------------");

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String course = resultSet.getString("course");
                double marks = resultSet.getDouble("marks");

                System.out.println("ID     : " + id);
                System.out.println("Name   : " + name);
                System.out.println("Email  : " + email);
                System.out.println("Course : " + course);
                System.out.println("Marks  : " + marks);

                System.out.println("-----------------------------------------");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void searchStudent(int id) {

        String sql = """
                SELECT * FROM student WHERE id = ?
                """;

        try {
            Connection connection = DBConfig.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                System.out.println();
                System.out.println("Student found.");

                System.out.println("ID     : " + resultSet.getInt("id"));
                System.out.println("Name   : " + resultSet.getString("name"));
                System.out.println("Email  : " + resultSet.getString("email"));
                System.out.println("Course : " + resultSet.getString("course"));
                System.out.println("Marks  : " + resultSet.getDouble("marks"));

            } else {
                System.out.println("Student not found.");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void updateStudent(int id, String name, String email, String course, double marks) {

        String sql = """
            UPDATE student
            SET name = ?, email = ?, course = ?, marks = ?
            WHERE id = ?
            """;

        try {
            Connection connection = DBConfig.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, course);
            preparedStatement.setDouble(4, marks);
            preparedStatement.setInt(5, id);

            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void deleteStudent(int id) {

        String sql = "DELETE FROM student WHERE id = ?";

        try {
            Connection connection = DBConfig.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
