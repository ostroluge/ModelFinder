package org.acteacademie.modelfinder.controllers;

import java.util.Collection;
import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Admin;
import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.services.AnnonceService;
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
}
