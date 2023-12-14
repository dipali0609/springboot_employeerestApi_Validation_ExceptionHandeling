package com.edu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.edu.dao.Department;
import com.edu.error.DepartmentNotFoundException;
import com.edu.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
	@Autowired
    private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartmentById(Integer departmentid) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Department> dept=departmentRepository.findById(departmentid);
		if(!dept.isPresent())
		{
			throw new DepartmentNotFoundException("Department Id "+departmentid+" is not present");
		}
		else
		{
		return departmentRepository.findById(departmentid).get();
		}
	}

	@Override
	public void deleteDepartmentById(Integer departmentid) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Department> dept=departmentRepository.findById(departmentid);
		if(dept.isPresent())
		{
		     departmentRepository.deleteById(departmentid);
		}
		else
		{
			throw new DepartmentNotFoundException("Department Id "+departmentid+" is not present");
		}
		
	}

	@Override
	public Department updateDepartmentById(Integer departmentid, Department department) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> dept1=departmentRepository.findById(departmentid);
		if(!dept1.isPresent())
		{
			throw new DepartmentNotFoundException("Department Id "+departmentid+" is not present");
		}
		else
		{
		Department dept=departmentRepository.findById(departmentid).get();
		if(dept!=null)
		{
			dept.setDepartmentname(department.getDepartmentname());
			return departmentRepository.save(dept);
		}
		
		return dept;
		}
		
	}
	
	
}
