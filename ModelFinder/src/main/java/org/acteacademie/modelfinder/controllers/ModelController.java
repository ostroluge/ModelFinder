package org.acteacademie.modelfinder.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.acteacademie.modelfinder.domain.Annonce;
import org.acteacademie.modelfinder.domain.Model;
import org.acteacademie.modelfinder.domain.Photo;
import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.domain.customobject.UserModel;
import org.acteacademie.modelfinder.services.AnnonceService;
import org.acteacademie.modelfinder.services.AuthorizationService;
import org.acteacademie.modelfinder.services.ModelService;
import org.acteacademie.modelfinder.services.PhotoService;
import org.acteacademie.modelfinder.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

@RestController
public class ModelController {

	@Resource
	AuthorizationService authorizationService;
	
	@Resource
	AnnonceService annonceService;
	
	@Resource
	ModelService modelService;
	
	@Resource
	UserService userService;
	
	@Resource
	PhotoService photoService;
	
	@CrossOrigin
	@RequestMapping("/modelList")
	@PreAuthorize("@authorizationService.hasAnyRole('student','admin',#session)")
	public Collection<Model> getAll(HttpSession session){
		return this.modelService.getAllModel();
	}
	
	public UserModel UserModelByModel(Model model){
		UserModel um = new UserModel();
		um.setUser(this.userService.getUserById(model.getId()));
		um.setModel(model);
		return um;
	}
	
	@CrossOrigin
	@RequestMapping("/usermodelList")
	@PreAuthorize("@authorizationService.hasAnyRole('student','admin',#session)")
	public Collection<UserModel> getAllUserModel(HttpSession session){
		Collection<UserModel> models = new ArrayList<UserModel>();
		for (Model model:this.modelService.getAllModel()){
			models.add(UserModelByModel(model));
		}
		return models;
	}
	
	@CrossOrigin
	@RequestMapping("/deleteModel/{id}")
	@PreAuthorize("@authorizationService.hasRoleOrIsAuthor('admin', #id, #session)")
	public StringResponse deleteModel(@PathVariable("id") Long id,HttpSession session){
		this.modelService.deleteModel(id);
		this.userService.deleteUser(id);
		return new StringResponse("success");
	}

	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRoleAndIsAuthorAnnonce('student', #idAnnonce,#session)")
	@RequestMapping("/suggestionModel/{idAnnonce}")
	public Collection<Model> getByDetails(@PathVariable("idAnnonce") Long idAnnonce, HttpSession session){
		
		Annonce annonce = this.annonceService.getOneAnnonce(idAnnonce);
		
		return this.modelService.getModelByDetails(annonce.getSkinTone(), annonce.getLengthHair(), annonce.getHeightMin(),annonce.getHeightMax());
	}

	@CrossOrigin
	@RequestMapping("/detailModel/{id}")
	@PreAuthorize("@authorizationService.hasAnyRoleOrIsIdModel('student','admin',#id, #session)")
	public UserModel getOne(@PathVariable("id") long id, HttpSession session){
		UserModel model = new UserModel();
		model.setUser(this.userService.getUserById(id));
		model.setModel(this.modelService.findById(id));
		System.out.println(model.getModel());
		return model;
	}
	
	@CrossOrigin
	@RequestMapping(value="/saveModel", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse createModel(@RequestBody UserModel usermodel) {
		User user = usermodel.getUser();
		Model model = usermodel.getModel();	
		Iterator<Photo> i = model.getModelPhoto().iterator();
		while(i.hasNext())
		{
			Photo p = this.photoService.savePhoto(i.next());
			System.out.println(p.getFile());
		}
		user.setPassword(Hashing.sha1().hashString(user.getPassword(), Charsets.UTF_8 ).toString());
		user = this.userService.saveUser(user);
		model.setId(user.getId());
		model = this.modelService.saveModel(model);

		return new StringResponse("success");
	}
	
	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRoleAndIsAuthor('model',#usermodel.user.id, #session)")
	@RequestMapping(value="/modifyModel", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse modifyModel(@RequestBody UserModel usermodel, HttpSession session) {
		User user = usermodel.getUser();
		Model model = usermodel.getModel();
		Iterator<Photo> i = model.getModelPhoto().iterator();
		while(i.hasNext())
		{
			Photo p = i.next();
			System.out.println(p.getId());
			if (p.getFile()==null)
			{
				System.out.println('b');
				this.photoService.deletePhoto(p.getId());
				model.getModelPhoto().remove(p);
			}else{
				p = this.photoService.savePhoto(p);
				System.out.println(p.getFile());
			}
		}
		user = this.userService.saveUser(user);
		System.out.println("c");
		this.modelService.saveModel(model);
		return new StringResponse("success");
	}
	
	@CrossOrigin
	@PreAuthorize("@authorizationService.hasRoleAndIsAuthor('model',#usermodel.user.id, #session)")
	@RequestMapping(value="/modifyModelAndPassword", method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody StringResponse modifyModelAndPassword(@RequestBody UserModel usermodel) {
		User user = usermodel.getUser();
		Model model = usermodel.getModel();
		user.setPassword(Hashing.sha1().hashString(user.getPassword(), Charsets.UTF_8 ).toString());
		user = this.userService.saveUser(user);
		this.modelService.saveModel(model);
		return new StringResponse("success");
	}
}
