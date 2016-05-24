package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

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
	public ResponseEntity<User> loginSubmit(@RequestBody User user) {
		if (isAuthorized(user)) {
			User authenticatedUser = this.userService.getUserByMail(user.getMail());
			authenticatedUser.setPassword(null);
			return ResponseEntity.ok(authenticatedUser);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(null);
		}
	}

	private boolean isAuthorized(User userToCheck) {

		User user = this.userService.getUserByMail(userToCheck.getMail());
		if(user != null){
			String encodedPassword = Hashing.sha1().hashString(userToCheck.getPassword(), Charsets.UTF_8 ).toString();
			if(user.getPassword().equals(encodedPassword)){
				return true;
			}
		}
		return false;
	}
}
