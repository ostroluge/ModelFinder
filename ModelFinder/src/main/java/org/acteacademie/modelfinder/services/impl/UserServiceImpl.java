package org.acteacademie.modelfinder.services.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.repositories.UserRepository;
import org.acteacademie.modelfinder.services.UserService;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;
	
	@Override
	public Collection<User> getAllUsers() {
		return this.userRepository.findAll();
	}
}