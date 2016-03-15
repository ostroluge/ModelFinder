package org.acteacademie.modelfinder.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Admin;
import org.acteacademie.modelfinder.repositories.AdminRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@Resource
	AdminRepository adminRepository;
	
	@CrossOrigin
	@RequestMapping("/adminList")
	public List<Admin> getAll(){
		return this.adminRepository.findAll();
	}
	
	@CrossOrigin
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginSubmit() {
		return "Got it bro";
	}
}
