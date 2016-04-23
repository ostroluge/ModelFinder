package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Admin;
import org.acteacademie.modelfinder.services.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@CrossOrigin
	@RequestMapping(value="/login", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody String loginSubmit(@RequestBody Admin admin) {
		String response;
		if (isAuthorized(admin)) {
			response = new String("success");
		} else {
			response = new String("fail");
		}
		return response;
	}

	private boolean isAuthorized(Admin adminToCheck) {
		for (Admin admin : adminService.getAllAdmin()) {
			if (admin.getMail().equals(adminToCheck.getMail())) {
				return true;
			}
		}
		return false;
	}
}
