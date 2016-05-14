package org.acteacademie.modelfinder.repositories;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.domain.Response;
import org.springframework.data.repository.CrudRepository;

public interface ResponseRepository extends CrudRepository<Response, Long>{
	
	Collection<Response> findAll();
	
	Response findOne(Long id);
	
	void delete(Long id);
	
	Collection<Response> findByAnnonceAndModel(Annonce annonce,Model model);
	
	Collection<Response> findByAnnonce(Annonce annonce);
	
	Collection <Response> findByAnnonceAndStatut(Annonce annonce, String statut);
}