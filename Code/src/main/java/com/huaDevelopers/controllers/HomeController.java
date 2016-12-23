package com.huaDevelopers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value={"/admin/home","admin"})
	public String AdminHome(){
		return "admin_home";
	}
	
	@RequestMapping(value={"cms/home","cms"})
	public String cmsHome(){
		return "cms_home";
	}
	
	@RequestMapping(value={"/home","/"})
	public String home(){
		return "welcome";
	}
}
