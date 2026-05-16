package com.student.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private double gpa;

    public Student(int id, String name, int age, String course, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.gpa = gpa;
    }

    // Getters
    public int getId()       { return id; }
    public String getName()  { return name; }
    public int getAge()      { return age; }
    public String getCourse(){ return course; }
    public double getGpa()   { return gpa; }

    // Setters
    public void setName(String name)    { this.name = name; }
    public void setAge(int age)         { this.age = age; }
    public void setCourse(String course){ this.course = course; }
    public void setGpa(double gpa)      { this.gpa = gpa; }

    public String getGrade() {
        if (gpa >= 3.7) return "A";
        else if (gpa >= 3.3) return "B+";
        else if (gpa >= 3.0) return "B";
        else if (gpa >= 2.7) return "C+";
        else if (gpa >= 2.0) return "C";
        else return "F";
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-20s | %-3d | %-15s | %-4.2f | %-2s |",
                id, name, age, course, gpa, getGrade());
    }
}
