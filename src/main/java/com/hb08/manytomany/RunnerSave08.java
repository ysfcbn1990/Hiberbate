package com.hb08.manytomany;

import com.hb07.bi_onetomany.Book07;
import com.hb07.bi_onetomany.Student07;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave08 {
    public static void main(String[] args) {

Course08 course1=new Course08(11,"Java Course");
Course08 course2=new Course08(12,"Math Course");

List<Course08> list1=new ArrayList<>();
list1.add(course1);
list1.add(course2);

        List<Course08> list2=new ArrayList<>();
        list2.add(course2);

Student08 student1=new Student08(1001,"Metin Bey",99,list1);
Student08 student2=new Student08(1002,"Yavuz Bey",99,list1);
Student08 student3=new Student08(1003,"Ebru Hanım",99,list2);




        Configuration con=new Configuration().configure().addAnnotatedClass(Student08.class).addAnnotatedClass(Course08.class);
        SessionFactory sf =con.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx=session.beginTransaction();


        session.save(course1);
        session.save(course2);

        session.save(student1);
        session.save(student2);
        session.save(student3);



        tx.commit();
        session.close();
        sf.close();
    }
}
