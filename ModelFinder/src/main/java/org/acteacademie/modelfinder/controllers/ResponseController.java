package org.acteacademie.modelfinder.controllers;

import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.domain.Response;
import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.domain.Student;
import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.domain.customobject.ApplyForm;
import org.acteacademie.modelfinder.services.AnnonceService;
import org.acteacademie.modelfinder.services.AuthorizationService;
import org.acteacademie.modelfinder.services.ModelService;
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
public class ResponseController {
	
	@Resource 
	AuthorizationService authorizationService;
	
	@Resource
	ResponseService reponseService;
	
	@Resource
	ModelService modelService;

	@Resource
	StudentService studentService;

	@Resource 
	AnnonceService annonceService;
	
	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRole('model', #session)")
	@RequestMapping("/modelProposals")
	public ResponseEntity<Collection<Response>> getModelProposals(HttpSession session) {
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			if (user.getRole().equals("model")) {
				Model model = modelService.getOneModel(Long.valueOf(user.getId()));
				return ResponseEntity.ok(this.reponseService.findByModel(model));
			}
		}
		return ResponseEntity.status(422).body(null);
	}
	
	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRole('student', #session)")
	@RequestMapping("/studentServices")
	public ResponseEntity<Collection<Response>> getStudentServices(HttpSession session) {
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			if (user.getRole().equals("student")) {
				Student student = studentService.getOneStudent(Long.valueOf(user.getId()));
				return ResponseEntity.ok(this.reponseService.getByStudent(student));
			}
		}
		return ResponseEntity.status(422).body(null);
	}
	
	@CrossOrigin
	@RequestMapping("/detailReponse/{id}")
	public Response getOne(@PathVariable("id") long id){
		return this.reponseService.getOneReponse(id);
	}
	
	@CrossOrigin
	@RequestMapping("/ReponsesByAnnonce/{id_annonce}")
	@PreAuthorize("@authorizationService.hasRole('student', #session)")
	public Collection<Response> getResponsesByAnnonce(@PathVariable("id_annonce") long id, HttpSession session){
		return this.reponseService.findByAnnonce(annonceService.getOneAnnonce(id));
	}
	
	@CrossOrigin
	@RequestMapping("/ReponsesByAnnonceAndStatut/{id_annonce}/{statut}")
	@PreAuthorize("@authorizationService.hasRole('student', #session)")
	public Collection<Response> getResponsesByAnnonceAndStatut(@PathVariable("id_annonce") long id, @PathVariable("statut") String statut, HttpSession session){
		return this.reponseService.findByAnnonceAndStatut(annonceService.getOneAnnonce(id), statut);
	}
		
	
	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRole('model', #session)")
	@RequestMapping(value="/apply", method=RequestMethod.POST, produces = "application/json")
	public ResponseEntity<StringResponse> apply(@RequestBody ApplyForm applyForm, HttpSession session) {
		StringResponse rep = null;
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			if (user.getRole().equals("model")) {
				Model model = modelService.getOneModel(Long.valueOf(user.getId()));
				Annonce annonce = annonceService.getOneAnnonce(Long.valueOf(applyForm.getIdAnnonce()));
				rep = new StringResponse("En cours");
				if (!(reponseService.findByAnnonceAndModel(annonce, model)).isEmpty()){
					rep.setResponse("already apply");
				}
				else{
					Response reponse = new Response();
					if (applyForm.getComment() != null && !applyForm.getComment().equals("")) {
						reponse.setComment(applyForm.getComment());
					}
					if (user.getId() != 0) {
						reponse.setModel(model);
					}
					if (applyForm.getIdAnnonce() != null && !applyForm.getIdAnnonce().equals("")) {
						reponse.setAnnonce(annonce);
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
					rep.setResponse("success");
					
					return ResponseEntity.ok(rep);
				}
			}
		}
		return ResponseEntity.status(422).body(null);
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

