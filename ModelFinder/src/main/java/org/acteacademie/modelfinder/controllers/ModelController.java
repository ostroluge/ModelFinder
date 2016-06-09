package org.acteacademie.modelfinder.controllers;

import java.util.Collection;
import javax.annotation.Resource;
import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.enums.EyeColorEnum;
import org.acteacademie.modelfinder.enums.LengthHairEnum;
import org.acteacademie.modelfinder.enums.SkinToneEnum;
import org.acteacademie.modelfinder.services.ModelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

@RestController
public class ModelController {

	@Resource
	ModelService modelService;
	
	@CrossOrigin
	@RequestMapping("/modelList")
	public Collection<Model> getAll(){
		return this.modelService.getAllModel();
	}
	
	@CrossOrigin
	@RequestMapping("/ModelById/{id}")
	public Model getOne(@PathVariable("id") Long id){
		return this.modelService.getOneModel(id);
	}
	
	@CrossOrigin
	@RequestMapping("/DeleteModel/{id}")
	public StringResponse deleteStudent(@PathVariable("id") Long id){
		this.modelService.deleteModel(id);
		return new StringResponse("success");
	}

	@CrossOrigin
	@RequestMapping("/suggestionModel/{skinTone}/{eyeColor}/{lengthHair}/{height_min}/{height_max}")
	public Collection<Model> getByDetails(@PathVariable("skinTone") String skinTone, @PathVariable("eyeColor") String eyeColor, @PathVariable("lengthHair") String lengthHair, @PathVariable("height_min") long height_min, @PathVariable("height_max") long height_max){
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
	
	@CrossOrigin
	@RequestMapping(value="/SaveModel", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse createModel(@RequestBody Model model) {
	model.setPassword(Hashing.sha1().hashString(model.getPassword(), Charsets.UTF_8 ).toString());
		this.modelService.saveModel(model);
		return new StringResponse("success");
	}
}
