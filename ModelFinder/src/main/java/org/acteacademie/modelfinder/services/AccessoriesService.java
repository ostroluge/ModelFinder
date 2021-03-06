package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Accessories;

public interface AccessoriesService {

	void saveAccessories(Accessories accessories);
	
	Accessories getOneAccessories(Long id);
	
	Collection<Accessories> getAllAccessories();

}
