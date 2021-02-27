package com.example.demosecurity4.demosecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demosecurity4.demosecurity.model.User;
import com.example.demosecurity4.demosecurity.repository.UserRepository;

@RestController
public class FooBarController {

	@Autowired
	UserRepository repo;

	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody User user) {
		User user2 = new User(user.getUsername(), user.getPassword());
		if (repo.findByUserName(user.getUsername()) != null) {
			return;
		}
		repo.save(user);
	}

	// my_role1= can access only /student
	// my_role2= can access both /student and /admin
	// my_role3= can access only visitor api ("doesnt require authentication")
	@GetMapping("/student")
	// requires authentication and authorization
	public String getStudent() {
		return "hello student";
	}

	@GetMapping("/admin")
	// requires authentication and authorization
	public String getAdmin() {
		return "hello admin";
	}

	// no authentication and authorization
	@GetMapping("/visitor")
	public String getVisitor() {
		return "hello visitor";
	}
}
