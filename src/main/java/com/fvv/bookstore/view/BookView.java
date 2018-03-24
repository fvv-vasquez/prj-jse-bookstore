package com.fvv.bookstore.view;

/**
 * BookView interface to view the Book object.
 * 
 * @author Fatima Vasquez
 * Created on 24 de mar de 2018	
 * @version 1.0 	
 *
 */
public interface BookView {

	/**
	 * Add a book using Controller.
	 * 
	 * @param book of Book type.
	 */
	public void addBook();
	
	/**
	 * Lists all the books using Controller.
	 * 
	 * @return a list of books.
	 */
	public void listBooks();

	/**
	 * Update a book already add using Controller.
	 * 
	 * @param book of Book type.
	 */
	public void updateBook();
	
	/**
	 * Delete a book using Controller.
	 * 
	 * @param isbn of Integer type.
	 */
	public void removeBook();
}
