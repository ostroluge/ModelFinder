package org.acteacademie.modelfinder.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SkinToneEnum {

	CLAIRE("Claire"),
	MOYENNE("Moyenne"),
	FONCEE("Foncée");
	
	  private String tone = "";
	   
	  private SkinToneEnum(String tone){
	    this.tone = tone;
	  }
	  
	  @JsonValue
	  public String getTone(){
		  return this.tone;
	  }
	  
	  @JsonCreator
	  public static SkinToneEnum fromValue(String tone){
		  for(final SkinToneEnum skinTone : SkinToneEnum.values()){
			  if(skinTone.getTone().equals(tone)){
				  return skinTone;
			  }
		  }
		  throw new IllegalArgumentException(tone);
	  }
}
