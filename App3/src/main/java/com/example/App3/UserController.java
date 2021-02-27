package com.example.App3;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	DBUser db = new DBUser();

	@GetMapping("/users")
	public List<User> userList() {
		return db.getAllUsers();
	}

	@GetMapping("/getuser/{id}")
	public User getAUser(@PathVariable("id") int id) {
		return db.getAUser(id);
	}

	@PostMapping("/users")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveUser(@RequestBody User user) {
		db.createUser(user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteAUser(@PathVariable("id") int id) {
		db.deleteAUser(id);
	}

	// 4xx = issue with client request
	// 200x = client side fine
	// 500x =issue with server
	// 300x
}
