package org.acteacademie.modelfinder.controllers;

import org.acteacademie.modelfinder.enums.CategoriesEnum;
import org.acteacademie.modelfinder.enums.EyeColorEnum;
import org.acteacademie.modelfinder.enums.LengthHairEnum;
import org.acteacademie.modelfinder.enums.PropositionStateEnum;
import org.acteacademie.modelfinder.enums.SkinToneEnum;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnumController {
	
	@CrossOrigin
	@RequestMapping(value = "/getCategoriesEnum", method = RequestMethod.GET)
	@ResponseBody
	public CategoriesEnum[] getCategoriesEnum(){
	     return CategoriesEnum.values();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getEyeColorEnum", method = RequestMethod.GET)
	@ResponseBody
	public EyeColorEnum[] getEyeColorEnum(){
	     return EyeColorEnum.values();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getLengthHairEnum", method = RequestMethod.GET)
	@ResponseBody
	public LengthHairEnum[] getLengthHairEnum(){
	     return LengthHairEnum.values();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getPropositionStateEnum", method = RequestMethod.GET)
	@ResponseBody
	public PropositionStateEnum[] getPropositionStateEnum(){
	     return PropositionStateEnum.values();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getSkinToneEnum", method = RequestMethod.GET)
	@ResponseBody
	public SkinToneEnum[] getSkinToneEnum(){
	     return SkinToneEnum.values();
	}
}
