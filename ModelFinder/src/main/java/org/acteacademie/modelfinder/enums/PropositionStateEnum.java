package org.acteacademie.modelfinder.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PropositionStateEnum {
	
	VALIDEE("Validée"),
	EN_ATTENTE("En attente"),
	REFUSEE("Refusée");
	
	 private String state = "";
	   
	  private PropositionStateEnum(String state){
	    this.state = state;
	  }
	  
	  @JsonValue
	  public String getState(){
		  return this.state;
	  }
	  
	  @JsonCreator
	  public static PropositionStateEnum fromValue(String prop){
		  for(final PropositionStateEnum proposition : PropositionStateEnum.values()){
			  if(proposition.getState().equals(prop)){
				  return proposition;
			  }
		  }
		  throw new IllegalArgumentException(prop);
	  }
}
