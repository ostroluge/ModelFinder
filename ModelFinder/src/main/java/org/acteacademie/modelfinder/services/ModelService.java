package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.enums.EyeColorEnum;
import org.acteacademie.modelfinder.enums.LengthHairEnum;
import org.acteacademie.modelfinder.enums.SkinToneEnum;

public interface ModelService {
	
	Collection<Model> getAllModel();
	
	Model getOneModel(Long id);

	void saveModel(Model model);
	
	Collection<Model> getModelByDetails(SkinToneEnum skinTone, EyeColorEnum eyeColor, LengthHairEnum lengthHair, long height_min, long height_max);

	Model findById(long id);
}
