package org.acteacademie.modelfinder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN")
public class Admin {

	@Id
	@Column(name="ID_ADMIN")
	private long id;

	@Column(name="LAST_NAME", unique = false, nullable = false)
	private String lastName;

	@Column(name="FIRST_NAME", unique = false, nullable = false)
	private String firstName;

	protected Admin(){}

	public Admin(String lastName, String firstName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Admin [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + "]";
	}
}