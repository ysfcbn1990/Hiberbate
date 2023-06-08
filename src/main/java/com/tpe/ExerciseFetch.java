package com.tpe;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class ExerciseFetch {

    public static void main(String[] args) {



        Configuration config=new Configuration().configure().addAnnotatedClass(Animal.class).addAnnotatedClass(People.class);
        SessionFactory sf =config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx =session.beginTransaction();

        // !!! Task 2:Student tablosundaki tüm kayıtları Diary de ortak kayıtlardan
        //student name ve diary name fieldlarını getirelim.

        String hql="select p.name,a.name from People p INNER JOIN Animal a on a.id=p.animal";
        List<Object[]>result=session.createQuery(hql).getResultList();
for(Object[]w:result){
    System.out.println(Arrays.toString(w));
}

        tx.commit();
        session.close();
        sf.close();



    }


}
