package com.student.util;

import com.student.model.Student;
import java.util.List;
import java.util.Map;

public class ConsoleUtil {

    public static final String RESET  = "\u001B[0m";
    public static final String CYAN   = "\u001B[36m";
    public static final String GREEN  = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED    = "\u001B[31m";
    public static final String BOLD   = "\u001B[1m";

    public static void printHeader(String title) {
        String line = "=".repeat(70);
        System.out.println(CYAN + line + RESET);
        System.out.println(CYAN + BOLD + "  " + title + RESET);
        System.out.println(CYAN + line + RESET);
    }

    public static void printTableHeader() {
        System.out.println(YELLOW +
            "+------+----------------------+-----+-----------------+------+----+" + RESET);
        System.out.println(YELLOW +
            "| ID   | Name                 | Age | Course          | GPA  | Gr |" + RESET);
        System.out.println(YELLOW +
            "+------+----------------------+-----+-----------------+------+----+" + RESET);
    }

    public static void printTableFooter() {
        System.out.println(YELLOW +
            "+------+----------------------+-----+-----------------+------+----+" + RESET);
    }

    public static void printStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println(RED + "  No students found." + RESET);
            return;
        }
        printTableHeader();
        for (Student s : students) {
            System.out.println(s);
        }
        printTableFooter();
        System.out.println(GREEN + "  Total: " + students.size() + " student(s)" + RESET);
    }

    @SuppressWarnings("unchecked")
    public static void printStats(Map<String, Object> stats) {
        System.out.println(GREEN + "  Total Students : " + stats.get("count") + RESET);
        if ((int) stats.get("count") == 0) return;
        System.out.println(GREEN + "  Average GPA    : " + stats.get("avgGpa") + RESET);
        System.out.println(GREEN + "  Highest GPA    : " + stats.get("maxGpa") + RESET);
        System.out.println(GREEN + "  Lowest GPA     : " + stats.get("minGpa") + RESET);
        System.out.println(GREEN + "  Top Student    : " + stats.get("topStudent") + RESET);
        System.out.println();
        System.out.println(YELLOW + "  Course Distribution:" + RESET);
        Map<String, Long> dist = (Map<String, Long>) stats.get("courseDist");
        dist.forEach((course, count) ->
            System.out.printf("    %-20s : %d student(s)%n", course, count));
    }

    public static void printSuccess(String msg) {
        System.out.println(GREEN + "  ✔ " + msg + RESET);
    }

    public static void printError(String msg) {
        System.out.println(RED + "  ✘ " + msg + RESET);
    }

    public static void printMenu() {
        System.out.println();
        System.out.println(BOLD + CYAN + "  ╔══════════════════════════════╗" + RESET);
        System.out.println(BOLD + CYAN + "  ║   STUDENT MANAGEMENT MENU   ║" + RESET);
        System.out.println(BOLD + CYAN + "  ╠══════════════════════════════╣" + RESET);
        System.out.println(BOLD + CYAN + "  ║  1. View All Students        ║" + RESET);
        System.out.println(BOLD + CYAN + "  ║  2. Add Student              ║" + RESET);
        System.out.println(BOLD + CYAN + "  ║  3. Search by Name           ║" + RESET);
        System.out.println(BOLD + CYAN + "  ║  4. Search by Course         ║" + RESET);
        System.out.println(BOLD + CYAN + "  ║  5. Update Student           ║" + RESET);
        System.out.println(BOLD + CYAN + "  ║  6. Delete Student           ║" + RESET);
        System.out.println(BOLD + CYAN + "  ║  7. View Statistics          ║" + RESET);
        System.out.println(BOLD + CYAN + "  ║  8. Sort by GPA              ║" + RESET);
        System.out.println(BOLD + CYAN + "  ║  0. Exit                     ║" + RESET);
        System.out.println(BOLD + CYAN + "  ╚══════════════════════════════╝" + RESET);
        System.out.print("  Enter choice: ");
    }
}
