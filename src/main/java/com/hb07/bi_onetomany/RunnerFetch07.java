package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure().addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf =con.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx=session.beginTransaction();

//id si 1001 olan studentin tüm kitaplarını görelim görelim

        Student07 student=session.get(Student07.class,1001);
        System.out.println(student.getBookList());

//id si 101 olan kitabın sahibi olan öğrenciyi görelim
        Book07 book=session.get(Book07.class,101);
        System.out.println(book.getStudent());


        // !!! SQL ile, kitabı olan öğrencilerin(INNER JOIN) öğrenci ve kitap isimlerini listeleyelim(ödev1)
        // !!! HQL ile, kitabı olan öğrencilerin(INNER JOIN) öğrenci ve kitap isimlerini listeleyelim(ödev2)
        // !!! book ismi içinde "Java" geçen student kayıtlarını alalım ( HQL )Ödevv3

        String query="Select s.name,b.name from Student07 s INNER JOIN Book07 b on s.id=b.student";








        tx.commit();
        session.close();
        sf.close();






    }
}
