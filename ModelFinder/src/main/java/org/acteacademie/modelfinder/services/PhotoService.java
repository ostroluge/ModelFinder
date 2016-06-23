package org.acteacademie.modelfinder.services;

import org.acteacademie.modelfinder.domain.Photo;

public interface PhotoService {
    
    Photo savePhoto(Photo photo);
    
    void deletePhoto(Long id);
}
