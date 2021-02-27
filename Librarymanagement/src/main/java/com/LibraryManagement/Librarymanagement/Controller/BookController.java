package com.LibraryManagement.Librarymanagement.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.LibraryManagement.Librarymanagement.DataAccessLayer.BookRepository;
import com.LibraryManagement.Librarymanagement.Exception.BookNotFoundException;
import com.LibraryManagement.Librarymanagement.Model.Book;
import com.LibraryManagement.Librarymanagement.Util.BookValidator;

@RestController
public class BookController {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Autowired
	private BookRepository bookRepository;

	BookValidator validator = new BookValidator();

	@GetMapping("/books")
	List<Book> findAll() {
		LOGGER.info("findAll called");
		List<Book> list = new ArrayList<Book>();
		try {
			list = bookRepository.findAll();
			if (list.size() == 0) {
				LOGGER.severe("No book found");
				throw new BookNotFoundException(5);
			}
		} catch (BookNotFoundException e) {
			LOGGER.severe(e.toString());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no book found", e);
		}
		return list;
	}

	@PostMapping("/books")
	@ResponseStatus(HttpStatus.CREATED)
	Book newBook(@RequestBody Book newBook) {
		if (validator.isValid(newBook)) {
			return bookRepository.save(newBook);
		} else {
			LOGGER.severe("new book is not valid");
			return null;
		}
	}

	@GetMapping("/searchBooksByAuthor")
	public List<Book> searchBooksByAuthor(@RequestParam(value = "q") String author) {
		List<Book> books = bookRepository.findAll();
		List<Book> list = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getAuthor().equals(author)) {
				list.add(book);
			}
		}
		return list;

	}

	@GetMapping("/searchBooksBySubject")
	List<Book> searchBooksBySubject(@RequestParam(value = "q") String subject) {
		List<Book> books = bookRepository.findAll();
		List<Book> list = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getSubject().equals(subject)) {
				list.add(book);
			}
		}
		return list;
	}
}
