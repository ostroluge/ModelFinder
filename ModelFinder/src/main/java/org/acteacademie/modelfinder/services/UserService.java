package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.User;

public interface UserService {

	Collection<User> getAllUsers();
	
	User getUserByMail(String email);
	
	User getUserById(Long id);
	
	User saveUser(User user);
}
