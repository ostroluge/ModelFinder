package org.acteacademie.modelfinder.controllers;

import java.util.Collection;
import javax.annotation.Resource;
import org.acteacademie.modelfinder.domain.Reponse;
import org.acteacademie.modelfinder.services.ReponseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReponseController {
	
	@Resource
	ReponseService reponseService;
	
	@CrossOrigin
	@RequestMapping("/reponseList")
	public Collection<Reponse> getAll(){
		return this.reponseService.getAllReponse();
	}
	
	@CrossOrigin
	@RequestMapping("/reponseInfo")
	public String getInfos(){
		String rep = "[";
		for (Reponse reponse : this.reponseService.getAllReponse()){
			rep = rep + "{id:" + reponse.getId() + ",idAnnonce:" + reponse.getIdAnnonce() + ",idModel:" + reponse.getIdModel() + ",StatusAccessory1:"
					+ reponse.getStatusAccessory1() + ",StatusAccessory2:" + reponse.getStatusAccessory2() + ",StatusAccessory3:"
					+ reponse.getStatusAccessory3() + ",StatusAccessory4:" + reponse.getStatusAccessory4() + ",StatusAccessory5:"
					+ reponse.getStatusAccessory5() + ",Statut:" + reponse.getStatut() + ",Comment:" + reponse.getComment() + ",title:" 
					+ new AnnonceController().getOne(reponse.getIdAnnonce()).getTitle() + ",ModelLastName:" 
					+ new ModelController().getOne(reponse.getIdModel()).getLastName() + ",Modelname:" 
					+ new ModelController().getOne(reponse.getIdModel()).getName() + ",idStudent:" 
					+ new AnnonceController().getOne(reponse.getIdAnnonce()).getIdStudent() + ",StudentLastName:" 
					+ new StudentController().getOne(new AnnonceController().getOne(reponse.getIdAnnonce()).getIdStudent()).getLastName() + ",StudentName:" 
					+ new StudentController().getOne(new AnnonceController().getOne(reponse.getIdAnnonce()).getIdStudent()).getFirstName() +"}";
		}
		return rep+"]";
	}
	
}

