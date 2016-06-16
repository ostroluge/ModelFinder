package org.acteacademie.modelfinder.services.impl;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.Photo;
import org.acteacademie.modelfinder.repositories.PhotoRepository;
import org.acteacademie.modelfinder.services.PhotoService;
import org.springframework.stereotype.Service;

@Service(value = "photoService")
public class PhotoServiceImpl implements PhotoService {

	@Resource
	private PhotoRepository photoRepository;
	
	// Retrieve file
    public Photo findById(int id) {
        return photoRepository.findPhotoById(id);
    }

    // Upload the file
    public void uploadFile(Photo doc) {
        photoRepository.save(doc);
    }

}
