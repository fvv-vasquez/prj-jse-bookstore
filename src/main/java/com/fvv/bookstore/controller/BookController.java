package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.book.BookNotFoundException;
import com.fvv.bookstore.exception.book.BookValidationException;

/**
 * Controller interface for a Book object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public interface BookController {
	
	/**
	 * Add a book using DAO.
	 * 
	 * @param book of Book type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws BookValidationException when a field is empty.
	 */
	void addBook(final Book book) throws BookValidationException, ControllerException;
	
	/**
	 * Lists all the books using DAO.
	 * 
	 * @return a list of books.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<Book> listBooks() throws ControllerException;

	/**
	 * Update a book already added using DAO.
	 * 
	 * @param book of Book type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws BookValidationException when a field is empty.
	 */
	void updateBook(final Book book) throws BookValidationException, ControllerException;
	
	/**
	 * Delete a book using DAO.
	 * 
	 * @param id of Long type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void removeBook(final Long id) throws ControllerException;
	
	/**
	 * Search a book using DAO
	 * 
	 * @param id of Long type.
	 * @return a Book.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws BookNotFoundException when a book is not found.
	 */
	Book findBook(final Long id) throws BookNotFoundException, ControllerException;

	/**
	 * Search a book by the title using DAO.
	 * 
	 * @param title of String type.
	 * @return a book.
	 * @throws BookNotFoundException when a book is not found.
	 * @throws ControllerException when a problem in controller happens.
	 */
	Book findBookByTitle(final String title) throws BookNotFoundException, ControllerException;
	
	/**
	 * Reduce the quantity of a stock item using DAO.
	 * 
	 * @param book of Book type.
	 * @param quantityToReduce of Integer type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void reduceStockItem(final Book book, final Integer quantityToReduce) throws ControllerException;
}
