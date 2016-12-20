package com.huaDevelopers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cms/damage")
public class DamageController {

	@RequestMapping(value="/declare", method=RequestMethod.GET)
	public String declareDamage() {
		return "dmg_declare";
	}
	
	@RequestMapping(value="/declare", method=RequestMethod.POST)
	public String saveDamage() {
		return "dmg_declare";
	}

}
