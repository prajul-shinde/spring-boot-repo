package com.LibraryManagement.Librarymanagement.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LibraryManagement.Librarymanagement.Model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
