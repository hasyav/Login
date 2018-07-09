package com.Login.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Login.entity.User;
import com.Login.exception.UserNotFoundException;
import com.Login.service.IUserServiceImpl;

@RestController
@RequestMapping("/login")
public class UserController {

	@Autowired
	private IUserServiceImpl service;

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public List<User> getUsers() {
		return service.getUsers();
	}

	@RequestMapping(value = "/users/{userId:.+}", method = RequestMethod.GET, produces = { "application/json", "application/xml"})
	public User getUserById(@PathVariable("userId") String userId) {
		User user= service.getUser(userId);
		if(user==null)
			throw new UserNotFoundException("User with id "+ userId + " doesn't exists");
		return user;
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = { "application/json", "application/xml" })
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		String emailId=user.getEmail();
		if(service.getUser(emailId) != null) {
			throw new UserNotFoundException("User with id "+ emailId + " already exists");
		}else {
		User savedUser =  service.createUser(user);
		
		URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{userId}")
					.buildAndExpand(savedUser.getEmail()).toUri();		
			return ResponseEntity.created(location).build();
		}

	}

	@RequestMapping(value = "/users/{userId:.+}", method = RequestMethod.PUT, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public User updateUser(@PathVariable("userId") String userId, @Valid @RequestBody User user) {
		User user1 = service.getUser(userId);
		if (user1 == null) {
			throw new UserNotFoundException("User with id "+ userId + " doesn't exists");
		}
		return service.updateUser(user);
	}

	@RequestMapping(value = "/users/{userId:.+}", method = RequestMethod.DELETE, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public ResponseEntity<User> deleteUser(@PathVariable("userId") String userId) {
		User user = service.getUser(userId);
		if (user == null) {
			throw new UserNotFoundException("User with id "+ userId + " doesn't exists");
		}
		service.deleteUser(userId);
		return ResponseEntity.ok().build();
	}

}
