package com.huaDevelopers.controllers.Rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huaDevelopers.data.Entities.Department;
import com.huaDevelopers.data.Services.Interfaces.DepartmentService;

@RestController
@RequestMapping("/rest/department")
public class DepartRestController {

	@Autowired
	private DepartmentService deptService;

	@GetMapping("/departments")
	public List<Department> getDepts() {	
		List<Department> deptlist = this.deptService.getAllDepts();
		
		return deptlist;
		 
		
	}
}
