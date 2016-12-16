package com.huaDevelopers.dao.Interfaces;

import java.util.List;

import com.huaDevelopers.data.Entities.Department;

public interface DepartmentDAO {

	public void addDept(Department dept);

	public void updateDeptInfo(Department dept);

	public void deleteDept(int id);

	public List<Department> getAllDepts();

	public Department getDeptByID(int id);
}
