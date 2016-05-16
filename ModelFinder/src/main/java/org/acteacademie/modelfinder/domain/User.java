package org.acteacademie.modelfinder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	@Id
	@Column(name="ID_USER")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="EMAIL", unique=true, nullable=false)
	private String mail;
	
	@Column(name="PASSWORD", unique=false, nullable=false)
	private String password;
	
	@Column(name="ROLE", unique=false, nullable=false)
	private String role;
	
	@Column(name="IS_VALIDATED", unique=false, nullable=false)
	private Boolean isValidated;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getIsValidated() {
		return isValidated;
	}

	public void setIsValidated(Boolean isValidated) {
		this.isValidated = isValidated;
	}
}
