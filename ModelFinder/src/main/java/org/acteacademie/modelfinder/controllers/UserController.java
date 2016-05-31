package org.acteacademie.modelfinder.controllers;

import java.security.Principal;
import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.services.UserService;
import org.springframework.context.annotation.Scope;
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
@Scope("session")
public class UserController {

	@Resource
	UserService userService;
	
	@RequestMapping("/user")
	public String user(Principal user, HttpServletRequest request, HttpSession session) {
		System.out.println("/user : SESSION ID = " + session.getId());
		System.out.println("/user : " + (String) request.getSession().getAttribute("USER_ROLE"));
		return (String) session.getAttribute("USER_ROLE");
	}
	
	@CrossOrigin
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Collection<User> getAll() {
		return this.userService.getAllUsers();
	}

	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<User> loginSubmit(@RequestBody User user, HttpServletRequest request, HttpSession session) {
		if (isAuthorized(user)) {
			User authenticatedUser = this.userService.getUserByMail(user.getMail());
			authenticatedUser.setPassword(null);
			
			session.invalidate();
			HttpSession newSession = request.getSession();
			newSession.setAttribute("USER_ROLE", authenticatedUser.getRole());
			
			System.out.println("/login : SESSION ID = " + newSession.getId());
			System.out.println("/login : " + newSession.getAttribute("USER_ROLE"));
			
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
