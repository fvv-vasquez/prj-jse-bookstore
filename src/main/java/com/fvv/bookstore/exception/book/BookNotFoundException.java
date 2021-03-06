package com.fvv.bookstore.exception.book;

/**
 * Exception class for a book not found
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class BookNotFoundException extends Exception {

	/**
	 * Serial version for a Book not found Exception
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of book not found 
	 * 
	 * @param message of error
	 */
	public BookNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * Message of book not found
	 * 
	 * @param message of error
	 * @param e original exception
	 */
	public BookNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}
