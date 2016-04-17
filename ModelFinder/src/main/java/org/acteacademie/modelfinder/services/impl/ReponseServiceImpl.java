package org.acteacademie.modelfinder.services.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.repositories.ReponseRepository;
import org.acteacademie.modelfinder.services.ReponseService;
import org.acteacademie.modelfinder.domain.Reponse;
import org.springframework.stereotype.Service;

@Service(value = "ReponseService")
public class ReponseServiceImpl implements ReponseService{
		
	@Resource
	private ReponseRepository reponseRepository;
				
	@Override
	public Collection<Reponse> getAllReponse() {
		return this.reponseRepository.findAll();
	}

	@Override
	public Reponse getOneReponse(long id) {
		return this.reponseRepository.findOne(id);
	}
}
