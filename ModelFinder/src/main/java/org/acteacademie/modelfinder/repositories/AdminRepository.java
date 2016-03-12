package org.acteacademie.modelfinder.repositories;

import java.util.List;

import org.acteacademie.modelfinder.domain.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long>{
	
	List<Admin> findAll();
	
	Admin findOne(Long id);
}