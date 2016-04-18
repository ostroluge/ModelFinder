package org.acteacademie.modelfinder.controllers;

import java.util.Collection;
import javax.annotation.Resource;
import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.services.ModelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
