package org.acteacademie.modelfinder.services.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.services.AuthorizationService;
import org.springframework.stereotype.Component;

@Component("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService{

	@Override
	public Boolean hasRole(String role, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		
		if(user.getRole().equals(role) && user.getIsValidated()){
			return true;
		}
		
		return false;
	}

	public Boolean hasRoleAndIsAuthor(String role, Long idUser, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		
		if(user.getRole().equals(role) && user.getIsValidated() && user.getId() == idUser){
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean hasAnyRole(String firstRole, String secondRole, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		
		if((user.getRole().equals(firstRole) || user.getRole().equals(secondRole)) && user.getIsValidated()){
			return true;
		}
		
		return false;
	}

}
