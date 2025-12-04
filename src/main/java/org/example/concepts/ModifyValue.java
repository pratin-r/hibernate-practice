package org.example.concepts;

import org.example.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ModifyValue {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(2);
        s1.setName("Dimitrescu");
        s1.setMarks(100);
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        /*
        * .merge() method first checks if the record is already present in the table. If so, it updates the value.
        * If there is no value in the table, it adds the data given as a new record
        *  */
        session.merge(s1);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
