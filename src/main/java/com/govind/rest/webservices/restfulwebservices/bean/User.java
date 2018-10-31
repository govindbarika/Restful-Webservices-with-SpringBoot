package com.govind.rest.webservices.restfulwebservices.bean;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="User model for UserResource REST ")
public class User {
	
	private Integer id;
	@Size(min=2, message="Name should have atleast 2 Characters")
	@ApiModelProperty(notes="Name should have atleast 2 Characters")
	private String name;
	@Past
	@ApiModelProperty(notes="birth date should be in the past")
	private Date birthDate;
	
	

	public User() {
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}



	public User(Integer id, String name, Date birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	

}
