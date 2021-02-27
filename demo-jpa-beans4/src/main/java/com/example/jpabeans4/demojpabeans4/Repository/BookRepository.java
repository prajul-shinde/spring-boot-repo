package com.example.jpabeans4.demojpabeans4.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpabeans4.demojpabeans4.Model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByAuthorName(String name);

	@Query(value = "select * from Book b where b.author_name=:my_name", nativeQuery = true)
	public List<Book> findByAuthor(String my_name);

	List<Book> findByCost(int cost);

	@Query(value = "select b from Book b where b.cost=:cost")
	List<Book> findByCosts(int cost);

	Book findById(int id);
}
