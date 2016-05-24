package org.acteacademie.modelfinder.repositories;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Accessories;
import org.springframework.data.repository.CrudRepository;

public interface AccessoriesRepository  extends CrudRepository<Accessories, Long>{

	Accessories findOne(Long id);
	
	Collection<Accessories> findAll();

}
