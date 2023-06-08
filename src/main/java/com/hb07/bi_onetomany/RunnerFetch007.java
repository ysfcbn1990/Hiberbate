package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch007 {
    public static void main(String[] args) {




        Configuration con=new Configuration().configure().addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf =con.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx=session.beginTransaction();

    //DELETE İŞLEMİ:Student 07 tablosundaki tüm kayıtları silelim
        //aşamalı silme yapabiliriz
        // Book07 tablosundaki tüm kayıtları silelim

        String hql1="delete from Book07";
        int numOfDeletedRecord=session.createQuery(hql1).executeUpdate();
        System.out.println("silinenKayitSayisi: "+numOfDeletedRecord);



      //Student 07 tablosundaki tüm kayıtları silelim



    String hql2="delete from Student07";

    int numOfDeletedRecord2=session.createQuery(hql2).executeUpdate();

    System.out.println("silinenKayitSayisi: "+numOfDeletedRecord2);


//Kitap ismi "Java Book " olan kitabı sileim
//
       //  String hql3="delete from Book07 b where b.name='Java Book'";
       //  int numOfDeletedRecord=session.createQuery(hql3).executeUpdate();
       //  System.out.println("silinenKayitSayisi: "+numOfDeletedRecord);
//

  //Kitabı olan bir öğrenciyi silmek istersek
  //1-önce book tablosunda ilişkili olan bookları silip sonra öğrenci silinir
  //2-cascadeType.REMOVAL vs orphanRemoval

        //id si 1001 olan student ı silelim
     // Student07 student=session.get(Student07.class,1001);
     // session.delete(student);

//id si 1002 olan studentin kitap listesinden ilk kitabını silelim

        Student07 student2=session.get(Student07.class,1002);

        student2.getBookList().remove(0);//103,104,105->104,105

        //orphanRemoval=true,listeden bir objeyi kaldırırsak yada
        //null a set edersek bu objeyi tablodan da kaldırıyor




        tx.commit();
        session.close();
        sf.close();

    }
}
