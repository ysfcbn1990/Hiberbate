package com.hb11.criteriaapi;

import javax.persistence.*;

@Entity
@Table(name="t_student11")
public class Student11 {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name="std_name")
    private String name;

    private int mathGrade;

    public Long getId() {
        return id;
    }

 //  public void setId(Long id) {
 //      this.id = id;
 //  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    @Override
    public String toString() {
        return "Student11{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                '}';
    }
}
