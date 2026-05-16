package com.student.service;

import com.student.model.Student;
import java.util.*;
import java.util.stream.Collectors;

public class StudentService {
    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public StudentService() {
        // Pre-load sample data
        addStudent("Alice Johnson",  20, "Computer Science", 3.9);
        addStudent("Bob Martinez",   22, "Mathematics",      3.2);
        addStudent("Clara Smith",    21, "Physics",          3.6);
        addStudent("David Lee",      23, "Engineering",      2.8);
        addStudent("Eva Brown",      20, "Biology",          3.5);
    }

    public Student addStudent(String name, int age, String course, double gpa) {
        Student s = new Student(nextId++, name, age, course, gpa);
        students.add(s);
        return s;
    }

    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(students);
    }

    public Optional<Student> findById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }

    public List<Student> findByName(String keyword) {
        String kw = keyword.toLowerCase();
        return students.stream()
                .filter(s -> s.getName().toLowerCase().contains(kw))
                .collect(Collectors.toList());
    }

    public List<Student> findByCourse(String course) {
        return students.stream()
                .filter(s -> s.getCourse().equalsIgnoreCase(course))
                .collect(Collectors.toList());
    }

    public boolean updateStudent(int id, String name, int age, String course, double gpa) {
        Optional<Student> opt = findById(id);
        if (opt.isPresent()) {
            Student s = opt.get();
            s.setName(name);
            s.setAge(age);
            s.setCourse(course);
            s.setGpa(gpa);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    public Map<String, Object> getStats() {
        Map<String, Object> stats = new LinkedHashMap<>();
        if (students.isEmpty()) {
            stats.put("count", 0);
            return stats;
        }
        double avg = students.stream().mapToDouble(Student::getGpa).average().orElse(0);
        double max = students.stream().mapToDouble(Student::getGpa).max().orElse(0);
        double min = students.stream().mapToDouble(Student::getGpa).min().orElse(0);
        Student top = students.stream().max(Comparator.comparingDouble(Student::getGpa)).get();

        stats.put("count",   students.size());
        stats.put("avgGpa",  String.format("%.2f", avg));
        stats.put("maxGpa",  String.format("%.2f", max));
        stats.put("minGpa",  String.format("%.2f", min));
        stats.put("topStudent", top.getName() + " (" + top.getGpa() + ")");

        // Course distribution
        Map<String, Long> courseDist = students.stream()
                .collect(Collectors.groupingBy(Student::getCourse, Collectors.counting()));
        stats.put("courseDist", courseDist);

        return stats;
    }

    public List<Student> getSortedByGpa(boolean descending) {
        Comparator<Student> cmp = Comparator.comparingDouble(Student::getGpa);
        return students.stream()
                .sorted(descending ? cmp.reversed() : cmp)
                .collect(Collectors.toList());
    }
}
