package org.acteacademie.modelfinder.enums;

public enum CategoriesEnum {

	SHOOTING_MODE("Shooting mode"),
	SHOOTING_BEAUTE("Shooting beauté"),
	SHOOTING_SFX("Shooting SFX"),
	BODY_PAINTING("Body-painting"),
	FACE_PAINTING("Face-painting");

	 private String category = "";
	   
	  private CategoriesEnum(String category){
	    this.category = category;
	  }
	  
	  public String getCategory(){
		  return this.category;
	  }
}
