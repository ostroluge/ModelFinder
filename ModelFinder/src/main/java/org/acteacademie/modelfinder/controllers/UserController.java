package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Resource
	UserService userService;
	
	@CrossOrigin
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Collection<User> getAll() {
		return this.userService.getAllUsers();
	}

	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse loginSubmit(@RequestBody User user) {
		StringResponse response;
		if (isAuthorized(user)) {
			response = new StringResponse("succes");
		} else {
			response = new StringResponse("fail");
		}
		return response;
	}

	private boolean isAuthorized(User userToCheck) {
		for (User user : userService.getAllUsers()) {
			if (user.getMail().equals(userToCheck.getMail())) {
				return true;
			}
		}
		return false;
	}
}
