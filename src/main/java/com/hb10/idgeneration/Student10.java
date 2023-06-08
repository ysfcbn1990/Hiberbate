package com.hb10.idgeneration;

import javax.persistence.*;

@Entity
@Table(name="t_student10")
public class Student10 {
    /*
    AUTO:Defaulta auto-increment öz. kullanır

   Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır, Id üretilirken
            başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)
   MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur,
            içlerindeki en basitidir)

     IDENTITY:Kontrol DB olur,1 den başlayarak üretir
     TABLE:id generate etmek için tablo oluşturulur.Performansı düşüktür,tercih edilmez
     SEQUENCE:id set oluşturulur,başlangıç sayısını belirleyebiliriz.performansı yüksektir,tercih edilir

     */

   // @GeneratedValue(strategy = GenerationType.IDENTITY)

   @GeneratedValue(generator ="sequencegen" ,strategy = GenerationType.SEQUENCE)
   @SequenceGenerator(name="sequencegen",//generatorın ismini @GeneratedValue anatasyonunda kullanılır
   sequenceName = "student_seg",//DB de bu isimde seq oluşur
   initialValue = 1000,//id ler bu değer ile başlasın
   allocationSize = 5)//id setinde 10 tane id bulunur
    @Id
    private int id;


    private String name;

    private int grade;

    public int getId() {
        return id;
    }

 //  public void setId(int id) {
 //      this.id = id;
 //  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //set1=1000,1001,1002,1003,1004,1005
    //set2=1006,1007,1008,1009,1010
    //set3=1011,1012,1013,1014,1015

}
