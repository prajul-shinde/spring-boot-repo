package com.example.jpabeans4.demojpabeans4;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpabeans4.demojpabeans4.Model.Book;
import com.example.jpabeans4.demojpabeans4.Model.BookCategory;
import com.example.jpabeans4.demojpabeans4.Repository.BookCategoryRepository;
import com.example.jpabeans4.demojpabeans4.Repository.BookRepository;

@SpringBootApplication
public class DemoJpaBeans4Application implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookCategoryRepository bookCategoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaBeans4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Set<Book> books = new HashSet<>();
		Book b1 = new Book("HTML", "BOB", 200);
		Book b2 = new Book("CSS", "Louis", 240, 1);

		books.add(b1);
		books.add(b2);

		// bookRepository.saveAll(books)
		bookCategoryRepository.save(new BookCategory("non programming"));
		bookCategoryRepository.save(new BookCategory("programming languages", books));
		// books));

		// bookRepository.saveAll(books);
		// repository.saveAll(books);
		// System.out.println(repository.findAll());
//		System.out.println(repository.findByAuthorName("yadav"));
//		System.out.println(repository.findByCost(100));
//		System.out.println(repository.findById(4));
		// System.out.println(repository.findByAuthor("yadav"));
//		System.out.println(repository.findByCosts(100));

	}

}
