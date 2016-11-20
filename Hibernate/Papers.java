package org.myHibernate.java.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

public class Paper {
	
	private int paper_id;
	private String title; 
	private int student_id;   
	private String grade;  

	public Paper() {}
	public Paper(int p_id, String title, int s_id, String grade) {
		this.paper_id = p_id;
		this.title = title;
		this.student_id = s_id;
		this.grade = grade;
	}
	
	// Getters and setters for the class
	public int getPaperId() {
		return paper_id;
	}
	
	public void setPaperId( int paper_id ) {
      this.paper_id = paper_id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle( String title) {
		this.title = title;
   }
	
	public int getStudentId() {
		return student_id;
	}
	
	public void setStudentId( int student_id ) {
      this.student_id = student_id;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String g) {
		this.grade = g;
	}
	
}
