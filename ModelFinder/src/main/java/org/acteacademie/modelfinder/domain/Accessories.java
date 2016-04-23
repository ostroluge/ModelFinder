package org.acteacademie.modelfinder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GROUP_ACCESSORY")
public class Accessories {
	
	@Id
	@Column(name="ID_GROUPE_ACCESSOIRE")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idAccessories;
	
	@Column(name="WORDING_ACCESSORY_1", unique = false, nullable = true)
	private String accessory1;
	
	@Column(name="WORDING_ACCESSORY_2", unique = false, nullable = true)
	private String accessory2;

	@Column(name="WORDING_ACCESSORY_3", unique = false, nullable = true)
	private String accessory3;
	
	@Column(name="WORDING_ACCESSORY_4", unique = false, nullable = true)
	private String accessory4;
	
	@Column(name="WORDING_ACCESSORY_5", unique = false, nullable = true)
	private String accessory5;
	
	public long getIdAccessories(){
		return this.idAccessories;
	}
	
	public void setIdAccessories(long idAccessories){
		this.idAccessories = idAccessories;
	}
	
	public String getAccessory1(){
		return this.accessory1;
	}
	
	public void setAccessory1(String accessory1){
		this.accessory1 = accessory1;
	}
	
	public String getAccessory2(){
		return this.accessory2;
	}
	
	public void setAccessory2(String accessory2){
		this.accessory2 = accessory2;
	}
	
	public String getAccessory3(){
		return this.accessory3;
	}
	
	public void setAccessory3(String accessory3){
		this.accessory3 = accessory3;
	}
	
	public String getAccessory4(){
		return this.accessory4;
	}
	
	public void setAccessory4(String accessory4){
		this.accessory4 = accessory4;
	}
	
	public String getAccessory5(){
		return this.accessory5;
	}
	
	public void setAccessory5(String accessory5){
		this.accessory5 = accessory5;
	}
}
