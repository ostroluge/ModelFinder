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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_admin;
	
	@Column(unique = false, nullable = false)
	private String mail;
	
	@Column(unique = false, nullable = false)
	private String nom;

	@Column(unique = false, nullable = false)
	private String prenom;
	
	protected Admin(){}
	
	public Admin(String lastName, String firstName,String mail){
		this.prenom=firstName;
		this.nom=lastName;
		this.mail=mail;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Admin[id=%d, firstName='%s', lastName='%s', email='%s']",
                id_admin, prenom, nom,mail);
    }
}