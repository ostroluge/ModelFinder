package org.acteacademie.modelfinder.controllers;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.domain.Student;
import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.domain.customobject.UserStudent;
import org.acteacademie.modelfinder.enums.RoleEnum;
import org.acteacademie.modelfinder.services.AuthorizationService;
import org.acteacademie.modelfinder.services.StudentService;
import org.acteacademie.modelfinder.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

@RestController
public class StudentController {
	
	@Resource
	AuthorizationService authorizationService;
	
	@Resource
	StudentService studentService;
	
	@Resource
	UserService userService;
	
	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRole('admin',#session)")
	@RequestMapping("/studentList")
	public Collection<Student> getAll(HttpSession session){
		return this.studentService.getAllStudent();
	}
	
	public UserStudent UserStudentByStudent(Student student){
		UserStudent us = new UserStudent();
		us.setUser(this.userService.getUserById(student.getId()));
		us.setStudent(student);
		return us;
	}
	
	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRole('admin',#session)")
	@RequestMapping("/userStudentListVal")
	public Collection<UserStudent> getUserStudentVal(HttpSession session){
		Collection<UserStudent> students = new ArrayList<UserStudent>();
		for (Student student:this.studentService.getAllStudent()){
			if (this.userService.getUserById(student.getId()).getIsValidated()){
				students.add(UserStudentByStudent(student));
			}
		}
		return students;
	}
	
	@PreAuthorize("@authorizationService.hasRole('admin',#session)")
	@CrossOrigin
	@RequestMapping("/userStudentListWaitingVal")
	public Collection<UserStudent> getUserStudentWaitingVal(HttpSession session){
		Collection<UserStudent> students = new ArrayList<UserStudent>();
		for (Student student:this.studentService.getAllStudent()){
			if (!this.userService.getUserById(student.getId()).getIsValidated()){
				students.add(UserStudentByStudent(student));
			}
		}
		return students;
	}
	
	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRoleOrIsAuthor('admin', #id, #session)")
	@RequestMapping("/studentById/{id}")
	public UserStudent getOne(@PathVariable("id") Long id, HttpSession session){
		UserStudent student = new UserStudent();
		student.setUser(this.userService.getUserById(id));
		student.setStudent(this.studentService.getOneStudent(id));
		return student;
	}
	
	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRole('admin',#session)")
	@RequestMapping("/validateStudent/{id}")
	public StringResponse validateStudent(@PathVariable("id") Long id, HttpSession session){
		User user = this.userService.getUserById(id);
		if(user.getRole().equals(RoleEnum.STUDENT.getRole())){
			user.setIsValidated(true);
		} else{
			return new StringResponse("error");
		}
		this.userService.saveUser(user);
		return new StringResponse("success");
	}

	
	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRole('student',#session)")
	@RequestMapping(value="/modifyStudent", method=RequestMethod.POST, produces = "application/json")
	public StringResponse modifyStudent(@RequestBody UserStudent userstudent, HttpSession session){
		User user = userstudent.getUser();
		Student student = userstudent.getStudent();
		user = this.userService.saveUser(user);
		this.studentService.saveStudent(student);
		return new StringResponse("success");
	}
	
	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRole('student',#session)")
	@RequestMapping(value="/modifyStudentAndPassword", method=RequestMethod.POST, produces = "application/json")
	public StringResponse modifiyStudentAndPassword(@RequestBody UserStudent userstudent, HttpSession session){
		User user = userstudent.getUser();
		Student student = userstudent.getStudent();
		user.setPassword(Hashing.sha1().hashString(user.getPassword(), Charsets.UTF_8 ).toString());
		user = this.userService.saveUser(user);
		this.studentService.saveStudent(student);
		return new StringResponse("success");
	}
	
	@CrossOrigin
	@RequestMapping(value="/saveStudent", method=RequestMethod.POST, produces = "application/json")
	public StringResponse saveStudent(@RequestBody UserStudent userstudent){
		User user = userstudent.getUser();
		Student student = userstudent.getStudent();
		user.setPassword(Hashing.sha1().hashString(user.getPassword(), Charsets.UTF_8 ).toString());
		user = this.userService.saveUser(user);
		student.setId(user.getId());
		this.studentService.saveStudent(student);
		return new StringResponse("success");
	}

	
	@CrossOrigin
	@RequestMapping("/deleteStudent/{id}")
	@PreAuthorize("@authorizationService.hasAnyRole('admin','student',#session)")
	public StringResponse deleteStudent(@PathVariable("id") Long id, HttpSession session){
		this.studentService.deleteStudent(id);
		this.userService.deleteUser(id);
		return new StringResponse("success");
	}
}