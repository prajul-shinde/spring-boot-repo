package com.example.App3;

import java.util.ArrayList;
import java.util.List;

public class DBUser {

	private List<User> userTable = new ArrayList<User>();

	public DBUser() {
		userTable.add(new User(1, "prajul", 25));
		userTable.add(new User(2, "swapnil", 25));
		userTable.add(new User(3, "shashi", 30));

	}

	public List<User> getAllUsers() {
		return userTable;
	}

	public User getAUser(int id) {
		for (User user : userTable) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User createUser(User user) {
		userTable.add(user);
		return user;
	}

	public boolean deleteAUser(int id) {
		for (User user : userTable) {
			if (user.getId() == id) {
				userTable.remove(id);
				return true;
			}
		}
		return false;
	}
}
