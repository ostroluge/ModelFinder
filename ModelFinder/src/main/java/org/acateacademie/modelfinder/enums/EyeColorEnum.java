package org.acateacademie.modelfinder.enums;

public enum EyeColorEnum {

		  BLEUS("Bleus"),
		  MARRONS("Marrons"),
		  VERTS("Verts");

		  private String color = "";
		   
		  private EyeColorEnum(String color){
		    this.color = color;
		  }
		  
		  public String getColor(){
			  return this.color;
		  }
}
