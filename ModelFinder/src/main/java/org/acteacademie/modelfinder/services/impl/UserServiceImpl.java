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
		Collection<User> user = this.userRepository.findAll();
		return user;
	}

	@Override
	public User getUserByMail(String email) {
		User user = this.userRepository.findUserByMail(email);
		return user;
	}

	@Override
	public User getUserById(Long id) {
		User user = this.userRepository.findOne(id);
		return user;
	}

	public User saveUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		this.userRepository.delete(id);
	}

}
