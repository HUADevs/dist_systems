package com.huaDevelopers.controllers.Rest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.huaDevelopers.data.Entities.DamageForm;
import com.huaDevelopers.data.Entities.Vehicle;
import com.huaDevelopers.data.Services.Interfaces.DamFormService;
import com.huaDevelopers.data.Services.Interfaces.VehicleService;

@RestController
@RequestMapping("/rest/damage")
public class DamageRestController {

	@Autowired
	private DamFormService dmgService;

	@Autowired
	private VehicleService vService;
	
	@GetMapping("/dform")
	public DamageForm CreateForm(){
		return new DamageForm();
	}
	
	@GetMapping("/viewAll/{id:\\d+}")
	public List<DamageForm> findVehicleDForms(@PathVariable("id") Long id) {
		return this.dmgService.listDamageFormsPerVehicle(id);
	}
	
	@GetMapping("/view/{id:\\d+}")
	public DamageForm findDamageForm(@PathVariable("id") int id) {
		return this.dmgService.getFormById(id);
	}
	
	@GetMapping(value = "/{id:\\d+}/imageDisplay")
	public void showImage(@PathVariable("id") int id, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		DamageForm dform = this.dmgService.getFormById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(dform.getDamagePhotoShoots());
		response.getOutputStream().close();
	}

	@PostMapping("/declare/{lp:[A-Z]{3}[0-9]{4}}")
	public String declareDamage(@RequestBody DamageForm dform, @PathVariable("lp") String lp
			) {

		dform.setDateAdded(LocalDate.now());
		Vehicle veh = this.vService.getVehicleByLP(lp);
		dform.setLicensePlate(this.vService.getVehicleByPID(veh.getId()));
		this.dmgService.addDamageForm(dform);
		return "Damage Form successfully added to database";
	}

}
