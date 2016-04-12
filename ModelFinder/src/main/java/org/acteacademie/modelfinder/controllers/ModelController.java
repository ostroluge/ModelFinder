package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Model;
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

}
