package com.example.demo.services;

import java.util.List;

import com.example.demo.module.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee e);
	
	Employee getById(Integer eid);
	
	List<Employee> getByDesignation(String designation);
	
	List<Employee> getByLessSal(Double sal);
	
	Employee updateEmployee(Employee e);
	

}
