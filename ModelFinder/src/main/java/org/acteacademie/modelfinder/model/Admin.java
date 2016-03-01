package org.acteacademie.modelfinder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;

@Entity
public class Admin {

	private @Id @GeneratedValue Long idAdmin;
	private String lastname;
	private String firstname;
	private String email;
	
	public Admin(String lastname, String firstname, String email) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
	}
	
}
