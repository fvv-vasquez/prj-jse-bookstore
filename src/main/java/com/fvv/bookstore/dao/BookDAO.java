package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.exception.DaoException;

/**
 * DAO Interface of a Book object, with main database operations from CRUD methods.
 * 
 * Created on 03/21/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public interface BookDAO {

	/**
	 * Add a book at the bookstore in the database.
	 * 
	 * @param addBook of Book type.
	 * @throws DaoException 
	 */
	public void addBook(Book book) throws DaoException;

	/**
	 * Lists all the books in the database.
	 * 
	 * @return a list of books.
	 * @throws DaoException 
	 */
	public List<Book> listBooks() throws DaoException;

	/**
	 * Update a book already add in the database.
	 * 
	 * @param updateBook of Book type.
	 * @throws DaoException 
	 */
	public void updateBook(Book book) throws DaoException;

	/**
	 * Delete a book from the bookstore in the database.
	 * 
	 * @param removeBook of Integer type.
	 * @throws DaoException 
	 */
	public void removeBook(Integer isbn) throws DaoException;
}
