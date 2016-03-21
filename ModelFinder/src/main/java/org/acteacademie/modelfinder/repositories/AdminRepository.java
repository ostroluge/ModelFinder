package org.acteacademie.modelfinder.repositories;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long>{
	
	Collection<Admin> findAll();
}