package org.acteacademie.modelfinder.domain.customobject;

import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.domain.Model;

public class UserModel {

	private User user;
	
	private Model model;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
