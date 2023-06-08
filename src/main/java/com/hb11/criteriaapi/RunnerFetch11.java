package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.Random;

public class RunnerFetch11 {
    public static void main(String[] args) {



        Configuration con=new Configuration().configure().addAnnotatedClass(Student11.class);
        SessionFactory sf =con.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx=session.beginTransaction();

    /*
    session methodları
    C:save
    R:get
    U:update
    D:delete
     */

        //UPDATE işlemi

    //   Student11 student=session.get(Student11.class,1L);
    //   student.setMathGrade(40);
    //   session.update(student);

        //TASK: MathGrade puani 30 dan kucuk olan ogrencilerin puanlarini 80 yapalim
        int defaultGrade=30;
        int updategrade=80;
       // String query="update Student11 set mathGrade=80 where mathGrade<30";
        String hqlquery="update Student11 set mathGrade=:sMath where mathGrade<:lMath";
        Query query=session.createQuery(hqlquery);
        query.setParameter("sMath",updategrade);
        query.setParameter("lMath",defaultGrade);

       int updatedRecord= query.executeUpdate();
        System.out.println("Güncellenen Kayit Sayısı"+updatedRecord);


        tx.commit();
        session.close();
        sf.close();





    }
}
