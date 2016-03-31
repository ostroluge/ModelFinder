package org.acteacademie.modelfinder.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LengthHairEnum {

		  COURTS("Courts"),
		  MI_LONGS("Mi-longs"),
		  LONGS("Longs");

		  private String length;
		   
		  private LengthHairEnum(String length){
		    this.length = length;
		  }
		  
		  @JsonValue
		  public String getLength(){
			  return this.length;
		  }
		  
		  @JsonCreator
		  public static LengthHairEnum fromValue(String length){
			  for(final LengthHairEnum lengthHair : LengthHairEnum.values()){
				  if(lengthHair.getLength().equals(length)){
					  return lengthHair;
				  }
			  }
			  throw new IllegalArgumentException(length);
		  }
}
