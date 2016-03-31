package org.acteacademie.modelfinder.repositories;


import java.io.Serializable;
import java.util.Collection;

import org.acteacademie.modelfinder.domain.Annonce;
import org.springframework.data.repository.CrudRepository;

public interface AnnonceRepository<T, ID extends Serializable> extends CrudRepository<Annonce, Long>{
	
	Collection<Annonce> findAll();
	
	Annonce findOne(Long id);
}
