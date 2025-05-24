package com.jsp.ems.exception;

public class EmployeeSalaryAreNotFound extends RuntimeException {
 private String msg;

public EmployeeSalaryAreNotFound(String msg) {
	super();
	this.msg = msg;
}
 @Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}
}
