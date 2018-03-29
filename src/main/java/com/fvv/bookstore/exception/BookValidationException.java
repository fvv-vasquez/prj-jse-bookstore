package com.fvv.bookstore.exception;

/**
 * Exception class for a validation of a Book object
 * 
 * @author Fatima Vasquez
 * <p>Created on 29 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public class BookValidationException extends Exception {

	/**
	 * Serial version for a book validation
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of validation for a book
	 * 
	 * @param message of error
	 */
	public BookValidationException(String message) {
		super(message);
	}
}
