package com.example.jdbc4.jdbc4.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbc4.jdbc4.DAOs.Person;
import com.example.jdbc4.jdbc4.Requests.CreateRequest;

public class DBOperations {

	public static volatile Connection connection;

	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			synchronized (DBOperations.class) {
				if (connection == null) {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person_4", "root", "root");

				}

			}
		}
		return connection;

	}

	public static void closeConnection() throws SQLException {
		if (connection != null) {
			synchronized (DBOperations.class) {
				if (connection != null) {
					connection = null;
				}
			}
		}
	}

	public static void createTable() throws SQLException {
		getConnection();
		Statement statement = connection.createStatement();
		boolean isCreated = statement.execute(
				"CREATE TABLE person(id INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(20),age INT,address VARCHAR(50))");

		if (isCreated) {
			System.out.println("table is created successfully");
		}
		closeConnection();
	}

	public static List<Person> getPersons() throws SQLException {
		getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from person");

		List<Person> persons = new ArrayList();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int age = rs.getInt(3);
			String address = rs.getString(4);
			Person person = new Person(id, name, age, address);
			System.out.println(person);
			persons.add(person);
			closeConnection();
		}
		return persons;

	}

	public static void insertPerson(CreateRequest request) throws SQLException {
		getConnection();
		PreparedStatement ps = connection.prepareStatement("INSERT INTO person VALUES(null,?,?,?)");
		ps.setString(1, request.getName());
		ps.setInt(2, request.getAge());
		ps.setString(3, request.getAddress());
		int rowsAffected = ps.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("record inserted successfully");
		} else {
			System.out.println("failed to insert a record");
		}
		closeConnection();
	}

	public Person getPersonById() {
		return null;

	}

	public static void deletePerson(int id) {

	}

	public static void updatePerson(int id, Person person) {

	}

}
