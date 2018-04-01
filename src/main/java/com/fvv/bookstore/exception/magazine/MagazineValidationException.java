package com.fvv.bookstore.exception.magazine;

/**
 * Exception class for a validation of a Magazine object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class MagazineValidationException extends Exception {
	
	/**
	 * Serial version for a magazine validation
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of validation for a magazine
	 * 
	 * @param message of error
	 */
	public MagazineValidationException(String message) {
		super(message);
	}

}
