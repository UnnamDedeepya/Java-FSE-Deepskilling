package com.cognizant.hibernatexml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();

        Employee e1 = new Employee("Dedeepya", 80000);
        session.save(e1);

        List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
        for (Employee e : employees) {
            System.out.println(e);
        }

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
