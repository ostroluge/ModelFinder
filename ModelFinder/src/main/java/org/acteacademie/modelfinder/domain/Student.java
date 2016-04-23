package org.acteacademie.modelfinder.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="STUDENT")
	public class Student{
		
		@Id
		@Column(name="ID_ETUDIANT")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		
		@Column(name="BIRTH_DATE", unique = false, nullable = false)
		private Date birthDate;
		
		@Column(name="EMAIL", unique = true, nullable = false)
		private String mail;
		
		@Column(name="LAST_NAME", unique = false, nullable = false)
		private String lastName;

		@Column(name="FIRST_NAME", unique = false, nullable = false)
		private String firstName;
		
		
	    @Override
	    public String toString() {
	        return String.format(
	                "Student[id=%d, firstName='%s', lastName='%s', email='%s', birthDate='%s']",
	                id, firstName, lastName,mail,birthDate.toString());
	    }
		
		public long getIdStudent(){
			return this.id;
		}
		
		private void setIdStudent(long idStudent){
			this.id = idStudent;
		}
		
	    public String getMail(){
	    	return this.mail;
	    }
	    
	    private void setMail(String mail){
	    	this.mail = mail;
	    }
	    
	    public String getLastName(){
	    	return this.lastName;
	    }
	    
	    private void setLastName(String lastName){
	    	this.lastName = lastName;
	    }
	    
	    public String getFirstName(){
	    	return this.firstName;
	    }
	    
		private void setFirstName(String firstName){
	    	this.firstName = firstName;
	    }
		
		public Date getBirthDate(){
			return this.birthDate;
		}
		
		private void setBirthDate(Date birthDate){
			this.birthDate = birthDate;
		}
		
}
