package org.acteacademie.modelfinder.controllers;

import javax.annotation.Resource;

import org.acteacademie.modelfinder.services.PhotoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
public class PhotoController {

    @Resource
    PhotoService photoService;



}