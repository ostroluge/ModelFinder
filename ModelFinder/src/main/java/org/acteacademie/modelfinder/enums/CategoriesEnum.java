	package org.acteacademie.modelfinder.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
	  public static CategoriesEnum fromValue(String cat) {
	        for (final  CategoriesEnum category : CategoriesEnum.values()) {
	            if (category.getCategory().equals(cat)) {
	                return category;
	            }
	        }
	        throw new IllegalArgumentException(cat);
	  }
}
