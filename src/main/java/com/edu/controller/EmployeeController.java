package com.edu.controller;

import java.util.List;

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

import com.edu.dao.Employee;
import com.edu.error.EmployeeNotFoundException;
import com.edu.service.EmployeeService;

@RestController
public class EmployeeController 
{
	//inject an object EmployeeService interface
	@Autowired
   private EmployeeService employeeService;
	
	//save the record, insert into employee values
//   @PostMapping("/saveEmployee")//http://localhost:8889/saveEmployee
//   public Employee saveEmployee(@RequestBody Employee employee)
//   {
//	 return employeeService.saveEmployee(employee);
//	
//   }
	
	@PostMapping("/saveemployee")
	public ResponseEntity<Employee>saveEmployee(@Valid @RequestBody Employee employee){
		Employee emp=employeeService.saveEmployee(employee);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);	
	}
   
   @GetMapping("/getEmployeeById/{eid}")
   public Employee getEmployeeById(@PathVariable("eid") Integer employeeeid ) throws EmployeeNotFoundException
   {
	  return employeeService.getEmployeeById(employeeeid);
   }
   
   @DeleteMapping("/deleteEmployeeById/{eid}")
   public String deleteEmployeeById(@PathVariable("eid") Integer employeeeid ) throws EmployeeNotFoundException
   {
	   employeeService.deleteEmployeeById(employeeeid); 
	   return "Employee delete";
   }
   
   @PutMapping("/updateEmployeeById/{eid}")
   public Employee updateEmployeeById(@PathVariable("eid") Integer employeeeid,@RequestBody Employee employee) throws EmployeeNotFoundException
   {
	return employeeService.updateEmployeeById(employeeeid,employee);
	   
   }
   
   @GetMapping("/findByemployeeename/{ename}")
	public List<Employee> findByemployeeename(@PathVariable("ename") String employeeename) {
		return employeeService.findByemployeeename(employeeename);
	}
}
