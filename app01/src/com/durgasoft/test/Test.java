package com.durgasoft.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durgasoft.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Employee emp = new Employee();
		emp.setEno(333);
		emp.setEname("CCC");
		emp.setEsal(7000);
		emp.setEaddr("DEL");
		Transaction tx = session.beginTransaction();
        try {
			session.persist(emp);
			tx.commit();
			System.out.println("Inserted Successfully!");
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
        session.close();
        sf.close();

	}

}
