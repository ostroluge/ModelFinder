package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Admin;
import org.acteacademie.modelfinder.repositories.AdminRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@Resource
	AdminRepository adminRepository;
	
	@RequestMapping(value = "/admins", method = RequestMethod.GET)
	public Collection<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
	public Admin getAdminById(@PathVariable Long id) {
		return adminRepository.findOne(id);
	}
}
