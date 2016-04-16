package org.acteacademie.modelfinder.services.impl;

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
}
