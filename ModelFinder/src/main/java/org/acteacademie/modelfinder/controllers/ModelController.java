package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.enums.EyeColorEnum;
import org.acteacademie.modelfinder.enums.LengthHairEnum;
import org.acteacademie.modelfinder.enums.SkinToneEnum;
import org.acteacademie.modelfinder.services.AnnonceService;
import org.acteacademie.modelfinder.services.ModelService;
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
	AnnonceService annonceService;
	
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
	@RequestMapping("/suggestionModel/{idAnnonce}")
	public Collection<Model> getByDetails(@PathVariable("idAnnonce") Long idAnnonce){
		
		Annonce annonce = this.annonceService.getOneAnnonce(idAnnonce);
		
		return this.modelService.getModelByDetails(annonce.getSkinTone(), annonce.getEyeColor(), annonce.getLengthHair(), annonce.getHeightMin(),annonce.getHeightMax());
	}

	@CrossOrigin
	@RequestMapping("/detailModel/{id}")
	public Model getOne(@PathVariable("id") long id){
		return this.modelService.findById(id);
	}
	
	@CrossOrigin
	@RequestMapping(value="/createModel", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse createModel(@RequestBody Model model) {
//	model.setPassword(Hashing.sha1().hashString(model.getPassword(), Charsets.UTF_8 ).toString());
		this.modelService.saveModel(model);
		return new StringResponse("success");
	}
}
