package org.acteacademie.modelfinder.domain;

public class StringResponseId {

	String response;
	
	Long id;
	
	public StringResponseId(String string, Long newId){
		response=string;
		id= newId;
	}
	
	public String getResponse(){
		return this.response;
	}

	public void setResponse(String response){
		this.response = response;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
}
