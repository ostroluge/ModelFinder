package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.domain.Response;
import org.acteacademie.modelfinder.domain.Student;

public interface ResponseService {

	Collection<Response> getAllReponse();
	
	Response getOneReponse(long id);

	void saveReponse(Response reponse);
	
	void deleteReponse(long id);

	Collection<Response> findByModel(Model model);
	
	Collection<Response> findByAnnonceAndModel(Annonce annonce,Model model);
	
	Collection<Response> findByAnnonce(Annonce annonce);	

	Collection <Response> findByAnnonceAndStatut(Annonce annonce, String statut);

	Collection<Response> getByStudent(Student student);
}
