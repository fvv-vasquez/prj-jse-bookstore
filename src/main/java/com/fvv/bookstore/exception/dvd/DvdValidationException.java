package com.fvv.bookstore.exception.dvd;

/**
 * Exception class for a validation of a Dvd object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class DvdValidationException extends Exception {

	/**
	 * Serial version for a dvd validation
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of validation for a dvd
	 * 
	 * @param message of error
	 */
	public DvdValidationException(String message) {
		super(message);
	}
}
