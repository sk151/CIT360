package org.myHibernate.java.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// A simple class to work with
public class Student {
	private int id;
	private String firstName; 
	private String lastName;   
	private float gpa;  

	public Student() {}
	public Student(String fn, String ln, int gpa) {
		this.firstName = fn;
		this.lastName = ln;
		this.gpa = gpa;
	}
	
	// Getters ad setters for the class
	public int getId() {
		return id;
	}
	
	public void setId( int id ) {
      this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName( String fn) {
		this.firstName = fn;
   }
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName( String ln ) {
		this.lastName = ln;
	}
	
	public float getGPA() {
		return gpa;
	}
	
	public void setGPA(float g) {
		this.gpa = g;
	}
}
