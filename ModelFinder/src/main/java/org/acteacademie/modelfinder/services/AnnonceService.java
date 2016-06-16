package org.acteacademie.modelfinder.services;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.Student;

public interface AnnonceService {

	Collection<Annonce> getAllAnnonce();
	
	Annonce getOneAnnonce(long id);

	void saveAnnonce(Annonce annonce);
	
	Collection<Annonce> findByStatus(String status);

	Collection<Annonce> findByStudent(Student student);
}