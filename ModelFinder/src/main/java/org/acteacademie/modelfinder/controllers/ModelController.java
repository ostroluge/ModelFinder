package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.enums.EyeColorEnum;
import org.acteacademie.modelfinder.enums.LengthHairEnum;
import org.acteacademie.modelfinder.enums.SkinToneEnum;
import org.acteacademie.modelfinder.services.ModelService;
import org.hibernate.type.EnumType;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {

	@Resource
	ModelService modelService;
	
	@CrossOrigin
	@RequestMapping("/modelList")
	public Collection<Model> getAll(){
		System.out.println("aaaa");
		return this.modelService.getAllModel();
	}
	
	@CrossOrigin
	@RequestMapping("/suggestionModel/{skinTone}/{eyeColor}/{lengthHair}/{height_min}/{height_max}")
	public Collection<Model> getByDetails(@PathVariable("skinTone") String skinTone, @PathVariable("eyeColor") String eyeColor, @PathVariable("lengthHair") String lengthHair, @PathVariable("height_min") long height_min, @PathVariable("height_max") long height_max){
		System.out.println("bbbb");
		SkinToneEnum skinToneB = SkinToneEnum.fromValue(skinTone);
		EyeColorEnum eyeColorB = EyeColorEnum.fromValue(eyeColor);
		LengthHairEnum lengthHairB = LengthHairEnum.fromValue(lengthHair);
		return this.modelService.getModelByDetails(skinToneB, eyeColorB, lengthHairB, height_min, height_max);
	}

	@CrossOrigin
	@RequestMapping("/detailModel/{id}")
	public Model getOne(@PathVariable("id") long id){
		return this.modelService.findById(id);
	}
}
