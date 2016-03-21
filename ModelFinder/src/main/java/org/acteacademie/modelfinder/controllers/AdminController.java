package org.acteacademie.modelfinder.controllers;

import java.util.Collection;
import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Admin;
<<<<<<< HEAD
import org.acteacademie.modelfinder.services.AdminService;
=======
import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.repositories.AdminRepository;
>>>>>>> refs/remotes/origin/master
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
