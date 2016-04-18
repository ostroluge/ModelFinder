package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Model;

public interface ModelService {
	
	Collection<Model> getAllModel();
	
	Model getOneModel(Long id);

	void saveModel(Model model);
}
