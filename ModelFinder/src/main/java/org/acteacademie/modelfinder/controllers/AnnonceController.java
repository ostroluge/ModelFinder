package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.services.AnnonceService;
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
public class AnnonceController {

	@Resource
	AnnonceService annonceService;
	
	@CrossOrigin
	@RequestMapping("/annonceList")
	public Collection<Annonce> getAll(){
		return this.annonceService.getAllAnnonce();
	}
	
	@CrossOrigin
	@RequestMapping("/oneId/{id}")
	public Annonce getOne(@PathVariable("id") long id){
		return this.annonceService.getOneAnnonce(id);
	}
	
	@CrossOrigin
	@RequestMapping("/oneTitre/{id}")
	public String getOneTitle(@PathVariable("id") long id){
		return this.annonceService.getOneAnnonce(id).getTitle();
	}
	
	@CrossOrigin
	@RequestMapping("/detail_annonce/{id}")
	public Annonce getDetail(@PathVariable("id") long id){
		return this.annonceService.getOneAnnonce(id);
	}
	
	@CrossOrigin
	@RequestMapping(value="/createAnnonce", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse createAnnonce(@RequestBody Annonce annonce) {
		annonce.setIdStudent(1L);
		annonce.setAccessories(1L);
		
		this.annonceService.createAnnonce(annonce);
		
		StringResponse response;
			response = new StringResponse("success");
		return response;
	}
}
