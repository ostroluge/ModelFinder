package org.acteacademie.modelfinder.domain.customobject;

public class ApplyForm {

	public int idModel;
	public String idAnnonce;
	public String comment;
	public String accessory1;
	public String accessory2;
	public String accessory3;
	public String accessory4;
	public String accessory5;

	public ApplyForm() {

	}
	
	public int getIdModel() {
		return idModel;
	}
	
	public void setIdModel(int idModel) {
		this.idModel = idModel;
	}
	
	public String getIdAnnonce() {
		return idAnnonce;
	}
	
	public void setIdAnnonce(String idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getAccessory1() {
		return accessory1;
	}
	
	public void setAccessory1(String accessory1) {
		this.accessory1 = accessory1;
	}
	
	public String getAccessory2() {
		return accessory2;
	}
	
	public void setAccessory2(String accessory2) {
		this.accessory2 = accessory2;
	}
	
	public String getAccessory3() {
		return accessory3;
	}
	
	public void setAccessory3(String accessory3) {
		this.accessory3 = accessory3;
	}
	
	public String getAccessory4() {
		return accessory4;
	}
	
	public void setAccessory4(String accessory4) {
		this.accessory4 = accessory4;
	}
	
	public String getAccessory5() {
		return accessory5;
	}
	
	public void setAccessory5(String accessory5) {
		this.accessory5 = accessory5;
	}

	@Override
	public String toString() {
		return "ApplyForm [idModel=" + idModel + ", idAnnonce=" + idAnnonce + ", comment=" + comment + ", accessory1="
				+ accessory1 + ", accessory2=" + accessory2 + ", accessory3=" + accessory3 + ", accessory4="
				+ accessory4 + ", accessory5=" + accessory5 + "]";
	}
}
