package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Admin;
import org.acteacademie.modelfinder.services.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@Resource
	AdminService adminService;
	
	@CrossOrigin
	@RequestMapping("/adminList")
	public Collection<Admin> getAll(){
		return this.adminService.getAllAdmin();
	}
}
