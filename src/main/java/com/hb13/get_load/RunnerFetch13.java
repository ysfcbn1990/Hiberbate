package com.hb13.get_load;

import com.hb12.caching.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch13 {

    /*
   get() ---> gerçek nesneyi döndürür ,//eager
   			  nesne yoksa null döner
   			  nesnenin olduğundan emin değilseniz get() kullanın
   			  dönen nesneyi hemen kullanacaksam get() kullanılmalı

   load() --> proxy nesne döndürür, gerçek nesnenin gölgesi ,//lazy
   			  nesne yoksa exception fırlatır-->ObjectNotFound
   			  dönen nesne üzerinde delete yapılacaksa kullanılabilir
 */


    public static void main(String[] args) {


        Configuration con=new Configuration().configure().addAnnotatedClass(Student13.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();

   //get
 //   System.out.println("get methodu çağrılıyor");
 //   Student13 student=session.get(Student13.class,1L);//DB E sorgu gönderir
 //   System.out.println("Student ıd:"+student.getId());
 //   System.out.println("Student name:"+student.getName());


 ///load
 //   System.out.println("load methodu çağrılıyor");
 //tudent13 student2=session.load(Student13.class,2L);//proxy obje,sorgu kullanılmadı
 //   System.out.println("load methodu çağrıldı");//DB ye sorgu gönderilmedi

 //   System.out.println("Student2 ıd:"+student2.getId());
 //   System.out.println("student name:"+student2.getName());//objeyi kullanırken DB e sorgu gönderir



      //olmayan id ile get&load
  //     Student13 student3=session.get(Student13.class,20L);//null

  //    if(student3!=null){

  //        System.out.println("student id:"+student3.getId());

  //        System.out.println("student name:"+student3.getName());

  //    }
  //    Student13 student4=session.load(Student13.class,20L);//ObjectNotFoundException

  //    if(student4!=null){

  //        System.out.println("student id:"+student4.getId());

  //        System.out.println("student name:"+student4.getName());

  //    }


        //peki hangi durumda load kullanılabilir?
        //nesnenin kendisine doğrudan ihtiyaç olmadığında

  //     Student13 student5=session.get(Student13.class,1L);
  //     System.out.println("get ile alınan student siliniyor...");
  //     session.createQuery("Delete from Student13 where id="+student5.getId()).executeUpdate();

        Student13 student6=session.load(Student13.class,3L);
        System.out.println("load ile alınan student siliniyor...");
        session.createQuery("Delete from Student13 where id="+student6.getId()).executeUpdate();





        tx.commit();

        session.close();
        sf.close();








    }
}
