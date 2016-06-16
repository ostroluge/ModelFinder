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
	private byte[] file;
	
	@Column(name="TYPE", unique = false, nullable = true)
	private String type;

	public Photo(byte[] bytes, String mimeType) {
		this.file = bytes;
		this.type = mimeType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}