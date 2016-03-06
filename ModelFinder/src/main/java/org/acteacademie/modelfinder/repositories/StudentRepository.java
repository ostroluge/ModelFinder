package org.acteacademie.modelfinder.repositories;

import java.util.List;

import org.acteacademie.modelfinder.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	List<Student> findAll();
}