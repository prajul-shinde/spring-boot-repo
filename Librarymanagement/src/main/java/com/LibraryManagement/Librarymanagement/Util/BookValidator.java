package com.LibraryManagement.Librarymanagement.Util;

import com.LibraryManagement.Librarymanagement.Model.Book;

public class BookValidator {

	public boolean isValid(Book book) {
		if (book.getTitle() == "" || book.getTitle().equals(null))
			return false;
		return true;
	}
}
