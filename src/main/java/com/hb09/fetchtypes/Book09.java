package com.hb09.fetchtypes;

import javax.persistence.*;

@Entity
public class Book09 {//İlişki sahibi
    @Id
    private int id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student09 student;

    //cons


    public Book09(int id, String name, Student09 student) {
        this.id = id;
        this.name = name;
        this.student = student;
    }

    public Book09() {
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

    public Student09 getStudent() {
        return student;
    }

    public void setStudent(Student09 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
