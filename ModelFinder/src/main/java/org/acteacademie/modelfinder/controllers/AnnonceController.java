package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.AnnonceAccessories;
import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.services.AccessoriesService;
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
	
	@Resource
	AccessoriesService accessoriesService;
	
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
	@RequestMapping("/detailAnnonce/{id}")
	public Annonce getDetail(@PathVariable("id") long id){
		return this.annonceService.getOneAnnonce(id);
	}
	
	@CrossOrigin
	@RequestMapping(value="/createAnnonce", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse createAnnonce(@RequestBody AnnonceAccessories annonceAccessories) {
		this.accessoriesService.saveAccessories(annonceAccessories.getAccessories());
		annonceAccessories.getAnnonce().setAccessories(annonceAccessories.getAccessories().getIdAccessories());
		annonceAccessories.getAnnonce().setIdStudent(1L);
		this.annonceService.saveAnnonce(annonceAccessories.getAnnonce());
		
		StringResponse response;
			response = new StringResponse("success");
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(value="/updateAnnonce", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse updateAnnonce(@RequestBody Annonce newAnnonce) {
		newAnnonce.setIdStudent(1L);
		newAnnonce.setAccessories(1L);
		Annonce oldAnnonce = this.annonceService.getOneAnnonce(newAnnonce.getId());
		this.updateFieldAnnonce(oldAnnonce, newAnnonce);
		this.annonceService.saveAnnonce(oldAnnonce);
		
		StringResponse response;
			response = new StringResponse("success");
		return response;
	}

	/**
	 * Mise à jour des champs de l'objet à update
	 * @param oldAnnonce
	 * @param newAnnonce
	 */
	private void updateFieldAnnonce(Annonce oldAnnonce, Annonce newAnnonce) {
		oldAnnonce.setCategoryService(newAnnonce.getCategoryService());
		if(newAnnonce.getComment() == null){
			oldAnnonce.setComment(newAnnonce.getComment());
		}
		oldAnnonce.setDateBegin(newAnnonce.getDateBegin());
		oldAnnonce.setDuration(newAnnonce.getDuration());
		oldAnnonce.setEyeColor(newAnnonce.getEyeColor());
		oldAnnonce.setHairColor(newAnnonce.getHairColor());
		oldAnnonce.setHeightMax(newAnnonce.getHeightMax());
		oldAnnonce.setLengthHair(newAnnonce.getLengthHair());
		oldAnnonce.setSkinTone(newAnnonce.getSkinTone());
		oldAnnonce.setThemeService(newAnnonce.getThemeService());
		oldAnnonce.setTitle(newAnnonce.getTitle());
	}
}
