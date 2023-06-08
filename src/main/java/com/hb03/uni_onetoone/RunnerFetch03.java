package com.hb03.uni_onetoone;

import com.hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration con=new Configuration().configure().addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx=session.beginTransaction();

        //id=1002 olan student'ı getirelim

        Student03 student=session.get(Student03.class,1003);

        System.out.println(student);


        //id=11 olan diaryi görelim

        Diary diary=session.get(Diary.class,11);
        System.out.println(diary);

        System.out.println(student);
        System.out.println("*********************************");
        System.out.println(diary);
        System.out.println("*********************************");
        System.out.println(diary.getStudent());
        //diary den student'a ulaşabiliyoruz

//id=1002 olan student'ın diarysini görebilir miyiz??Hayır








        tx.commit();
        session.close();
        sf.close();




    }
}
