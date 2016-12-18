package com.huaDevelopers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value="/admin/home")
	public String AdminHome(){
		return "admin_home";
	}
	
	@RequestMapping(value="cms/home")
	public String cmsHome(){
		return "cms_home";
	}
}
