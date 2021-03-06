package org.acteacademie.modelfinder.services.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.domain.Response;
import org.acteacademie.modelfinder.domain.Student;
import org.acteacademie.modelfinder.repositories.ResponseRepository;
import org.acteacademie.modelfinder.services.ResponseService;
import org.springframework.stereotype.Service;

@Service(value = "ReponseService")
public class ReponseServiceImpl implements ResponseService{
		
	@Resource
	private ResponseRepository reponseRepository;

	@Override
	public Response getOneReponse(long id) {
		return this.reponseRepository.findOne(id);
	}
	
	@Override
	public void saveReponse(Response reponse) {
		this.reponseRepository.save(reponse);
	}
	
	public void deleteReponse(long id){
		this.reponseRepository.delete(id);
	}

	@Override
	public Collection<Response> findByAnnonceAndModel(Annonce annonce, Model model) {
		return this.reponseRepository.findByAnnonceAndModel(annonce, model);
	};
	
	public Collection<Response> findByAnnonce(Annonce annonce) {
		return this.reponseRepository.findByAnnonce(annonce);
	}

	@Override
	public Collection<Response> findByAnnonceAndStatut(Annonce annonce, String statut) {
		return reponseRepository.findByAnnonceAndStatut(annonce,statut);
	}

	@Override
	public Collection<Response> findByModel(Model model) {
		return reponseRepository.findByModel(model);
	}

	@Override
	public Collection<Response> getByStudent(Student student) {
		return reponseRepository.getByStudent(student.getId());
	}

	@Override
	public void deleteAllReponse(long id) {
		this.reponseRepository.deleteAllReponse(id);
	}
}
