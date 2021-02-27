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

import com.LibraryManagement.Librarymanagement.DataAccessLayer.IssuedBookRepository;
import com.LibraryManagement.Librarymanagement.Model.IssuedBooks;

@RestController
public class IssuedBooksController {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Autowired
	private IssuedBookRepository repo;

	@GetMapping("/issuedBooks")
	List<IssuedBooks> findAll() {
		return repo.findAll();
	}

	@PostMapping("/issueBook")
	@ResponseStatus(HttpStatus.CREATED)
	public IssuedBooks issueBook(@RequestBody IssuedBooks issuedBooks) throws Exception {
		try {
			return repo.save(issuedBooks);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}

	}

	@GetMapping("/seachIssuedBooksByUser")
	public List<IssuedBooks> searchIssuedBooksByUser(@RequestParam(value = "q") String userId) {
		LOGGER.info("searchIssuedBooksByUser called with userId " + userId);
		List<IssuedBooks> books = repo.findAll();
		List<IssuedBooks> list = new ArrayList<IssuedBooks>();

		for (IssuedBooks book : books) {
			int id = Integer.parseInt(userId);
			if (book.getUser_id() == id) {
				list.add(book);
			}
		}
		return list;
	}
}
