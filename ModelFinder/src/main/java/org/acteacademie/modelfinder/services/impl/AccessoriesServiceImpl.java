package org.acteacademie.modelfinder.services.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Accessories;
import org.acteacademie.modelfinder.repositories.AccessoriesRepository;
import org.acteacademie.modelfinder.services.AccessoriesService;
import org.springframework.stereotype.Service;

@Service(value = "accessoriesService")
public class AccessoriesServiceImpl implements AccessoriesService{

	@Resource
	private AccessoriesRepository accessoriesRepository;
			
	@Override
	public void saveAccessories(Accessories accessories) {
		this.accessoriesRepository.save(accessories);
	}

	@Override
	public Accessories getOneAccessories(Long id) {
		return this.accessoriesRepository.findOne(id);
	}

	@Override
	public Collection<Accessories> getAllAccessories() {
		return this.accessoriesRepository.findAll(); 
	}
	
	
}
