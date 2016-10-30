package TomcatServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.myHibernate.java.dto.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

/* 
 * This servlet takes a json string from the user,
 * turns it into a Student object using Jackson
 * and uses Hibernate to persist.
 */
@WebServlet("/TomcatServlet")
public class JSON_Hibernate extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		PrintWriter myOutput = response.getWriter();
    
    //Getting a json string that the user put in:
    String s = request.getParameter("json");
		
    // Using Jackson to turn the input json into an object
    try{
        Student student1 = new ObjectMapper().readValue(s, Student.class);
    catch (Exception e) {
        myOutput.println("Bad JSON, check your syntax.");
    }
    
    		// A happy path to start using Hibernate.
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		// Starting a new session
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Happy path to submit an object:
		session.persist(student1);
		
	    	// Showing the user what has been submitted:
	 	myOutput.println("The new object derived from received JSON:");
		myOutput.println(student1.firstName);
		myOutput.println(student1.lastName);
		myOutput.println(student1.gpa);
    
		// Nasty path (using a name that doesn't exist):
		try {
			session.save(student10);
		}
		catch (Exception e) {
       			myOutput.println("No student with an id of 10");
		}
		
		// Commit the changes as we do in MySQL
		session.getTransaction().commit();		
		
		// Reading a record with an id of 1
		Student student3 = (Student) session.get(Student.class, new Integer(1));
		// A nasty path to read from a database:
		//System.out.println("Student3's name: " + student3.getName());		
		// A better path:
		if (student3 == null) {
			 myOutput.println("Error");
		} else {
      			myOutput.println("Student3's name: " + student3.getName());
		}

		// Update a last name and a gpa number for a record
		Student student1 = (Student) session.load(Student.class, new Integer(1));
		student1.setLastName("Billy Bob");
		student1.setGpa("4.0");
		session.update(student1);

		// A nasty path to deleting a record
		try {
			session.delete(student5);
		} catch (Exception e) {
			myOutput.println("No record to delete.");
		}
		// A happy path for it
		session.createQuery("DELETE FROM student WHERE id=1").executeUpdate();

		// Commit the transaction and close the session
		session.getTransaction().commit();
		session.close();
    		myOutput.println("All done. Session closed.");
  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
