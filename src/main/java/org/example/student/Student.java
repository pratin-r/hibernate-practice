/*
* This is POJO (Plain Old Java Object) a simple Java object that
* does not extend any classes or implement any interfaces and is not tied to any specific framework.
* POJOs are used to hold and transfer data, and typically
* consist of private fields with public getter and setter methods to access them.
* */
package org.example.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "s_id")
    private int id;
    @Column(name = "s_name")
    private String name;
    @Column(name = "s_marks")
    private int marks;
    public Student(){}
    public Student(int id, String name, int marks){
        setId(id);
        setName(name);
        setMarks(marks);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + id +
                ", name='" + name + '\'' +
                ", sAge=" + marks +
                '}';
    }
}
