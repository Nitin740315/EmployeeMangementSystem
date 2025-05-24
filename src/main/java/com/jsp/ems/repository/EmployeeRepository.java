package com.jsp.ems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	//save()
	//findbyid()
	//findAll()
	//delete()
	//deleteAll()
	
	List<Employee> findByTitle(String title);
	Optional<Employee> findByEmail(String email);
	List<Employee> findBySalaryGreaterThan(int salary);
	List<Employee> findBySalaryLessThan(int salary);
	
	//deleteby
	List<Employee> deleteByTitle(String title);
	
	
}
