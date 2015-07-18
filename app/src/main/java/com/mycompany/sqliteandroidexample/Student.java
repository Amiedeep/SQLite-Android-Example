package com.mycompany.sqliteandroidexample;

/**
 * Created by amandeepsingh on 18/07/15.
 */
public class Student {
    String name;
    int marks;
    String studentClass;

    public Student(String name, String studentClass, int marks) {
        this.name = name;
        this.studentClass = studentClass;
        this.marks = marks;
    }
}
