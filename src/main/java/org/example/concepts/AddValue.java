package org.example.concepts;
import org.example.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
* make sure the class name (which will be table name) and
* variable name (which will be column name) is same when you want to
* add data in existing table.
* */
public class AddValue {
    public static void main(String[] args) {
        Student student1= new Student(10,"Hunnigan",26);
        System.out.println(student1);
        /*
        * i) To add data, you need Session(Interface). To create a Session, you need SessionFactory(Interface).
        * To create a SessionFactory, you need Configuration(Class) which has .buildSessionFactory() method.
        *
        * ii)Try to use only one SessionFactory one per database since it uses a lot of resources.
        * */
//        Configuration cfg1 = new Configuration();
//        // addAnnotatedClass() is used for the hibernate to recognize WHICH ANNOTATED ENTITY CLASS is going to be used
//        cfg1.addAnnotatedClass(org.example.Students.class);
//        cfg1.configure(); // loads hibernate configuration from xml file which contains details like url, username, password.

        SessionFactory sf1 = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session session1 = sf1.openSession();
        Transaction transaction = session1.beginTransaction();
        session1.persist(student1); // cant use save() since it was deprecated. now we use persist()
        session1.close();
        sf1.close();
        transaction.commit();
    }
}