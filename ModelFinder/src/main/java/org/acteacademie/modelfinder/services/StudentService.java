package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Student;

public interface StudentService {

	Collection<Student> getAllStudent();

	Student getOneStudent(Long id);
	
	Student saveStudent(Student student);
	
	void deleteStudent(Long id);

}
