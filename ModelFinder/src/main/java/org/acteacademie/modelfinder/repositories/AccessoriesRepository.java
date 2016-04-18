package org.acteacademie.modelfinder.repositories;

import org.acteacademie.modelfinder.domain.Accessories;
import org.springframework.data.repository.CrudRepository;

public interface AccessoriesRepository  extends CrudRepository<Accessories, Long>{

	Accessories findOne(Long id);
}
