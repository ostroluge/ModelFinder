package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.acteacademie.modelfinder.domain.Accessories;
import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.domain.StringResponseId;
import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.domain.customobject.AnnonceAccessories;
import org.acteacademie.modelfinder.services.AccessoriesService;
import org.acteacademie.modelfinder.services.AnnonceService;
import org.acteacademie.modelfinder.services.AuthorizationService;
import org.acteacademie.modelfinder.services.ResponseService;
import org.acteacademie.modelfinder.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("@authorizationService.isConnected(#session)")
public class AnnonceController {

	@Resource
	AnnonceService annonceService;
	
	@Resource
	AccessoriesService accessoriesService;
	
	@Resource
	StudentService studentService;
	
	@Resource
	AuthorizationService authorizationService;
	
	@Resource
	ResponseService responseService;

	
	@CrossOrigin
	@RequestMapping("/annonceList")
	public ResponseEntity<Collection<Annonce>> getAll(HttpSession session) {
		return ResponseEntity.ok(this.annonceService.getAllAnnonce());
	}
	
	@CrossOrigin
	@RequestMapping("/annonceListActives")
	public ResponseEntity<Collection<Annonce>> getAllActives(HttpSession session) {
		return ResponseEntity.ok(this.annonceService.findByStatus("Active"));
	}
	
	@CrossOrigin
	@RequestMapping("/annonceListInactives")
	public ResponseEntity<Collection<Annonce>> getAllInactives(HttpSession session) {
		return ResponseEntity.ok(this.annonceService.findByStatus("Inactive"));
	}
	
	@CrossOrigin
	@RequestMapping("/accessoireList")
	public Collection<Accessories> getAllAccessoire(HttpSession session){
		return this.accessoriesService.getAllAccessories();
	}
	
	@CrossOrigin
	@RequestMapping("/detailAnnonce/{id}")
	public AnnonceAccessories getDetail(@PathVariable("id") long id, HttpSession session){
		AnnonceAccessories annonceAccessories = new AnnonceAccessories();
		annonceAccessories.setAnnonce(this.annonceService.getOneAnnonce(id));
		annonceAccessories.setAccessories(this.accessoriesService.getOneAccessories(annonceAccessories.getAnnonce().getAccessoriesId()));
		
		return annonceAccessories;
	}
	
	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRole('student',#session)")
	@RequestMapping(value="/createAnnonce", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponseId createAnnonce(@RequestBody AnnonceAccessories annonceAccessories, HttpSession session) {
		this.accessoriesService.saveAccessories(annonceAccessories.getAccessories());
		annonceAccessories.getAnnonce().setAccessoriesId(annonceAccessories.getAccessories().getIdAccessories());
		User user = (User) session.getAttribute("USER");
		annonceAccessories.getAnnonce().setStudent(studentService.getOneStudent(user.getId()));
		this.annonceService.saveAnnonce(annonceAccessories.getAnnonce());
		return new StringResponseId("success", annonceAccessories.getAnnonce().getId());
	}
	
	@PreAuthorize("@authorizationService.hasRoleAndIsAuthorAnnonce('student', #newAnnonceAccessories.annonce.id,#session)")
	@CrossOrigin	
	@RequestMapping(value="/updateAnnonce", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse updateAnnonce(@RequestBody AnnonceAccessories newAnnonceAccessories, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		newAnnonceAccessories.getAnnonce().setStudent(studentService.getOneStudent(user.getId()));
		
		//Mise à jour des champs de l'annonce
		Annonce oldAnnonce = this.annonceService.getOneAnnonce(newAnnonceAccessories.getAnnonce().getId());
		this.updateFieldAnnonce(oldAnnonce, newAnnonceAccessories.getAnnonce());
		this.annonceService.saveAnnonce(oldAnnonce);

		//Mise à jour des champs des accessoires
		Accessories oldAccessories = this.accessoriesService.getOneAccessories(newAnnonceAccessories.getAccessories().getIdAccessories());
		this.updateFieldAccessories(oldAccessories, newAnnonceAccessories.getAccessories());
		this.accessoriesService.saveAccessories(oldAccessories);
		
		return new StringResponse("success");
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
		oldAnnonce.setStatus(newAnnonce.getStatus());
	}

	private void updateFieldAccessories(Accessories oldAccessories, Accessories newAccessories) {
		oldAccessories.setAccessory1(newAccessories.getAccessory1());
		oldAccessories.setAccessory2(newAccessories.getAccessory2());
		oldAccessories.setAccessory3(newAccessories.getAccessory3());
		oldAccessories.setAccessory4(newAccessories.getAccessory4());
		oldAccessories.setAccessory5(newAccessories.getAccessory5());
	}
}
