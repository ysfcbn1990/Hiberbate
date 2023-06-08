package com.tpe;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class People {

    @Id
    private int id;

    private String name;


    private String adres;

    private int age;

    @OneToMany(mappedBy = "people")
private List<Animal> animal=new ArrayList<>();

    public People(int id, String name, String adres, int age, Animal animal) {
        this.id = id;
        this.name = name;
        this.adres = adres;
        this.age = age;

    }

    public People() {
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adres='" + adres + '\'' +
                ", age=" + age +
                ", animal=" + animal +
                '}';
    }
}
