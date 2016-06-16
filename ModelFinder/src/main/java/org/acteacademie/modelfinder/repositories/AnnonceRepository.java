package org.acteacademie.modelfinder.repositories;


import java.util.Collection;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface AnnonceRepository extends CrudRepository<Annonce, Long>{
	
	Collection<Annonce> findAll();
	
	Annonce findOne(Long id);
	
	Collection<Annonce> findByStatus(String status);

	Collection<Annonce> findByStudent(Student student);
}
