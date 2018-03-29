package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.exception.BookNotFoundException;
import com.fvv.bookstore.exception.BookValidationException;
import com.fvv.bookstore.exception.ControllerException;

/**
 * Controller interface for a Book object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 24 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public interface BookController {
	
	/**
	 * Add a book using DAO.
	 * 
	 * @param book of Book type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	public boolean addBook(final Book book) throws ControllerException;
	
	/**
	 * Lists all the books using DAO.
	 * 
	 * @return a list of books.
	 * @throws ControllerException when a problem in controller happens.
	 */
	public List<Book> listBooks() throws ControllerException;

	/**
	 * Update a book already added using DAO.
	 * 
	 * @param book of Book type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	public boolean updateBook(final Book book) throws ControllerException;
	
	/**
	 * Delete a book using DAO.
	 * 
	 * @param id of Long type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	public void removeBook(final Long id) throws ControllerException;
	
	/**
	 * Search a book using DAO
	 * 
	 * @param id of Long type.
	 * @return a Book.
	 * @throws BookNotFoundException when not found a book.
	 * @throws ControllerException 
	 */
	public Book findBook(final Long id) throws ControllerException;
	
	public void validateBook(final Book book) throws BookValidationException;
}
