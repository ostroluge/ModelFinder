package org.acateacademie.modelfinder.enums;

public enum PropositionStateEnum {
	
	VALIDEE("Validée"),
	EN_ATTENTE("En attente"),
	REFUSEE("Refusée");
	
	 private String state = "";
	   
	  private PropositionStateEnum(String state){
	    this.state = state;
	  }
	  
	  public String getState(){
		  return this.state;
	  }
}
