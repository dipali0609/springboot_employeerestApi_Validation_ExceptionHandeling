package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.dao.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> 
{

	public List<Employee> findByemployeeename(String employeeename);
//to use deleteById,findById, save to use that method we create the repository
}
