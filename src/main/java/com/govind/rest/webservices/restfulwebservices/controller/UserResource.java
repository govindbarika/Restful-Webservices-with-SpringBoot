package com.govind.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.govind.rest.webservices.restfulwebservices.bean.User;

import com.govind.rest.webservices.restfulwebservices.dao.UserDaoImpl;
import com.govind.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;

@RestController
public class UserResource {

	public UserResource() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public UserDaoImpl userDaoImpl;
	
	@GetMapping(value = "/users")
	public List<User> retrieveAllUsers(){
		return userDaoImpl.findAllUsers();
	}
	
	@GetMapping(value="/users/{id}")
	public Resource<User> retrieveUserById(@PathVariable Integer id) {
		User user = userDaoImpl.findUserById(id);
		if(user == null) {
			throw new UserNotFoundException("Id -" + id);
		}
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder builder = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass())
										.retrieveAllUsers());
		resource.add(builder.withRel("all-users"));
		
		return resource;
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User createdUser = userDaoImpl.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(value="/users/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		User user = userDaoImpl.deleteUserById(id);
		if(user == null) {
			throw new UserNotFoundException("Id -" + id);
		}
	}

}
