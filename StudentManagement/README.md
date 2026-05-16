# Student Management System — Java CLI Project

A simple, menu-driven console application demonstrating core Java concepts.

## Project Structure

```
StudentManagement/
├── README.md
└── src/
    └── com/
        └── student/
            ├── Main.java                   ← Entry point
            ├── model/
            │   └── Student.java            ← Data model (POJO)
            ├── service/
            │   └── StudentService.java     ← Business logic (CRUD + stats)
            └── util/
                └── ConsoleUtil.java        ← Display helpers & ANSI colors
```

## Features

| #  | Feature              | Description                                      |
|----|----------------------|--------------------------------------------------|
| 1  | View All Students    | Display all students in a formatted table        |
| 2  | Add Student          | Add a new student with validation                |
| 3  | Search by Name       | Keyword search (case-insensitive)                |
| 4  | Search by Course     | Filter students by course name                   |
| 5  | Update Student       | Edit any field; press Enter to keep existing     |
| 6  | Delete Student       | Remove a student with confirmation prompt        |
| 7  | Statistics           | GPA avg/min/max, top student, course breakdown   |
| 8  | Sort by GPA          | Sort ascending or descending                     |

## Java Concepts Covered

- **OOP**: Classes, encapsulation, methods
- **Collections**: `ArrayList`, `List`, `Map`, `Optional`
- **Streams & Lambdas**: filter, map, sort, collect, groupingBy
- **Exception Handling**: try/catch, custom messages
- **Packages**: Organized into model / service / util layers
- **ANSI Colors**: Rich terminal output

## How to Compile & Run

```bash
# From the StudentManagement/ directory

# 1. Compile all sources
javac -d bin -sourcepath src src/com/student/Main.java

# 2. Run
java -cp bin com.student.Main
```

Requires **Java 14+** (uses switch expressions).
