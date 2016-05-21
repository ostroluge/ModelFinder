package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.User;
import org.springframework.security.core.Authentication;

public interface UserService {

	Collection<User> getAllUsers();
	
	User getUserByMail(String email);
	
//	User getLoggedInUser(Authentication authentication);
}
