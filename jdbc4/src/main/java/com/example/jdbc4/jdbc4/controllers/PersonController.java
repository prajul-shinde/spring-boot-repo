package com.example.jdbc4.jdbc4.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbc4.jdbc4.DAOs.Person;
import com.example.jdbc4.jdbc4.DBManager.DBOperations;
import com.example.jdbc4.jdbc4.Requests.CreateRequest;

@RestController
public class PersonController {

	@GetMapping("/getpersons")
	public List<Person> getPersons() throws SQLException {
		// calling to get object from db
		return DBOperations.getPersons();
	}

	@PostMapping("/createTable")
	public void createTable() throws SQLException {
		DBOperations.createTable();
	}

	@PostMapping("/insertPerson")
	public void createPerson(@RequestBody CreateRequest request) throws SQLException {

		DBOperations.insertPerson(request);
	}
}
