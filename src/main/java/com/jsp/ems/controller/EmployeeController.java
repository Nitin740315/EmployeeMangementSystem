package com.jsp.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.jsp.ems.entity.Employee;
import com.jsp.ems.service.EmployeeService;
import com.jsp.ems.serviceimpl.EmployeeServiceImp;
import com.jsp.ems.utility.ResponseStructure;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImp employeeService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Employee>> add(@RequestBody Employee employee) {
		Employee employee2 = employeeService.Add(employee);

		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setId(HttpStatus.CREATED.value());
		responseStructure.setMsg("Empolyee  add susffully");
		responseStructure.setData(employee2);

		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Employee>>> findAll() {
		List<Employee> employees = employeeService.findAll();

		ResponseStructure<List<Employee>> responseStructure = new ResponseStructure<>();
		responseStructure.setId(HttpStatus.FOUND.value());
		responseStructure.setMsg("Empolyee  Display susffully");
		responseStructure.setData(employees);
		return new ResponseEntity<ResponseStructure<List<Employee>>>(responseStructure, HttpStatus.FOUND);

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findbyId(@PathVariable int id) {
		Employee employee = employeeService.findbyId(id);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setId(HttpStatus.FOUND.value());
		responseStructure.setMsg("Empolyee  id find  susffully");
		responseStructure.setData(employee);

		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.FOUND);
	}

	@GetMapping("/title/{title}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findbyTitle(@PathVariable String title) {
		List<Employee> employees = employeeService.findByTitle(title);
		ResponseStructure<List<Employee>> responseStructure = new ResponseStructure<>();
		responseStructure.setId(HttpStatus.FOUND.value());
		responseStructure.setMsg("Empolyee  id find  susffully");
		responseStructure.setData(employees);

		return new ResponseEntity<ResponseStructure<List<Employee>>>(responseStructure, HttpStatus.FOUND);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Employee>> deleteById(int id) {
		Employee employee = employeeService.deleteById(id);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setId(HttpStatus.OK.value());
		responseStructure.setMsg("Empolyee  Delete  susffully");
		responseStructure.setData(employee);

		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Employee>> updatebyId(int id, @RequestBody Employee updateemp) {
		Employee employee = employeeService.updateById(id, updateemp);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setId(HttpStatus.OK.value());
		responseStructure.setMsg("Empolyee  udated  susffully");
		responseStructure.setData(employee);

		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
	}

	@GetMapping("/sal/{sal}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findBysalaryGreterThan(@PathVariable int sal) {
		List<Employee> employees = employeeService.findBySalaryGreaterThan(sal);;
		
		
		ResponseStructure<List<Employee>> responseStructure=new ResponseStructure<List<Employee>>();
		responseStructure.setId(HttpStatus.FOUND.value());
		responseStructure.setMsg("salaray is Greter than ");
		responseStructure.setData(employees);
		return new ResponseEntity<ResponseStructure<List<Employee>>>(responseStructure,HttpStatus.FOUND);
	}
}
