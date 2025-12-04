package org.example.concepts;

import org.example.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchValue {
    public static void main(String[] args) {
        Student s1 = null;
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        // find method helps us to fetch the data from db. Here, we are using .find(
        s1 = session.find(Student.class, 1);
        sessionFactory.close();
        System.out.println(s1);

    }
}
