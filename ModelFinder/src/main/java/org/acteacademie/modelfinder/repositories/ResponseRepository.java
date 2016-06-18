package org.acteacademie.modelfinder.repositories;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.domain.Response;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ResponseRepository extends CrudRepository<Response, Long>{
	
	Collection<Response> findAll();
	
	Response findOne(Long id);
	
	void delete(Long id);
	
	Collection<Response> findByAnnonceAndModel(Annonce annonce,Model model);
	
	Collection<Response> findByAnnonce(Annonce annonce);
	
	Collection <Response> findByAnnonceAndStatut(Annonce annonce, String statut);
	
	Collection<Response> findByModel(Model model);

	@Query(value = "select * from R_RESPONSE, SERVICE "
			+ "where R_RESPONSE.annonce_id = SERVICE.id_annonce "
			+ "and SERVICE.etudiant_id = :student_id", nativeQuery = true)
	Collection<Response> getByStudent(@Param("student_id") Long student_id);
}