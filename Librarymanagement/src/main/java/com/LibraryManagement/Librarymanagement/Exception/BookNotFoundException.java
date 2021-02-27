package com.LibraryManagement.Librarymanagement.Exception;

public class BookNotFoundException extends Exception {

	public BookNotFoundException(int id) {
		super("book id not found " + id);
	}
}
