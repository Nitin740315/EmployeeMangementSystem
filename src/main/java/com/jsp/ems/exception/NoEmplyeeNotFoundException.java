package com.jsp.ems.exception;

public class NoEmplyeeNotFoundException extends RuntimeException {
private String msg;

public NoEmplyeeNotFoundException(String msg) {
	
	this.msg = msg;
}
@Override
	public String getMessage() {
		
		return msg;
	}

}
