package com.LibraryManagement.Librarymanagement.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LibraryManagement.Librarymanagement.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

//	@Query(value = "SELECT * FROM user WHERE user.id IN(SELECT rent.user_id FROM rent WHERE rent.book_id IN(SELECT book.id FROM book where book.name=:bookname))", nativeQuery = true)
//	List<User> findUsersByBookName(String bookname);
//
//	@Query(value = "SELECT user.id FROM user WHERE user.name=:username")
//	int findByUserName(String userName);
//
//	List<Book> findUserByUserName(String username);
}
