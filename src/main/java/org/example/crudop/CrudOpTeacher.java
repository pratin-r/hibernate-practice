package org.example.crudop;

import org.example.laptop.Laptop;
import org.example.teacher.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class CrudOpTeacher {
    public static void main(String[] args) {
        Laptop l1 = new Laptop(1,"Asus","Tuff","RTX 3060Ti",16);
        Laptop l2 = new Laptop(2,"Asus","ROG","RTX 3080Ti",16);
        Laptop l3 = new Laptop(3,"MSI","Katana","RTX 3070Ti",16);
//        Teacher t1 = new Teacher(1,"Wesker",45,true, Arrays.asList(l1,l2,l3));
//        Teacher t2 = new Teacher(2,"Chris",40,true, Arrays.asList(l2,l3));
        /*
        * <--- using different laptops for teachers for eager and lazy fetch --->
        * */
        Teacher t1 = new Teacher(1,"Wesker",45,true, Arrays.asList(l1,l2));
        Teacher t2 = new Teacher(2,"Chris",40,true, Arrays.asList(l3));
        // both are allotted to t1 (many-to-one)
//        l1.setTeacher(Arrays.asList(t1));
//        l2.setTeacher(Arrays.asList(t1,t2));
//        l3.setTeacher(Arrays.asList(t1,t2));
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.teacher.Teacher.class)
                .addAnnotatedClass(org.example.laptop.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();
        session1.persist(l1);
        session1.persist(l2);
        session1.persist(l3);
        session1.persist(t1);
        session1.persist(t2);
        transaction.commit();
        /*
        * when .find() gets executed, instead of calling SELECT statement,
        * it fetches data from the cache of the current session since it has done the mapping operation.
        * */
        Teacher a1Details = session1.find(Teacher.class,1);
        Teacher a2Details = session1.find(Teacher.class,2);
        System.out.println(a1Details);
//        System.out.println(a2Details);
        session1.close();
        Session session2 = sessionFactory.openSession();
        /*
        *  when executing this statement, this fires SELECT statement since the data is not present in cache.
        *  It wont load related entity (Relationship annotation)
        *  This can be verified by Hibernate statement in the terminal.
        * */
        Teacher t3 = session2.find(Teacher.class,1);
        /*
        * However, if you try to use t3 (here, println is accessing the data by fetching and displaying it),
        * then related entities will be loaded.
        * However, if the fetch type is EAGER, it will load all entities no matter what.
        */
        System.out.println(t3);
        session2.close();
        sessionFactory.close();
    }
}
