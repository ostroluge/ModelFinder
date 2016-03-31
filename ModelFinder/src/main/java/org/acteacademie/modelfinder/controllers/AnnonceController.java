package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.services.AnnonceService;
import org.hibernate.type.EnumType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.jboss.logging.Logger;

@RestController
public class AnnonceController {

	private static final Logger LOG = Logger.getLogger( EnumType.class.getName() );
	
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
}
