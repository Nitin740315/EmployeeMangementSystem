package com.jsp.ems.service;

import java.util.List;

import com.jsp.ems.entity.Employee;

public interface EmployeeService {

	Employee Add(Employee employee);
	
	 List<Employee> findAll();
	 Employee deleteById(int id) ;
	 Employee findbyId(int id);
	 List<Employee> findByTitle(String title);
	 Employee updateById(int id,Employee  updateemp);
	 List<Employee> findBySalaryGreaterThan(int salary);
	 
	 
}
