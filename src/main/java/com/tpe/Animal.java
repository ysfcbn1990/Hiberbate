package com.tpe;

import javax.persistence.*;

@Entity
@Table(name="t_animal")
public class Animal {

    @Id
    private int seriNo;


    private String type;

    private String name;

    @OneToOne(mappedBy = "animal")
    private People people;

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public int getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(int seriNo) {
        this.seriNo = seriNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(int seriNo, String type, String name) {
        this.seriNo = seriNo;
        this.type = type;
        this.name = name;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return "Animal{" +
                "seriNo=" + seriNo +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
