package org.org;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();

        while (true) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                // =====================
                // ADD
                // =====================

                case 1:

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter course: ");
                    String course = scanner.nextLine();

                    System.out.print("Enter marks: ");
                    double marks = scanner.nextDouble();

                    student newStudent =
                            new student(name, email, course, marks);

                    studentService.addStudent(newStudent);

                    break;


                // =====================
                // VIEW
                // =====================

                case 2:

                    studentService.viewAllStudent();

                    break;


                // =====================
                // SEARCH
                // =====================

                case 3:

                    System.out.print("Enter student ID: ");
                    int searchId = scanner.nextInt();

                    studentService.searchStudent(searchId);

                    break;


                // =====================
                // UPDATE
                // =====================

                case 4:

                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String updateName = scanner.nextLine();

                    System.out.print("Enter new email: ");
                    String updateEmail = scanner.nextLine();

                    System.out.print("Enter new course: ");
                    String updateCourse = scanner.nextLine();

                    System.out.print("Enter new marks: ");
                    double updateMarks = scanner.nextDouble();

                    studentService.updateStudent(
                            updateId,
                            updateName,
                            updateEmail,
                            updateCourse,
                            updateMarks
                    );

                    break;


                // =====================
                // DELETE
                // =====================

                case 5:

                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();

                    studentService.deleteStudent(deleteId);

                    break;


                // =====================
                // EXIT
                // =====================

                case 6:

                    System.out.println("Thank you for using Student Management System.");

                    scanner.close();

                    return;


                default:

                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}