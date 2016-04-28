package org.acteacademie.modelfinder.services.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.repositories.ResponseRepository;
import org.acteacademie.modelfinder.services.ResponseService;
import org.acteacademie.modelfinder.domain.Response;
import org.springframework.stereotype.Service;

@Service(value = "ReponseService")
public class ReponseServiceImpl implements ResponseService{
		
	@Resource
	private ResponseRepository reponseRepository;
				
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
