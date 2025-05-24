package com.jsp.ems.utility;

public class ErrorStructure<a> {
	private int errorcode;
	private String errormsg;
	private a data;
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public a getData() {
		return data;
	}
	public void setData(a data) {
		this.data = data;
	}
	

}
