package com.fvv.bookstore.exception.person;

/**
 * Exception class for a person not found in a search
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class PersonNotFoundException extends Exception {

	/**
	 * Serial version for a person not found exception.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of a person not found.
	 * 
	 * @param message of error.
	 */
	public PersonNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * Message of a person not found.
	 * 
	 * @param message of error.
	 * @param e original exception.
	 */
	public PersonNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}
