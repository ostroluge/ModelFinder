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

	@Override
	public Photo savePhoto(Photo photo) {
		// TODO Auto-generated method stub
		return photoRepository.save(photo);
	}

	@Override
	public void deletePhoto(Long id) {
		// TODO Auto-generated method stub
		photoRepository.delete(id);
	}

}
