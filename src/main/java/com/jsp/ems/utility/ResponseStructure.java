package com.jsp.ems.utility;

public class ResponseStructure<a> {
	private  int id;
	private  String msg ;
	private a data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public a getData() {
		return data;
	}
	public void setData(a data) {
		this.data = data;
	}
	
}
