package com.govind.rest.webservices.restfulwebservices.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.govind.rest.webservices.restfulwebservices.bean.HelloWorldBean;

@RestController
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, value = "/helloworld", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getMessage() {
		return "Hello World !!";
	}
	
	@GetMapping(value = "/govind")
	public String wishGovind() {
		return "Hello Govind...!!!";
	}
	
	@GetMapping(value ="/helloworldbean")
		public HelloWorldBean getMessageBean() {
		return new HelloWorldBean("HelloWorldBean");
	}
	
	@GetMapping(value ="/helloworldbean/users/{userName}")
	public HelloWorldBean getMessageBeanWithPathVariable(@PathVariable String userName) {
	return new HelloWorldBean(String.format("HelloWorldBean, %s", userName));
	
}
}
