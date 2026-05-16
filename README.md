## 📖 About the Project

The **Student Management System** is a command-line Java application that allows users to manage student data interactively through a menu-driven interface. It supports adding, viewing, searching, updating, deleting students, and generating statistics — all from the terminal.

This project was built to demonstrate practical application of core Java programming concepts including Object-Oriented Programming, Collections, Streams, Lambda expressions, and Exception Handling.

---

## ✨ Features

| # | Feature | Description |
|---|---------|-------------|
| 1 | View All Students | Displays all students in a clean formatted table |
| 2 | Add Student | Add a new student with full input validation |
| 3 | Search by Name | Case-insensitive keyword search |
| 4 | Search by Course | Filter students by course name |
| 5 | Update Student | Edit any field; press Enter to keep existing value |
| 6 | Delete Student | Remove a student with confirmation prompt |
| 7 | Statistics | GPA average, min, max, top student, course breakdown |
| 8 | Sort by GPA | Sort students ascending or descending by GPA |
| 0 | Exit | Gracefully exit the application |

---

## 🛠 Tech Stack

| Technology | Details |
|---|---|
| Language | Java 14+ |
| Paradigm | Object-Oriented Programming |
| UI | Command Line Interface (CLI) |
| Build Tool | javac (Java Compiler) |
| IDE | VS Code with Extension Pack for Java |

---

## 📁 Project Structure

```
StudentManagement/
│
├── README.md
├── manifest.txt
├── StudentManagement.jar
│
├── src/
│   └── com/
│       └── student/
│           ├── Main.java                    ← Entry point & menu loop
│           ├── model/
│           │   └── Student.java             ← Student data model (POJO)
│           ├── service/
│           │   └── StudentService.java      ← Business logic (CRUD + stats)
│           └── util/
│               └── ConsoleUtil.java         ← Display helpers & ANSI colors
│
└── bin/                                     ← Compiled .class files (auto-generated)
    └── com/student/...
```

---

## ✅ Prerequisites

Make sure the following are installed before running the project:

- **Java JDK 14 or above** — [Download here](https://adoptium.net)
- **VS Code** — [Download here](https://code.visualstudio.com)
- **Extension Pack for Java** — Install from VS Code Extensions (`Ctrl+Shift+X`)

Verify installation by running:

```bash
java -version
javac -version
```

Expected output:
```
openjdk version "24.0.2" ...
javac 24.0.2
```

---

## ▶️ How to Run

### Step 1 — Clone or Download the Project

**Option A — Clone via Git:**
```bash
git clone https://github.com/YOUR_USERNAME/StudentManagement.git
cd StudentManagement
```

**Option B — Download ZIP:**
- Download the ZIP file
- Extract it
- Open the extracted folder

### Step 2 — Open in VS Code

```bash
code .
```

Or go to **File → Open Folder** and select the `StudentManagement` folder.

### Step 3 — Open Terminal in VS Code

Press `` Ctrl + ` ``

### Step 4 — Create bin Folder

```bash
mkdir bin
```

### Step 5 — Compile the Project

```bash
javac -d bin -sourcepath src src/com/student/Main.java
```

No output means success. ✅

### Step 6 — Run the Project

```bash
java -cp bin com.student.Main
```

The application menu will appear in the terminal. Type a number (0–8) and press **Enter** to interact.

---

## 📦 How to Create a Runnable JAR

A JAR file allows anyone to run the app with just Java — no compilation needed.

```bash
# Step 1 — Create manifest
echo Main-Class: com.student.Main > manifest.txt

# Step 2 — Package into JAR
jar cfm StudentManagement.jar manifest.txt -C bin .

# Step 3 — Run the JAR
java -jar StudentManagement.jar
```

Share the `StudentManagement.jar` file with anyone who has Java installed!

---

## 🖥️ Sample Output

```
======================================================================
  Student Management System  v1.0
======================================================================

  ╔══════════════════════════════╗
  ║   STUDENT MANAGEMENT MENU   ║
  ╠══════════════════════════════╣
  ║  1. View All Students        ║
  ║  2. Add Student              ║
  ║  3. Search by Name           ║
  ║  4. Search by Course         ║
  ║  5. Update Student           ║
  ║  6. Delete Student           ║
  ║  7. View Statistics          ║
  ║  8. Sort by GPA              ║
  ║  0. Exit                     ║
  ╚══════════════════════════════╝

+------+----------------------+-----+-----------------+------+----+
| ID   | Name                 | Age | Course          | GPA  | Gr |
+------+----------------------+-----+-----------------+------+----+
| 1    | Alice Johnson        | 20  | Computer Science| 3.90 | A  |
| 2    | Bob Martinez         | 22  | Mathematics     | 3.20 | B  |
| 3    | Clara Smith          | 21  | Physics         | 3.60 | B+ |
+------+----------------------+-----+-----------------+------+----+
  Total: 3 student(s)
```

---

## 📚 Java Concepts Used

| Concept | Where Applied |
|---|---|
| OOP — Classes & Objects | `Student`, `StudentService`, `ConsoleUtil` |
| Encapsulation | Private fields with getters/setters in `Student.java` |
| Packages | `model`, `service`, `util` layer separation |
| ArrayList & Collections | Storing and managing student records |
| Optional | Safe null handling in `findById()` |
| Streams & Lambdas | Filtering, sorting, and statistics in `StudentService` |
| Collectors.groupingBy | Course-wise student distribution in stats |
| Exception Handling | try/catch for invalid inputs throughout `Main.java` |
| Switch Expressions | Menu navigation in `Main.java` (Java 14+) |
| ANSI Color Codes | Color-coded terminal output in `ConsoleUtil.java` |

---

## 👤 Author

**Rakshana**
- GitHub: [@Rakshana274](https://github.com/Rakshana274)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

> Built with ❤️ using Java | Academic Project
