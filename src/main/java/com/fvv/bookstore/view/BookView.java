package com.fvv.bookstore.view;

/**
 * BookView interface to view the Book object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public interface BookView {

	/**
	 * Add a book using Controller.
	 */
	void addBook();
	
	/**
	 * Lists all the books using Controller.
	 */
	void listBooks();

	/**
	 * Update a book already added using Controller.
	 */
	void updateBook();
	
	/**
	 * Delete a book using Controller.
	 */
	void removeBook();
}
