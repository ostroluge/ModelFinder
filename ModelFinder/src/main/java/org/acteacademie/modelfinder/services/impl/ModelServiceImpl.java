package org.acteacademie.modelfinder.services.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.enums.LengthHairEnum;
import org.acteacademie.modelfinder.enums.SkinToneEnum;
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
	public Model saveModel(Model model) {
		return this.modelRepository.save(model);
	}

	@Override
	public Collection<Model> getModelByDetails(SkinToneEnum skinTone, LengthHairEnum lengthHair, long height_min, long height_max) {
		return this.modelRepository.findBySkinToneAndLengthHairAndHeightBetween(skinTone, lengthHair, height_min, height_max);
	}

	@Override
	public Model findById(long id) {
		return this.modelRepository.findById(id);
	}

	@Override
	public void deleteModel(Long id) {
		this.modelRepository.delete(id);
	}
	
	
	
}