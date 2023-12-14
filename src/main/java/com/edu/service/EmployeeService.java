package com.edu.service;

import java.util.List;

import com.edu.dao.Employee;
import com.edu.error.EmployeeNotFoundException;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public Employee getEmployeeById(Integer employeeeid) throws EmployeeNotFoundException;

	public void deleteEmployeeById(Integer employeeeid) throws EmployeeNotFoundException;

	public Employee updateEmployeeById(Integer employeeeid, Employee employee) throws EmployeeNotFoundException;

	public List<Employee> findByemployeeename(String employeeename);

	

	
}
