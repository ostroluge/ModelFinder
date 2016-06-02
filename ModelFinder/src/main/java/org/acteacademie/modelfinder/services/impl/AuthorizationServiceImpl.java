package org.acteacademie.modelfinder.services.impl;

import javax.servlet.http.HttpSession;

import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.services.AuthorizationService;
import org.springframework.stereotype.Component;

@Component("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService{

	@Override
	public Boolean hasRole(String role, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		
		if(user.getRole().equals(role)){
			return true;
		}
		
		return false;
	}

}
