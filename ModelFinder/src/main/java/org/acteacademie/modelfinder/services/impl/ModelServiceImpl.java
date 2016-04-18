package org.acteacademie.modelfinder.services.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.repositories.ModelRepository;
import org.acteacademie.modelfinder.services.ModelService;
import org.springframework.stereotype.Service;

@Service(value = "modelService")
public class ModelServiceImpl implements ModelService{

	@Resource
	private ModelRepository modelRepository;
			
	@Override
	public Collection<Model> getAllModel() {
		return this.modelRepository.findAll();
	}

	@Override
	public Model getOneModel(Long id) {
		return this.modelRepository.findOne(id);
	}

	@Override
	public void saveModel(Model model) {
		// TODO Auto-generated method stub
		
	}
}