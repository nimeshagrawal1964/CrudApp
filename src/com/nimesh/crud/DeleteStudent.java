package com.nimesh.crud;

import com.nimesh.crud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get student
            int studentId = 4;
            Student tempStudent = session.get(Student.class, studentId);

            session.delete(tempStudent);

            /*
            session
                    .createQuery("delete from Student where id=4")
                    .executeUpdate();
             */

            session.getTransaction().commit();
            
        }
        finally {
            factory.close();
        }

    }

}