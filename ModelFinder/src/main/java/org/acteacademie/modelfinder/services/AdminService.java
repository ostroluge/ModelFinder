package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Admin;

public interface AdminService {

	Collection<Admin> getAllAdmin();
	
	Admin findOne(Long id);
}