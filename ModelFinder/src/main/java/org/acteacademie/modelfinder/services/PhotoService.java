package org.acteacademie.modelfinder.services;

import org.acteacademie.modelfinder.domain.Photo;

public interface PhotoService {

	// Retrieve file
    public Photo findById(int id);

    // Upload the file
    public static void uploadFile(Photo doc) {
		// TODO Auto-generated method stub
		
	}
}
