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
		
		Student student3 = new Student("Aragorn", "Son of Arathorn", "3.1");
		student3.setId(3);
		
		Student student2 = new Student("Bilbo", "Baggins", "3.3");
		student4.setId(4);
	
		Paper paper1 = new Paper(1, "The Effects of Lightning Spells on Ents", 2, "Not graded");
		Paper paper2 = new Paper(2, "Origins of the Baggins Clan", 4, "A-");
		Paper paper3 = new Paper(3, "Late History of Moria", 2, "A+");
		Paper paper4 = new Paper(4, "My Impressions of the Wood Elves", 3, "B-");
		Paper paper5 = new Paper(5, "Maximum Carrying Capacity of Great Eagles", 2, "A+");
		
		// Happy path to submit objects:
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);
		session.save(paper1);
		session.save(paper2);
		session.save(paper3);
		session.save(paper4);
		session.save(paper5);
		
		// Nasty path (using a name that doesn't exist):
		try {
			session.save(student10);
		}
		catch (Exception e) {
			System.out.println("No student with an id of 10");
		}
		
		// Commit the changes as we do in MySQL
		session.getTransaction().commit();	
		
//////////////////One to many relationship
		
		//A JOIN query that uses student_id as a foreign key
		session.createQuery("SELECT * FROM paper JOIN students USING(student_id)").executeUpdate();
		
		//Create a one to many relationship between student and paper tables using student_id as the foreign key
		session.createQuery("ALTER TABLE paper ADD CONSTRAINT papers_to_students "
				    + "FOREIGN KEY (student_id) "
				    + "REFERENCES student (student_id);").executeUpdate();
		
		//Delete all of Galdalf's papers using his name
		session.createQuery("DELETE FROM paper WHERE "
				    + "student_id=(SELECT student_id FROM student WHERE "
				    + "firstName=\"Gandalf\");").executeUpdate();
		
		//Nasty path to add a paper (it references a student that doesn't exist)
		session.createQuery("INSERT INTO paper "
				    + "VALUES (6, \"Methods of Storing Dwarvish Ale in Cold Climates\", 8, \"B-\"").executeUpdate();
		
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
