package org.myHibernate.hibernate;

import org.myHibernate.java.dto.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;
import java.util.*;

// This class does the 4 basic operations with the database: Create, Read, Update, Delete

public class HibernateCRUD {

	public static void main(String[] args) {
		// A happy path to start using Hibernate.
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		// Starting a new session
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Creating a couple of records
		Student student1 = new Student("Frodo", "Baggins", "2.5");
		student1.setId(1);

		Student student2 = new Student("Gandalf", "The Grey", "3.9");
		student2.setId(2);
		
		// Happy path to submit an object:
		session.save(student1);
		
		// Nasty path (using a name that doesn't exist):
		try {
			session.save(student10);
		}
		catch (Exception e) {
			System.out.println("No student with an id of 10");
		}
		
		// Commit the changes as we do in MySQL
		session.getTransaction().commit();		
		
		// Reading a record with an id of 1
		Student student3 = (Student) session.get(Student.class, new Integer(1));
		// A nasty path to read from a database:
		//System.out.println("Student3's name: " + student3.getName());		
		// A better path:
		if (student3 == null) {
			System.out.println("No student with an id of 1");
		} else {
			System.out.println("Student3's name: " + student3.getName());
		}

		// Update a last name and a gpa number for a record
		Student student2 = (Student) session.load(Student.class, new Integer(2));
		student2.setLastName("The White");
		student2.setGpa("4.0");
		session.update(student2);

		// A nasty path to deleting a record
		try {
			session.delete(student5);
		} catch (Exception e) {
			System.out.println("No record to delete!");
		}
		// A happy path for it
		session.createQuery("DELETE FROM student WHERE id=1").executeUpdate();

		// Commit the transaction and close the session
		session.getTransaction().commit();
		session.close();
	}
}
