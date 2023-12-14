package com.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Employee;
import com.edu.error.EmployeeNotFoundException;
import com.edu.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
   //inject object of repository
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public  Employee getEmployeeById(Integer employeeeid) throws EmployeeNotFoundException 
	{
		// TODO Auto-generated method stub
		Optional<Employee> emp=employeeRepository.findById(employeeeid);
		if(!emp.isPresent())
		{
			throw new EmployeeNotFoundException("EMployeeID="+employeeeid+"Not present");
		}
		else
		{
			return employeeRepository.findById(employeeeid).get();
		}
		
	}

	@Override
	public void deleteEmployeeById(Integer employeeeid) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> emp=employeeRepository.findById(employeeeid);
	 
	  if(!emp.isPresent())
		{
			throw new EmployeeNotFoundException("EMployeeID "+employeeeid+" is Not present");
		}
		else
		{
			employeeRepository.deleteById(employeeeid);
		}
		
	}

	@Override
	public Employee updateEmployeeById(Integer employeeeid, Employee employee) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> emp=employeeRepository.findById(employeeeid);
		if(!emp.isPresent())
		{
			throw new EmployeeNotFoundException("EMployeeID "+employeeeid+" is Not present");
		}
		else
		{
			Employee emp1=employeeRepository.findById(employeeeid).get();
			if(emp1!=null)
			{
				emp1.setEmployeeename(employee.getEmployeeename());
				emp1.setEmployeeesalary(employee.getEmployeeesalary());
				return employeeRepository.save(emp1);
			}
			return emp1;
		}
		
	}

	@Override
	public List<Employee> findByemployeeename(String employeeename) {
		// TODO Auto-generated method stub
		return employeeRepository.findByemployeeename(employeeename);
	}

}


///delete bill
//@Override
//public void deleteBill(int billId) throws GlobalException {
//  Optional<Bill>bob=billRepository.findById(billId);
//  if(!bob.isPresent()) {
//	  throw new GlobalException("Bill Not Found");
//  }else {
//	  billRepository.deleteById(billId);
//  }
//}
