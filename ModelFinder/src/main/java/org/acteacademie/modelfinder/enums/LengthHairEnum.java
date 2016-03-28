package org.acteacademie.modelfinder.enums;

public enum LengthHairEnum {

		  COURTS("Courts"),
		  MI_LONGS("Mi-longs"),
		  LONGS("Longs");

		  private String length = "";
		   
		  private LengthHairEnum(String length){
		    this.length = length;
		  }
		  
		  public String getLength(){
			  return this.length;
		  }
}
