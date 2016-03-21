package org.acteacademie.modelfinder.services.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Admin;
import org.acteacademie.modelfinder.repositories.AdminRepository;
import org.acteacademie.modelfinder.services.AdminService;
import org.springframework.stereotype.Service;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService{

	@Resource
	private AdminRepository adminRepository;
	
	@Override
	public Collection<Admin> getAllAdmin() {
		return this.adminRepository.findAll();
	}
}