package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sessionFactory =config.buildSessionFactory();//session başlatılmasını sağlar
        Session session=sessionFactory.openSession();
        //sesssion DB ile iletişime geçip bazı işlemler yapmamızı sağlayan metodlara sahip
        Transaction tx =session.beginTransaction();


        //id:1001 student
        Student04 student=session.get(Student04.class,1001);

        System.out.println(student);

        //id:12 Diary

        Diary04 diary=session.get(Diary04.class,12);
        System.out.println(diary);


        //bi-direction
        System.out.println("**************************");
        System.out.println(diary.getStudent());
        System.out.println("**************************");
        System.out.println(student.getDiary());

        //uni-bi directional ilişkide DB açısından fark olmaz,sadece tek bir tabloda FK olur
        //Ancak uygulama tarafında uni_directional ilişkide sadece ilişki sahibi olan classtan diğer objeye ulaşılır
        //Ancak bi-directional ilişkide her bir objeden diğerine ulaşabiliriz
        //Sadece ilişki sahibi class tarafından set etmek yeterli olur

        //!!! Task1:Diary ve Student tablolarında ortak kayıtlardan
        //Student name ve diary name fieldlarını getirelim
       // String hqlQuery="select s.name,d.name from Student04 s INNER JOIN Diary04 d on s.id=d.student.id";
        String hqlQuery="select s.name,d.name from Student04 s INNER JOIN Diary04 d on s.id=d.student";//s.id=d.student.id
        List<Object[]>resultList =session.createQuery(hqlQuery).getResultList();//list()
        for(Object[] w:resultList){
           System.out.println(Arrays.toString(w));
        }

        // !!! Task 2:Student tablosundaki tüm kayıtları Diary de ortak kayıtlardan
        //student name ve diary name fieldlarını getirelim.
        String hqlQuery1="select s.name,d.name from Student04 s LEFT JOIN Diary04 d on s.id=d.student";//s.id=d.student.id
        List<Object[]>resultList1 =session.createQuery(hqlQuery1).getResultList();//list()
        for(Object[] w:resultList1){
            System.out.println(Arrays.toString(w));
        }

        // !!! Task 3:Diary tablosundaki tüm kayıtları Student de ortak kayıtlardan
        //student name ve diary name fieldlarını getirelim.

        String hqlQuery2="select s.name,d.name from Student04 s RIGHT JOIN Diary04 d on s.id=d.student";//s.id=d.student.id
        List<Object[]>resultList2 =session.createQuery(hqlQuery2).getResultList();//list()
        for(Object[] w:resultList2){
            System.out.println(Arrays.toString(w));
        }

        // !!! Task 4:Diary tablosundaki tüm kayıtları Student de tüm  kayıtlardan
        //student name ve diary name fieldlarını getirelim.

        String hqlQuery3="select s.name,d.name from Student04 s FULL JOIN Diary04 d on s.id=d.student";//s.id=d.student.id
        List<Object[]>resultList3 =session.createQuery(hqlQuery3).getResultList();//list()
       resultList3.stream().forEach(t-> System.out.println(Arrays.toString(t)));

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
