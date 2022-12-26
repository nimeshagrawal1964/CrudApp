package com.nimesh.crud;

import com.nimesh.crud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            // get Student by Id
            int studentId = 6;
            Student tempStudent = session.get(Student.class, studentId);

            tempStudent.setFirstName("Scooby");

            /*
            session
                    .createQuery("update Student set firstName='Scooby' where id=6")
                    .executeUpdate();
            */

            session.getTransaction().commit();
            
        }
        finally {
            factory.close();
        }

    }

}