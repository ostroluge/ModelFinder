package org.acteacademie.modelfinder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN")
public class Admin {

	@Id
	@Column(name="ID_ADMIN")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(unique = false, nullable = false)
	private String mail;
	
	@Column(name="NOM", unique = false, nullable = false)
	private String lastName;

	@Column(name="PRENOM", unique = false, nullable = false)
	private String firstName;
	
	protected Admin(){}
	
	public Admin(String lastName, String firstName,String mail){
		this.firstName=firstName;
		this.lastName=lastName;
		this.mail=mail;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Admin[id=%d, firstName='%s', lastName='%s', email='%s']",
                id, firstName, lastName,mail);
    }
    
    public long getIdAdmin(){
    	return this.id;
    }
    
    private void setIdAdmin(long idAdmin){
    	this.id = idAdmin;
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
}