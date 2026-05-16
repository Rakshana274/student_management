package com.student;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.util.ConsoleUtil;

import java.util.*;

public class Main {

    private static final StudentService service = new StudentService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ConsoleUtil.printHeader("Student Management System  v1.0");
        System.out.println("  Welcome! Sample data has been loaded.\n");

        boolean running = true;
        while (running) {
            ConsoleUtil.printMenu();
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> viewAll();
                case "2" -> addStudent();
                case "3" -> searchByName();
                case "4" -> searchByCourse();
                case "5" -> updateStudent();
                case "6" -> deleteStudent();
                case "7" -> viewStats();
                case "8" -> sortByGpa();
                case "0" -> {
                    ConsoleUtil.printHeader("Goodbye! Have a great day.");
                    running = false;
                }
                default  -> ConsoleUtil.printError("Invalid option. Please enter 0-8.");
            }
        }
        scanner.close();
    }

    // ── 1. View All ────────────────────────────────────────────────────────────
    private static void viewAll() {
        ConsoleUtil.printHeader("All Students");
        ConsoleUtil.printStudents(service.getAllStudents());
    }

    // ── 2. Add Student ─────────────────────────────────────────────────────────
    private static void addStudent() {
        ConsoleUtil.printHeader("Add New Student");
        try {
            System.out.print("  Name   : "); String name   = scanner.nextLine().trim();
            System.out.print("  Age    : "); int age        = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("  Course : "); String course  = scanner.nextLine().trim();
            System.out.print("  GPA    : "); double gpa     = Double.parseDouble(scanner.nextLine().trim());

            if (name.isEmpty() || course.isEmpty()) throw new IllegalArgumentException("Name/Course cannot be empty");
            if (age < 16 || age > 100)              throw new IllegalArgumentException("Age must be 16-100");
            if (gpa < 0.0 || gpa > 4.0)             throw new IllegalArgumentException("GPA must be 0.0 - 4.0");

            Student s = service.addStudent(name, age, course, gpa);
            ConsoleUtil.printSuccess("Student added with ID " + s.getId());
        } catch (NumberFormatException e) {
            ConsoleUtil.printError("Invalid number format. Please try again.");
        } catch (IllegalArgumentException e) {
            ConsoleUtil.printError(e.getMessage());
        }
    }

    // ── 3. Search by Name ──────────────────────────────────────────────────────
    private static void searchByName() {
        ConsoleUtil.printHeader("Search by Name");
        System.out.print("  Enter keyword: ");
        String kw = scanner.nextLine().trim();
        List<Student> results = service.findByName(kw);
        ConsoleUtil.printStudents(results);
    }

    // ── 4. Search by Course ────────────────────────────────────────────────────
    private static void searchByCourse() {
        ConsoleUtil.printHeader("Search by Course");
        System.out.print("  Enter course name: ");
        String course = scanner.nextLine().trim();
        ConsoleUtil.printStudents(service.findByCourse(course));
    }

    // ── 5. Update Student ──────────────────────────────────────────────────────
    private static void updateStudent() {
        ConsoleUtil.printHeader("Update Student");
        try {
            System.out.print("  Enter Student ID to update: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Optional<Student> opt = service.findById(id);
            if (opt.isEmpty()) {
                ConsoleUtil.printError("Student with ID " + id + " not found.");
                return;
            }
            Student existing = opt.get();
            System.out.println("  Current: " + existing);
            System.out.println("  (Press Enter to keep existing value)\n");

            System.out.print("  New Name   [" + existing.getName()   + "]: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) name = existing.getName();

            System.out.print("  New Age    [" + existing.getAge()    + "]: ");
            String ageStr = scanner.nextLine().trim();
            int age = ageStr.isEmpty() ? existing.getAge() : Integer.parseInt(ageStr);

            System.out.print("  New Course [" + existing.getCourse() + "]: ");
            String course = scanner.nextLine().trim();
            if (course.isEmpty()) course = existing.getCourse();

            System.out.print("  New GPA    [" + existing.getGpa()    + "]: ");
            String gpaStr = scanner.nextLine().trim();
            double gpa = gpaStr.isEmpty() ? existing.getGpa() : Double.parseDouble(gpaStr);

            service.updateStudent(id, name, age, course, gpa);
            ConsoleUtil.printSuccess("Student ID " + id + " updated successfully.");
        } catch (NumberFormatException e) {
            ConsoleUtil.printError("Invalid input format.");
        }
    }

    // ── 6. Delete Student ──────────────────────────────────────────────────────
    private static void deleteStudent() {
        ConsoleUtil.printHeader("Delete Student");
        try {
            System.out.print("  Enter Student ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            service.findById(id).ifPresentOrElse(s -> {
                System.out.println("  Found: " + s.getName() + " (" + s.getCourse() + ")");
                System.out.print("  Confirm delete? (y/n): ");
                String confirm = scanner.nextLine().trim();
                if (confirm.equalsIgnoreCase("y")) {
                    service.deleteStudent(id);
                    ConsoleUtil.printSuccess("Student deleted.");
                } else {
                    System.out.println("  Deletion cancelled.");
                }
            }, () -> ConsoleUtil.printError("Student ID " + id + " not found."));
        } catch (NumberFormatException e) {
            ConsoleUtil.printError("Invalid ID format.");
        }
    }

    // ── 7. Statistics ──────────────────────────────────────────────────────────
    private static void viewStats() {
        ConsoleUtil.printHeader("Student Statistics");
        ConsoleUtil.printStats(service.getStats());
    }

    // ── 8. Sort by GPA ─────────────────────────────────────────────────────────
    private static void sortByGpa() {
        ConsoleUtil.printHeader("Sort Students by GPA");
        System.out.print("  Sort order — (1) Highest first  (2) Lowest first: ");
        String choice = scanner.nextLine().trim();
        boolean desc = !choice.equals("2");
        ConsoleUtil.printStudents(service.getSortedByGpa(desc));
    }
}
