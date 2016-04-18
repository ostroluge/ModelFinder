package org.acteacademie.modelfinder.controllers;

import java.util.Collection;
import javax.annotation.Resource;
import org.acteacademie.modelfinder.domain.Reponse;
import org.acteacademie.modelfinder.services.AnnonceService;
import org.acteacademie.modelfinder.services.ReponseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}

