package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Annonce;

public interface AnnonceService {

	Collection<Annonce> getAllAnnonce();
	
	Annonce getOneAnnonce(long id);

	void saveAnnonce(Annonce annonce);
}