package com.LibraryManagement.Librarymanagement.Exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(int id) {
		super("user id not found " + id);
	}

}
