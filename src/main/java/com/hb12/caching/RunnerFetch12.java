package com.hb12.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/*
1)  First Level Cache --->
             *nesneler için kullanılır
            * defaultta açık geliyor , kapatma durumu yok
            * Aynı session içinde kayıt alır
            * session kapanınca içindekiler silinir

2) Second Level Cache --->
           *nesneler için kullanılır
            * Defaultta kapalıdır
            * Session factory seviyesinde cacheleme yapar, yani farklı
                    sessionlar arasında data kullanılabiliyor
            * hibernate.cfg.xml den active edilebilir
            *aynı data aynı sessionda first level cacheden gelir,
             aynı data farklı sessionda second level cacheden gelir.


3) Query Cache
            * Query ler için kullanılıyor
            * hibernate.cfg.xml den active edilebilir
            *First veya Second Level Cache ile birlikte kullanılabilir

 */


public class RunnerFetch12 {
    public static void main(String[] args) {


        Configuration con=new Configuration().configure().addAnnotatedClass(Student12.class);
        SessionFactory sf =con.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx=session.beginTransaction();

      //  System.out.println("ilk get işlemi ile id=1 olan student");
      //  Student12 student=session.get(Student12.class,1L);
      //  System.out.println(student);

        //session.clear();//sessiondaki cache alınan dataları temizler

//        System.out.println("ikinci get işlemi ile id=1 olan student");
//        Student12 student2=session.get(Student12.class,1L);
//        System.out.println(student2);


        //------------query cache-----------------
        Query query=session.createQuery("from Student12").setCacheable(true);

   query.getResultList();

   query.getResultList();


        //------------query cache-----------------


        tx.commit();
        session.close();//first level cache temizlenir

    Session session2=sf.openSession();
    Transaction tx2=session2.beginTransaction();

         System.out.println("Session close edildikten sonra tekrar get işlemi ile id=1 olan student");
        Student12 student2=session2.get(Student12.class,1L);
         System.out.println(student2);









        tx2.commit();
        session2.close();
        sf.close();


        //SONUÇ:First Level Cache:session seviyesinde
        //DB den bir data çekildiğinde cache alınır
        //Aynı sessionda aynı data çekilmek istendiğinde DB ye gitmeden cacheden datayı getirir
        //Farklı sessionda aynı dataya ulaşılmak istenirse DB ye tekrar sorgu gönderirlir
        //session kapatıldığında veya temizlendiğinde cache de temizlenir

        //Second Level Cache:session factory seviyesinde
        //farklı sessionda aynı datayı çekmek istediğimizde DB tekrar sorgu göndermez




    }
}
