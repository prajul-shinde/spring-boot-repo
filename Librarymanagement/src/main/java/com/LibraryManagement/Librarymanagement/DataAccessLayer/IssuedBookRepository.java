package com.LibraryManagement.Librarymanagement.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LibraryManagement.Librarymanagement.Model.IssuedBooks;

public interface IssuedBookRepository extends JpaRepository<IssuedBooks, Integer> {

}
