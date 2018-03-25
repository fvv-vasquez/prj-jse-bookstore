package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.exception.ControllerException;

/**
 * Controller interface for a Book object.
 * 
 * @author Fatima Vasquez
 * Created on 24 de mar de 2018	
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
	public boolean addBook(Book book) throws ControllerException;
	
	/**
	 * Lists all the books using DAO.
	 * 
	 * @return a list of books.
	 * @throws ControllerException when a problem in controller happens.
	 */
	public List<Book> listBooks() throws ControllerException;

	/**
	 * Update a book already add using DAO.
	 * 
	 * @param book of Book type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	public void updateBook(Book book) throws ControllerException;
	
	/**
	 * Delete a book using DAO.
	 * 
	 * @param id of Long type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	public void removeBook(Long id) throws ControllerException;
}
