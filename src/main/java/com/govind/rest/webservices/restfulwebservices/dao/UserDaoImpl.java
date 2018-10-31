package com.govind.rest.webservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.govind.rest.webservices.restfulwebservices.bean.User;

@Repository
public class UserDaoImpl {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 4;
	
	static {
		users.add(new User(1, "Govind", new Date()));
		users.add(new User(2, "Ghouse", new Date()));
		users.add(new User(3, "Ashok", new Date()));
		users.add(new User(4, "Suri", new Date()));
	}
	
	public List<User> findAllUsers(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findUserById(Integer id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteUserById(Integer id) {
		
		Iterator<User> iterator = users.iterator(); 
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
