package com.fvv.bookstore.exception.person;

/**
 * Exception class for a validation of a Person object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class PersonValidationException extends Exception {

	/**
	 * Serial version for a person validation
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of validation for a person
	 * 
	 * @param message of error
	 */
	public PersonValidationException(String message) {
		super(message);
	}
}
