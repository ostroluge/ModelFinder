package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Response;
import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.domain.customobject.ApplyForm;
import org.acteacademie.modelfinder.services.AnnonceService;
import org.acteacademie.modelfinder.services.ModelService;
import org.acteacademie.modelfinder.services.ReponseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReponseController {
	
	@Resource
	ReponseService reponseService;
	@Resource
	ModelService modelService;
	@Resource 
	AnnonceService annonceService;
	
	@CrossOrigin
	@RequestMapping("/reponseList")
	public Collection<Response> getAll(){
		return this.reponseService.getAllReponse();
	}
	
	@CrossOrigin
	@RequestMapping("/OneReponse/{id}")
	public Response getOne(@PathVariable("id") long id){
		return this.reponseService.getOneReponse(id);
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/apply", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse apply(@RequestBody ApplyForm applyForm) {
		StringResponse rep = new StringResponse("success");
		saveReponse(applyForm);
		return rep;
	}

	private void saveReponse(ApplyForm applyForm) {
		Response reponse = new Response();
		if (applyForm.getComment() != null && !applyForm.getComment().equals("")) {
			reponse.setComment(applyForm.getComment());
		}
		if (applyForm.getIdModel() != 0) {
			reponse.setModel(modelService.getOneModel(Long.valueOf(applyForm.getIdModel())));
		}
		if (applyForm.getIdAnnonce() != null && !applyForm.getIdAnnonce().equals("")) {
			reponse.setAnnonce(annonceService.getOneAnnonce(Long.valueOf(applyForm.getIdAnnonce())));
		}
		if (applyForm.getAccessory1() != null) {
			reponse.setStatusAccessory1(applyForm.getAccessory1());
		}
		if (applyForm.getAccessory2() != null) {
			reponse.setStatusAccessory2(applyForm.getAccessory2());
		}
		if (applyForm.getAccessory3() != null) {
			reponse.setStatusAccessory3(applyForm.getAccessory3());
		}
		if (applyForm.getAccessory4() != null) {
			reponse.setStatusAccessory4(applyForm.getAccessory4());
		}
		if (applyForm.getAccessory5() != null) {
			reponse.setStatusAccessory5(applyForm.getAccessory5());
		}
		reponse.setStatut("En attente");
		reponseService.saveReponse(reponse);
	}
	
	@CrossOrigin
	@RequestMapping(value="/modifyReponse", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse modifyReponse(@RequestBody Response reponse) {
		reponseService.saveReponse(reponse);
		return new StringResponse("success");
	}
	
	@CrossOrigin
	@RequestMapping(value = "/supprimerReponse", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse supprimerRv(@RequestBody Long id) {
		reponseService.deleteReponse(id);
		return new StringResponse("success");
	}

}

