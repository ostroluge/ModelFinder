package org.acteacademie.modelfinder.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Admin;
import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.repositories.AdminRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping(value="/login", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse loginSubmit(@RequestBody Admin admin) {
		StringResponse response;
		if (isAuthorized(admin)) {
			response = new StringResponse("success");
		} else {
			response = new StringResponse("fail");
		}
		return response;
	}

	private boolean isAuthorized(Admin adminToCheck) {
		for (Admin admin : adminRepository.findAll()) {
			if (admin.getMail().equals(adminToCheck.getMail())) {
				return true;
			}
		}
		return false;
	}
}
