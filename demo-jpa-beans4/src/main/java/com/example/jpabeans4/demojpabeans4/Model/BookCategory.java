package com.example.jpabeans4.demojpabeans4.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	public BookCategory() {

	}

	public BookCategory(String name) {
		super();
		this.name = name;
	}

	public BookCategory(String name, Set<Book> books) {
		super();
		this.name = name;
		this.books = books;

		this.books.forEach(x -> x.setBookCategory(this));
	}

	// one bookcategory
	// many books

	@OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
	private Set<Book> books; // to which table this book is mapping to

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	// which table this books mapping to

	// generation type

	// Hibernate
	// insert first entry in table 1=> 1
	// insert first entry in table 2 => 2
	// insert second entry in table 3 =>3

	// identity
	// insert first entry in table 1=> 1
	// insert first entry in table 2 => 1
	// insert second entry in table 3 =>2

}
