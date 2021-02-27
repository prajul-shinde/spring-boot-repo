package com.example.demosecurity4.demosecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooBarController {

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
