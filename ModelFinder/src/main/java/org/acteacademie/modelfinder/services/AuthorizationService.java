package org.acteacademie.modelfinder.services;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

public interface AuthorizationService {

	public Boolean hasRole(String role, HttpSession session);
}
