package com.govind.rest.webservices.restfulwebservices.bean;

public class HelloWorldBean {

	public String message;
	public HelloWorldBean() {
		// TODO Auto-generated constructor stub
	}
	public HelloWorldBean(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	
	
	

}
