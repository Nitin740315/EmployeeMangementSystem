package com.jsp.ems.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ems.entity.Employee;
import com.jsp.ems.exception.EmployeeSalaryAreNotFound;
import com.jsp.ems.exception.NoEmplyeeNotFoundException;
import com.jsp.ems.repository.EmployeeRepository;
import com.jsp.ems.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee Add(Employee employee) {
		return employeeRepository.save(employee);

	}

	public List<Employee> findAll() {
		List<Employee> employees = employeeRepository.findAll();
		if (employees.isEmpty()) {
			return null;
		} else {
			return employees;
		}
	}

	public Employee findbyId(int id) {

		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isEmpty()) {
			throw new NoEmplyeeNotFoundException("Employee Not found this id");
		} else {
			Employee employee = optional.get();
			return employee;
		}
	}

	public Employee deleteById(int id) {

		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isEmpty()) {
			throw new NoEmplyeeNotFoundException("Employee Not found this id");
		} else {
			Employee employee = optional.get();
			employeeRepository.delete(employee);
			return employee;
		}

	}

	public Employee updateById(int id, Employee updateemp) {

		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isEmpty()) {
			throw new NoEmplyeeNotFoundException("Employee Not found this id");
		} else {
			Employee employee = optional.get();
			updateemp.setId(employee.getId());
			employeeRepository.save(updateemp);
			return updateemp;
		}
	}

	@Override
	public List<Employee> findByTitle(String title) {

		List<Employee> i = employeeRepository.findByTitle(title);
		if (i.isEmpty()) {
			throw new NoEmplyeeNotFoundException("Employee Not found this id");
		} else {

			return i;
		}

	}

	@Override
	public List<Employee> findBySalaryGreaterThan(int salary) {
		List<Employee> employees=employeeRepository.findBySalaryGreaterThan(salary);
		if(employees.isEmpty())
		{
			throw new EmployeeSalaryAreNotFound("Not found");
			
		}
		else
			return employees;
	}

}
