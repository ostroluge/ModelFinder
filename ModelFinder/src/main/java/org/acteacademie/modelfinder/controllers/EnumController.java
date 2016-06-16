package org.acteacademie.modelfinder.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.acteacademie.modelfinder.enums.CategoriesEnum;
import org.acteacademie.modelfinder.enums.EyeColorEnum;
import org.acteacademie.modelfinder.enums.LengthHairEnum;
import org.acteacademie.modelfinder.enums.PropositionStateEnum;
import org.acteacademie.modelfinder.enums.SkinToneEnum;
import org.acteacademie.modelfinder.services.AuthorizationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("@authorizationService.isConnected(#session)")
public class EnumController {
	
	@Resource
	AuthorizationService authorizationService;
	
	@CrossOrigin
	@RequestMapping(value = "/getCategoriesEnum", method = RequestMethod.GET)
	@ResponseBody
	public CategoriesEnum[] getCategoriesEnum(HttpSession session){
	     return CategoriesEnum.values();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getEyeColorEnum", method = RequestMethod.GET)
	@ResponseBody
	public EyeColorEnum[] getEyeColorEnum(HttpSession session){
	     return EyeColorEnum.values();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getLengthHairEnum", method = RequestMethod.GET)
	@ResponseBody
	public LengthHairEnum[] getLengthHairEnum(HttpSession session){
	     return LengthHairEnum.values();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getPropositionStateEnum", method = RequestMethod.GET)
	@ResponseBody
	public PropositionStateEnum[] getPropositionStateEnum(HttpSession session){
	     return PropositionStateEnum.values();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getSkinToneEnum", method = RequestMethod.GET)
	@ResponseBody
	public SkinToneEnum[] getSkinToneEnum(HttpSession session){
	     return SkinToneEnum.values();
	}
}
