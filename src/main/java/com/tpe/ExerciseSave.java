package com.tpe;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ExerciseSave {

    public static void main(String[] args) {


        Animal animal1=new Animal(10,"Köpek","Karabaş");
        Animal animal2=new Animal(11,"Kedi","Boncuk");
        Animal animal3=new Animal(12,"Kuş","Bili");

        People people1=new People(1,"Emine","Konya",56,animal1);
        People people2=new People(2,"Asuman","İzmir",26,animal2);
        People people3=new People(3,"Hilal","Isparta",36,animal3);




        Configuration config=new Configuration().configure().addAnnotatedClass(Animal.class).addAnnotatedClass(People.class);
        SessionFactory sf =config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();


        session.save(animal1);
        session.save(animal2);
        session.save(animal3);
        session.save(people1);
        session.save(people2);
        session.save(people3);





        tx.commit();
        session.close();
        sf.close();
    }
}
