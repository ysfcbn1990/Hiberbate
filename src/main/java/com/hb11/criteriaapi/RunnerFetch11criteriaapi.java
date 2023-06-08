package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11criteriaapi {
    public static void main(String[] args) {



        Configuration con=new Configuration().configure().addAnnotatedClass(Student11.class);
        SessionFactory sf =con.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx=session.beginTransaction();

   //-----------------------------------Criteria API ----------------------

        //SQL-HQL string bazlı,hatalara açık
        //Criteria API:Javada metotlar kullanarak sorgulama
        //avantajı:Derleme anında hata almamızı sağlar
        //READ:CriteriaQuery
        //Update:CriteriaUpdate
        //Delete:CriteriaDelete

        CriteriaBuilder cb =session.getCriteriaBuilder();//cb objesi ile CriteriaQuery oluşturabiliriz ve
                                                         //cb ın bazı metotlarını sorgularımızda kullanabiliriz
        CriteriaQuery<Student11 > criteriaQuery =cb.createQuery(Student11.class);

        Root<Student11>root =criteriaQuery.from(Student11.class);


        //!!! 1.Örnek: butun Student11 objelerini ekrana basalim:
        criteriaQuery.select(root);   //select * from Student11
      List<Student11> resultList= session.createQuery(criteriaQuery).getResultList();

         resultList.forEach(System.out::println);


        //!!! 2.Örnek , Student ismi "Student 6" olan öğrenci bilgilerini getirelim\

        //select * from student11 where name='Student 6';

 ///      criteriaQuery.select(root).where(cb.equal(root.get("name"),"student6"));

 ///      List<Student11>resultList2=session.createQuery(criteriaQuery).getResultList();

 ///      resultList2.forEach(System.out::println);



 ///      //!!!  3.Örnek, mathGrade değeri 80 den büyük olan dataları getirelim

 ///      criteriaQuery.select(root).where(cb.greaterThan(root.get("mathGrade"),80));
 ///      List<Student11>resultList3=session.createQuery(criteriaQuery).getResultList();
 ///       resultList3.forEach(System.out::println);




          //Örnek mathGrade değeri 50 den küçük olan dataları getirelim
        criteriaQuery.select(root).where(cb.lessThan(root.get("mathGrade"),50));
        List<Student11>resultList4=session.createQuery(criteriaQuery).getResultList();
        resultList4.forEach(System.out::println);

        // !!! 5. örnek : id si 1 veya mathGrade i 90 den büyük olan recordu bulalım

       // criteriaQuery.select(root).where(cb.or(cb.equal(root.get("id"),1),cb.greaterThan(root.get("mathGrade"),90)));

        Predicate pred1 =cb.equal(root.get("id"),1);
        Predicate pred2 =cb.greaterThan(root.get("mathGrade"),90);
        Predicate predOr =cb.or(pred2,pred1);
        criteriaQuery.select(root).where(predOr);

        List<Student11>resultList5=session.createQuery(criteriaQuery).getResultList();
        resultList5.forEach(System.out::println);




        tx.commit();
        session.close();
        sf.close();





    }
}
