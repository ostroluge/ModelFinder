package org.acteacademie.modelfinder.domain.customobject;

import org.acteacademie.modelfinder.domain.Student;
import org.acteacademie.modelfinder.domain.User;

public class UserStudent {

	private User user;
	
	private Student student;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
