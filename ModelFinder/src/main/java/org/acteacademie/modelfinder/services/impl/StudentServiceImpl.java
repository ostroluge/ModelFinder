package org.acteacademie.modelfinder.services.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Student;
import org.acteacademie.modelfinder.repositories.StudentRepository;
import org.acteacademie.modelfinder.services.StudentService;
import org.springframework.stereotype.Service;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentRepository studentRepository;
	
	@Override
	public Collection<Student> getAllStudent(){
		return this.studentRepository.findAll();
	}
	
	@Override
	public Student getOneStudent(Long id) {
		return this.studentRepository.findOne(id);
	}

	@Override
	public Student saveStudent(Student student) {
		return this.studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		this.studentRepository.delete(id);
	}
	
}
