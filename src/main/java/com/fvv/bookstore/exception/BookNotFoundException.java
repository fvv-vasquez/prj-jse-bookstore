package com.fvv.bookstore.exception;

/**
 * Exception class for a book not found in a search
 * 
 * @author Fatima Vasquez
 * <p>Created on 28 de mar de 2018</p>	
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
