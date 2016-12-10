package com.huaDevelopers.data.Services;

import java.util.List;

import com.huaDevelopers.data.Entities.Department;

public interface DepartmentService {

	public void addDept(Department dept);

	public void updateDeptInfo(Department dept);

	public void deleteDept(int id);

	public List<Department> getAllDepts();

	public Department getDeptByID(int id);
}
