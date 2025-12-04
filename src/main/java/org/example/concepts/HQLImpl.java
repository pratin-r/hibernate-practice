package org.example.concepts;

import org.example.mobile.Mobile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class HQLImpl {
    public static void main(String[] args) {
//        Mobile mobile1 = new Mobile(1,"OnePlus","13R",12); data already exists in the table
//        Mobile mobile2 = new Mobile(2,"IPhone","16 Pro Max",8);
//        Mobile mobile3 = new Mobile(3,"OnePlus","15",16);
//        Mobile mobile4 = new Mobile(4,"IQOO","15",16);
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.mobile.Mobile.class)
                .configure()
                .buildSessionFactory();
        Session session1 = sessionFactory.openSession();
//        Transaction transaction = session1.beginTransaction();
//        session1.persist(mobile1);
//        session1.persist(mobile2);
//        session1.persist(mobile3);
//        session1.persist(mobile4);
//        transaction.commit();
        Mobile mobile1Details = session1.find(Mobile.class,1); // when u run this alone, it shows select query in terminal which means it is eager loading
        Mobile mobile1Details2 = session1.getReference(Mobile.class,2); // when u run this alone, it does not call any query, so its lazy loading
        System.out.println(mobile1Details);
        System.out.println(mobile1Details2);

        /*
        * i) .createSelectionQuery used here accepts (String s, Class <R> aClass)
        *    R is Return type. So, you should mention what will be the return type of the query given.
        *
        * ii) Always check the return type of argument passed in the query.
        *     In the below line, since we are asking multiple columns,
        *     the return type would obviously be the user-defined type (Mobile.class)
        * */
        SelectionQuery <Mobile> query = session1.createSelectionQuery("from Mobile where mobileId = 2", Mobile.class);
        List<Mobile> mobileList = query.getResultList();
        System.out.println(mobileList);
        /*
        * In the below query, since we are asking for 'mobileBrand' which is of String type (check Mobile.java),
        * the return type would be String.
        * */
        String model = "15";
        SelectionQuery <String> query2 = session1.createSelectionQuery("select mobileBrand from Mobile where mobileModel like ?1", String.class);
        query2.setParameter(1,model);
        List<String> mobileList2=query2.getResultList();
        System.out.println(mobileList2);
        session1.close();
        sessionFactory.close();
    }
}
