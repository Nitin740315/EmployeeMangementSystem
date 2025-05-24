package com.jsp.ems.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.ems.entity.Employee;
import com.jsp.ems.exception.EmployeeSalaryAreNotFound;
import com.jsp.ems.exception.NoEmplyeeNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleEmployeeNotFoundById(NoEmplyeeNotFoundException em)
	{
		ErrorStructure<String>  e= new ErrorStructure<String>();
	   e.setErrorcode(HttpStatus.NOT_FOUND.value());
	   e.setErrormsg(em.getMessage());
	   e.setData("Employe is not Found on this id");
	   
	   return new ResponseEntity<ErrorStructure<String>>(e,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handaleEmployeesalaryGrterThan(EmployeeSalaryAreNotFound es)
	{
		ErrorStructure<String> e= new ErrorStructure<String>();
		e.setErrorcode(HttpStatus.NOT_FOUND.value());
		e.setErrormsg(es.getMessage());
		e.setData("Not found grether than salary");
		return new ResponseEntity<ErrorStructure<String>>(e,HttpStatus.NOT_FOUND);
	}
}
