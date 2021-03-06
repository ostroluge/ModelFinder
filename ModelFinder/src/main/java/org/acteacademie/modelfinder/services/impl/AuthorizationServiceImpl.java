package org.acteacademie.modelfinder.services.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.services.AnnonceService;
import org.acteacademie.modelfinder.services.AuthorizationService;
import org.acteacademie.modelfinder.services.ResponseService;
import org.springframework.stereotype.Component;

@Component("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService{

	@Resource
	AnnonceService annonceService;
	
	@Resource
	ResponseService responseService;
	
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


	public Boolean hasRoleOrIsAuthor(String role, Long idUser, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		
		if((user.getRole().equals(role) ||  user.getId() == idUser) && user.getIsValidated()){
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

	public Boolean hasRoleAndIsAuthorAnnonce(String role, Long idAnnonce, HttpSession session){
		Annonce annonce = this.annonceService.getOneAnnonce(idAnnonce);
		User user = (User) session.getAttribute("USER");

		if(user.getRole().equals(role) && user.getIsValidated() && (annonce.getStudent().getId() == user.getId())){
			return true;
		}
		
		return false;
	}


	public Boolean hasAnyRoleOrIsIdModel(String firstRole, String secondRole, Long idModel, HttpSession session){
		User user = (User) session.getAttribute("USER");

		if((user.getRole().equals(firstRole) || user.getRole().equals(secondRole) || (user.getId() == idModel)) && user.getIsValidated()){
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean hasRoleOrIsAuthorReponse(String role, Long idReponse, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		
		Long idModel = responseService.getOneReponse(idReponse).getModel().getId();
		
		if((user.getRole().equals(role) || user.getId() == idModel) && user.getIsValidated()){
			return true;
		}
		
		return false;
	}
	
	@Override
	public Boolean hasRoleAndIsAuthorReponse(String role, Long idReponse, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		
		Long idModel = responseService.getOneReponse(idReponse).getModel().getId();
		
		if((user.getRole().equals(role) && user.getId() == idModel && user.getIsValidated())){
			return true;
		}
		
		return false;
	}
	
	@Override
	public Boolean isConnected(HttpSession session) {
		if(session.getAttribute("USER") == null){
			return false;
		}
		return true;
	}
}
