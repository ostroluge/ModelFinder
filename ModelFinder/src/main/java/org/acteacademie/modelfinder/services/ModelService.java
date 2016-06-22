package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.enums.LengthHairEnum;
import org.acteacademie.modelfinder.enums.SkinToneEnum;

public interface ModelService {
	
	Collection<Model> getAllModel();
	
	Model getOneModel(Long id);

	Model saveModel(Model model);
	
	Collection<Model> getModelByDetails(SkinToneEnum skinTone, LengthHairEnum lengthHair, long height_min, long height_max);

	Model findById(long id);
	
	void deleteModel(Long id);
}
