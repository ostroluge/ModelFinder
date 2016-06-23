package org.acteacademie.modelfinder.services;

import javax.servlet.http.HttpSession;

public interface AuthorizationService {

	public Boolean hasRole(String role, HttpSession session);
	
	public Boolean hasRoleAndIsAuthor(String role, Long idUser, HttpSession session);
	
	public Boolean hasRoleOrIsAuthor(String role, Long idUser, HttpSession session);

	public Boolean hasAnyRole(String firstRole, String secondRole, HttpSession session);
	
	public Boolean hasRoleAndIsAuthorAnnonce(String role, Long idAnnonce, HttpSession session);
	
	public Boolean isConnected(HttpSession session);
	
	public Boolean hasAnyRoleOrIsIdModel(String firstRole, String secondRole, Long idModel, HttpSession session);
}
