package com.huaDevelopers.controllers.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huaDevelopers.data.Services.Interfaces.DamFormService;
import com.huaDevelopers.data.Services.Interfaces.VehicleService;

@RestController
@RequestMapping("/rest/damage")
public class DamageRestController {
	
	@Autowired
	private DamFormService dmgService;

	@Autowired
	private VehicleService vService;

}
