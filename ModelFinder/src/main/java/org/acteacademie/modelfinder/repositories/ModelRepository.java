package org.acteacademie.modelfinder.repositories;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.enums.EyeColorEnum;
import org.acteacademie.modelfinder.enums.LengthHairEnum;
import org.acteacademie.modelfinder.enums.SkinToneEnum;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<Model, Long>{
	
	Collection<Model> findAll();
	
	Model findOne(Long id);
	
	Collection<Model> findBySkinToneAndHairColorAndEyeColorAndLengthHairAndHeightBetween(SkinToneEnum skinTone,
			String hairColor, EyeColorEnum eyeColor, LengthHairEnum lengthHair, long height_min, long height_max);

	Model findById(long id);
}