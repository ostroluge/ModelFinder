package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Response;

public interface ResponseService {

	Collection<Response> getAllReponse();
	
	Response getOneReponse(long id);

	void saveReponse(Response reponse);
	
	void deleteReponse(long id);

}
