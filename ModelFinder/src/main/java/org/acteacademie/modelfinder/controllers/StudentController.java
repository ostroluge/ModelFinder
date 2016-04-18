package org.acteacademie.modelfinder.controllers;

import java.util.Collection;
import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Student;
import org.acteacademie.modelfinder.services.StudentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Resource
	StudentService studentService;
	
	@CrossOrigin
	@RequestMapping("/studentList")
	public Collection<Student> getAll(){
		return this.studentService.getAllStudent();
	}
	
	@CrossOrigin
	@RequestMapping("/StudentById/{id}")
	public Student getOne(@PathVariable("id") Long id){
		return this.studentService.getOneStudent(id);
	}
}