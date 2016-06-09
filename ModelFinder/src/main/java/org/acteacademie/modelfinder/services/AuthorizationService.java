package org.acteacademie.modelfinder.services;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface AuthorizationService {

	public Boolean hasRole(String role, HttpSession session);
	
	public Boolean hasRoleAndIsAuthor(String role, Long idUser, HttpSession session);
	
	public Boolean hasAnyRole(String firstRole, String secondRole, HttpSession session);
}
