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
		
		@Column(name="PASSWORD_STUDENT", unique = false, nullable = false)
		private String password;
		
		@Column(name="BIRTH_DATE", unique = false, nullable = false)
		private Date birthDate;
		
		@Column(name="EMAIL", unique = true, nullable = false)
		private String mail;
		
		@Column(name="LAST_NAME", unique = false, nullable = false)
		private String lastName;

		@Column(name="FIRST_NAME", unique = false, nullable = false)
		private String firstName;
		
		@Column(name="IS_VALIDATED", unique = false, nullable = false)
		private Boolean isValidated;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Date getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public Boolean getIsValidated() {
			return isValidated;
		}

		public void setIsValidated(Boolean isValidated) {
			this.isValidated = isValidated;
		}
		
}