package com.edu.service;

import com.edu.dao.Department;
import com.edu.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public Department getDepartmentById(Integer departmentid) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Integer departmentid) throws DepartmentNotFoundException;

	public Department updateDepartmentById(Integer departmentid, Department department) throws DepartmentNotFoundException;

	
      
	

}
