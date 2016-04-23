package org.acteacademie.modelfinder.services.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.repositories.ReponseRepository;
import org.acteacademie.modelfinder.services.ReponseService;
import org.acteacademie.modelfinder.domain.Response;
import org.springframework.stereotype.Service;

@Service(value = "ReponseService")
public class ReponseServiceImpl implements ReponseService{
		
	@Resource
	private ReponseRepository reponseRepository;
				
	@Override
	public Collection<Response> getAllReponse() {
		return this.reponseRepository.findAll();
	}

	@Override
	public Response getOneReponse(long id) {
		return this.reponseRepository.findOne(id);
	}
	
	@Override
	public void saveReponse(Response reponse) {
		this.reponseRepository.save(reponse);
	}
}
