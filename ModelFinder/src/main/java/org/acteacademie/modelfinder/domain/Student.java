package org.acteacademie.modelfinder.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {

	@Id
	@Column(name="ID_ETUDIANT")
	private long id;

	@Column(name="BIRTH_DATE", unique = false, nullable = false)
	private Date birthDate;

	@Column(name="LAST_NAME", unique = false, nullable = false)
	private String lastName;

	@Column(name="FIRST_NAME", unique = false, nullable = false)
	private String firstName;

	@Override
	public String toString() {
		return "Student [id=" + id + ", birthDate=" + birthDate + ", lastName=" + lastName + ", firstName=" + firstName
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
}
