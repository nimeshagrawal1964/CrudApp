package com.nimesh.crud;

import com.nimesh.crud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadStudent {

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

            // get multiple Students
            List<Student> result = session
                                    .createQuery("from Student where lastName='Agrawal'" + " OR email LIKE '%gmail.com'")
                                    .getResultList();

            System.out.println(result);

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }

}