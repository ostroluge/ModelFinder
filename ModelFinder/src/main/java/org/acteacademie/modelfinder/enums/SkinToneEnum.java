package org.acteacademie.modelfinder.enums;

public enum SkinToneEnum {

	CLAIRE("Claire"),
	MOYENNE("Moyenne"),
	FONCEE("Foncée");
	
	  private String tone = "";
	   
	  private SkinToneEnum(String tone){
	    this.tone = tone;
	  }
	  
	  public String getTone(){
		  return this.tone;
	  }
}
