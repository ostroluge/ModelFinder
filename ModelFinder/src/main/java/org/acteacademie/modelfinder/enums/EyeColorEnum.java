package org.acteacademie.modelfinder.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EyeColorEnum {

		  BLEUS("Bleus"),
		  MARRONS("Marrons"),
		  VERTS("Verts");

		  private String color = "";
		   
		  private EyeColorEnum(String color){
		    this.color = color;
		  }
		  
		  @JsonValue
		  public String getColor(){
			  return this.color;
		  }
		  
		  @JsonCreator
		  public static EyeColorEnum fromValue(String color){
			  for(final EyeColorEnum eyeColor : EyeColorEnum.values()){
				  if(eyeColor.getColor().equals(color)){
					  return eyeColor;
				  }
			  }
			  throw new IllegalArgumentException(color);
		  }
}
