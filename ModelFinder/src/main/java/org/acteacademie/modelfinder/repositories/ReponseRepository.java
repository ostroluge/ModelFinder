package org.acteacademie.modelfinder.repositories;

import java.util.Collection;
import org.acteacademie.modelfinder.domain.Reponse;
import org.springframework.data.repository.CrudRepository;

public interface ReponseRepository extends CrudRepository<Reponse, Long>{
	
	Collection<Reponse> findAll();
	
	Reponse findOne(Long id);
}