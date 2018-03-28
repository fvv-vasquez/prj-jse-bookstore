package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.exception.DaoException;

/**
 * DAO Interface of a Book object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 21 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public interface BookDAO {

	/**
	 * Add a book at the bookstore in the database.
	 * 
	 * @param book of Book type.
	 * @throws DaoException when a problem in database happens.
	 */
	public boolean addBook(final Book book) throws DaoException;

	/**
	 * Lists all the books in the database.
	 * 
	 * @return a list of books.
	 * @throws DaoException when a problem in database happens.
	 */
	public List<Book> listBooks() throws DaoException;

	/**
	 * Update a book already added in the database.
	 * 
	 * @param book of Book type.
	 * @throws DaoException when a problem in database happens.
	 */
	public boolean updateBook(final Book book) throws DaoException;

	/**
	 * Delete a book from the bookstore in the database.
	 * 
	 * @param id of Long type.
	 * @throws DaoException when a problem in database happens.
	 */
	public void removeBook(final Long id) throws DaoException;
}
