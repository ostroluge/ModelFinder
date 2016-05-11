package org.acteacademie.modelfinder.domain;

public class StringResponse {

	String response;
	
	public StringResponse(String string){
		response=string;
	}
	
	public String getResponse(){
		return this.response;
	}

	public void setResponse(String response){
		this.response = response;
	}
}
