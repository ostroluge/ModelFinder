package org.acteacademie.modelfinder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="PHOTO")
public class Photo {
	
	@Id
	@Column(name="ID_PHOTO")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Lob
	@Column(name="FILE", unique = false, nullable = true)
	private String file;

	protected Photo(){}
	
	public Photo(String data) {
		this.file = data;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}