package com.fvv.bookstore.view;

import com.fvv.bookstore.bean.Book;

/**
 * BookView interface to view the Book object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 24 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public interface BookView {

	/**
	 * Add a book using Controller.
	 */
	public void addBook();
	
	/**
	 * Lists all the books using Controller.
	 * 
	 * @return a list of books.
	 */
	public void listBooks();

	/**
	 * Update a book already added using Controller.
	 */
	public void updateBook();
	
	/**
	 * Delete a book using Controller.
	 */
	public void removeBook();
	
	/**
	 * Find a book using Controller.
	 * 
	 * @param id of Long type.
	 * @return a Book
	 */
	public Book findBook(final Long id);
}
