package org.acteacademie.modelfinder.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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
	  
	  @JsonValue
	  public String getCategory(){
		  return this.category;
	  }
	  
	  @JsonCreator
	  public static CategoriesEnum fromValue(String val) {
	        for (final  CategoriesEnum code : CategoriesEnum.values()) {
	            if (code.getCategory().equals(val)) {
	                return code;
	            }
	        }
	        throw new IllegalArgumentException(val);
	  }
}
