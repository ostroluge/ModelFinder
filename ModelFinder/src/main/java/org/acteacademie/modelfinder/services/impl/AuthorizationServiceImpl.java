package org.acteacademie.modelfinder.services.impl;

import javax.servlet.http.HttpSession;

import org.acteacademie.modelfinder.services.AuthorizationService;

public class AuthorizationServiceImpl implements AuthorizationService{

	@Override
	public Boolean hasRole(String role, HttpSession session) {
		if(session.getAttribute("USER_ROLE").equals(role)){
			return true;
		}
		
		return false;
	}

}
