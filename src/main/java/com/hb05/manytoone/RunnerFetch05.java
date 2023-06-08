package com.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {

    public static void main(String[] args) {



        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sessionFactory =config.buildSessionFactory();
        Session session=sessionFactory.openSession();

        Transaction tx =session.beginTransaction();


        Student05 student=session.get(Student05.class,1001);
       // System.out.println(student);
        System.out.println(student.getUniversity());

        University university=session.get(University.class,1);
        System.out.println(university);


        String hqlQuery="From Student05 s where s.university.id=1";
        List<Student05> resultList=session.createQuery(hqlQuery,Student05.class).getResultList();
        resultList.forEach(System.out::println);












        tx.commit();
        session.close();
        sessionFactory.close();






    }



}
