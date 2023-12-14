package com.edu.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Department
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
  private int departmentid;
	@NotBlank(message="Please Enter Department name")
  private String departmentname;
  
  
public Department() {
	super();
	// TODO Auto-generated constructor stub
}


public Department(int departmentid, String departmentname) {
	super();
	this.departmentid = departmentid;
	this.departmentname = departmentname;
}


public int getDepartmentid() {
	return departmentid;
}


public void setDepartmentid(int departmentid) {
	this.departmentid = departmentid;
}


public String getDepartmentname() {
	return departmentname;
}


public void setDepartmentname(String departmentname) {
	this.departmentname = departmentname;
}


@Override
public String toString() {
	return "Department [departmentid=" + departmentid + ", departmentname=" + departmentname + "]";
}




}
