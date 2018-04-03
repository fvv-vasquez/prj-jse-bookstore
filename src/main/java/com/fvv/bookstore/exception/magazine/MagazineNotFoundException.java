package com.fvv.bookstore.exception.magazine;

/**
 * Exception class for a magazine not found in a search
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class MagazineNotFoundException extends Exception {
	
	/**
	 * Serial version for a Magazine not found Exception
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of a magazine not found.
	 * 
	 * @param message of error.
	 */
	public MagazineNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * Message of a magazine not found.
	 * 
	 * @param message of error.
	 * @param e original exception.
	 */
	public MagazineNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}
