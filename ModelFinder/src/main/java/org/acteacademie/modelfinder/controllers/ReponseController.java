package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.services.AnnonceService;
import org.acteacademie.modelfinder.services.ReponseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReponseController {
	
	@Resource
	ReponseService reponseService;
	AnnonceService annonceService;

	
	@CrossOrigin
	@RequestMapping("/reponseList")
	public Collection<Reponse> getAll(){
		return this.reponseService.getAllReponse();
	}
	
	@CrossOrigin
	@RequestMapping(value="/validerReponse", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse validerReponse(@RequestBody  Reponse reponse) {
		
		reponse.setStatut("Validée");
		this.reponseService.saveReponse(reponse);

		StringResponse response;
			response = new StringResponse("success");
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(value="/validerReponse2", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse validerReponse2(@RequestBody  long reponseId) {
		Reponse reponse = reponseService.getOneReponse(reponseId);
		reponse.setStatut("Validée");
		this.reponseService.saveReponse(reponse);

		StringResponse response;
			response = new StringResponse("success");
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(value="/refuserReponse", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse refuserReponse(@RequestBody  Reponse reponse) {
		
		reponse.setStatut("Refusée");
		this.reponseService.saveReponse(reponse);

		StringResponse response;
			response = new StringResponse("success");
		return response;
	}
}

