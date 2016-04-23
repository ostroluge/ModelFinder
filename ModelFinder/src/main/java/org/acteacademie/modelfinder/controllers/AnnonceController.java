package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Accessories;
import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.customobject.AnnonceAccessories;
import org.acteacademie.modelfinder.services.AccessoriesService;
import org.acteacademie.modelfinder.services.AnnonceService;
import org.acteacademie.modelfinder.services.StudentService;
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
	
	@Resource
	StudentService studentService;
	
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
	public AnnonceAccessories getDetail(@PathVariable("id") long id){
		AnnonceAccessories annonceAccessories = new AnnonceAccessories();
		annonceAccessories.setAnnonce(this.annonceService.getOneAnnonce(id));
		annonceAccessories.setAccessories(this.accessoriesService.getOneAccessories(annonceAccessories.getAnnonce().getAccessories()));
		
		return annonceAccessories;
	}
	
	@CrossOrigin
	@RequestMapping(value="/createAnnonce", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody String createAnnonce(@RequestBody AnnonceAccessories annonceAccessories) {
		this.accessoriesService.saveAccessories(annonceAccessories.getAccessories());
		annonceAccessories.getAnnonce().setAccessories(annonceAccessories.getAccessories().getIdAccessories());
		annonceAccessories.getAnnonce().setStudent(studentService.getOneStudent(1L));
		this.annonceService.saveAnnonce(annonceAccessories.getAnnonce());
		
			
		return "success";
	}
	
	@CrossOrigin
	@RequestMapping(value="/updateAnnonce", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody String supdateAnnonce(@RequestBody AnnonceAccessories newAnnonceAccessories) {
		newAnnonceAccessories.getAnnonce().setStudent(studentService.getOneStudent(1L));
		
		//Mise à jour des champs de l'annonce
		Annonce oldAnnonce = this.annonceService.getOneAnnonce(newAnnonceAccessories.getAnnonce().getId());
		this.updateFieldAnnonce(oldAnnonce, newAnnonceAccessories.getAnnonce());
		this.annonceService.saveAnnonce(oldAnnonce);

		//Mise à jour des champs des accessoires
		Accessories oldAccessories = this.accessoriesService.getOneAccessories(newAnnonceAccessories.getAccessories().getIdAccessories());
		this.updateFieldAccessories(oldAccessories, newAnnonceAccessories.getAccessories());
		this.accessoriesService.saveAccessories(oldAccessories);
		
		return "success";
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
		oldAnnonce.setDateEnd(newAnnonce.getDateEnd());
		oldAnnonce.setEyeColor(newAnnonce.getEyeColor());
		oldAnnonce.setHairColor(newAnnonce.getHairColor());
		oldAnnonce.setHeightMax(newAnnonce.getHeightMax());
		oldAnnonce.setLengthHair(newAnnonce.getLengthHair());
		oldAnnonce.setSkinTone(newAnnonce.getSkinTone());
		oldAnnonce.setThemeService(newAnnonce.getThemeService());
		oldAnnonce.setTitle(newAnnonce.getTitle());
	}

	private void updateFieldAccessories(Accessories oldAccessories, Accessories newAccessories) {
		oldAccessories.setAccessory1(newAccessories.getAccessory1());
		oldAccessories.setAccessory2(newAccessories.getAccessory2());
		oldAccessories.setAccessory3(newAccessories.getAccessory3());
		oldAccessories.setAccessory4(newAccessories.getAccessory4());
		oldAccessories.setAccessory5(newAccessories.getAccessory5());
	}
}
