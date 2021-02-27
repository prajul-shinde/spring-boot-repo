package com.LibraryManagement.Librarymanagement.Controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagement.Librarymanagement.DataAccessLayer.UserRepository;
import com.LibraryManagement.Librarymanagement.Exception.UserNotFoundException;
import com.LibraryManagement.Librarymanagement.Model.User;

@RestController
public class UserController {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	private UserRepository repo;

	@GetMapping("/users")
	List<User> findAll() {
		return repo.findAll();
	}

	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	User newUser(@RequestBody User newUser) {
		return repo.save(newUser);
	}

	@GetMapping("/users/{id}")
	User findOne(@PathVariable("id") int id) {
		LOGGER.info("/users/{id} called with id " + id);
		// Optional<User> user = repo.findById(id);
		return repo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
}
