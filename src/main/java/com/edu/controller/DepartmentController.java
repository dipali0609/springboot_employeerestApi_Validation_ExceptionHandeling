package com.edu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Department;
import com.edu.dao.Employee;
import com.edu.error.DepartmentNotFoundException;
import com.edu.service.DepartmentService;

@RestController
public class DepartmentController 
{
	
	@Autowired
  private DepartmentService departmentService;
	
//	@PostMapping("/saveDepartment")
//	public Department saveDepartment(@RequestBody Department department)
//	{
//		return departmentService.saveDepartment(department);
//		
//	}
 
//add for validation
	@PostMapping("/saveDepartment")
	public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department){
		Department dept=departmentService.saveDepartment(department);
		
		return new ResponseEntity<Department>(dept,HttpStatus.CREATED);	
	}
	
	@GetMapping("/getDepartmentById/{did}")
  public Department getDepartmentById(@PathVariable("did") Integer departmentid) throws DepartmentNotFoundException
  {
	return departmentService.getDepartmentById(departmentid);  
  }
	@DeleteMapping("/deleteDepartmentById/{did}")
	public String deleteDepartmentById(@PathVariable("did") Integer departmentid) throws DepartmentNotFoundException
	{
		departmentService.deleteDepartmentById(departmentid);
		return "Department deleted succesfully";
	}
 
	@PutMapping("/updateDepartmentById/{did}")
	public Department updateDepartmentById(@PathVariable("did") Integer departmentid, @RequestBody Department department) throws DepartmentNotFoundException
	{
		return departmentService.updateDepartmentById(departmentid,department);
		
	}
	
}
