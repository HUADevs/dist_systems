package com.huaDevelopers.data.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.DepartmentDAO;
import com.huaDevelopers.data.Entities.Department;

@Service
public class DeptServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDAO deptDAO;
	

	public void setDeptDAO(DepartmentDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

	@Override
	@Transactional
	public void addDept(Department dept) {
		this.deptDAO.addDept(dept);
	}

	@Override
	@Transactional
	public void updateDeptInfo(Department dept) {
		this.deptDAO.updateDeptInfo(dept);
	}

	@Override
	@Transactional
	public void deleteDept(int id) {
		this.deptDAO.deleteDept(id);
	}

	@Override
	@Transactional
	public List<Department> getAllDepts() {
		return this.deptDAO.getAllDepts();
	}

	@Override
	@Transactional
	public Department getDeptByID(int id) {
		return this.deptDAO.getDeptByID(id);
	}

}
