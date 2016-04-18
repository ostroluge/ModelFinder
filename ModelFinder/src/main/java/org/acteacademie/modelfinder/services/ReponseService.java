package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Reponse;

public interface ReponseService {

	Collection<Reponse> getAllReponse();
	
	Reponse getOneReponse(long id);

	void saveReponse(Reponse reponse);

}
