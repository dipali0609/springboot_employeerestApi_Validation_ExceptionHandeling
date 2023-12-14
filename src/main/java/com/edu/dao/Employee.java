package com.edu.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int employeeeid;
	
   @NotBlank(message="Please Enter employee name")
   private String employeeename;
   
   @Min(value =5000,message = "Minimum salary should be 5000")
   @Max(10000)
   private float employeeesalary;
   
 public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int employeeeid, String employeeename, float employeeesalary) {
	super();
	this.employeeeid = employeeeid;
	this.employeeename = employeeename;
	this.employeeesalary = employeeesalary;
}
public int getEmployeeeid() {
	return employeeeid;
}
public void setEmployeeeid(int employeeeid) {
	this.employeeeid = employeeeid;
}
public String getEmployeeename() {
	return employeeename;
}
public void setEmployeeename(String employeeename) {
	this.employeeename = employeeename;
}
public float getEmployeeesalary() {
	return employeeesalary;
}
public void setEmployeeesalary(float employeeesalary) {
	this.employeeesalary = employeeesalary;
}
@Override
public String toString() {
	return "Employee [employeeeid=" + employeeeid + ", employeeename=" + employeeename + ", employeeesalary="
			+ employeeesalary + "]";
}
   
   
   
   
	
}
