package org.acteacademie.modelfinder.services.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.repositories.AnnonceRepository;
import org.acteacademie.modelfinder.services.AnnonceService;
import org.springframework.stereotype.Service;

@Service(value = "annonceService")
public class AnnonceServiceImpl implements AnnonceService{

	@Resource
	private AnnonceRepository annonceRepository;
			
	@Override
	public Collection<Annonce> getAllAnnonce() {
		return this.annonceRepository.findAll();
	}

	@Override
	public Annonce getOneAnnonce(long id) {
		return this.annonceRepository.findOne(id);
	}

	@Override
	public void saveAnnonce(Annonce annonce) {
		this.annonceRepository.save(annonce);
	}
}