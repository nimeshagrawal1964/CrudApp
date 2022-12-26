package com.nimesh.crud;

import com.nimesh.crud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMultipleStudents {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // use the session object to save Java object

            // create multiple Student objects
            System.out.println("Creating new Student objects ... ");
            Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
            Student tempStudent2 = new Student("Jane", "Doe", "jane@gmail.com");
            Student tempStudent3 = new Student("Mary", "Jane", "mary@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student objects
            System.out.println("Saving the students ... ");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            session.flush();
            session.close();
            factory.close();
        }

    }

}
