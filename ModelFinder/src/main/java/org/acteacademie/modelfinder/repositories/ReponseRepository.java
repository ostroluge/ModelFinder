package org.acteacademie.modelfinder.repositories;

import java.util.Collection;
import org.acteacademie.modelfinder.domain.Response;
import org.springframework.data.repository.CrudRepository;

public interface ReponseRepository extends CrudRepository<Response, Long>{
	
	Collection<Response> findAll();
	
	Response findOne(Long id);
	
	void delete(Long id);
}