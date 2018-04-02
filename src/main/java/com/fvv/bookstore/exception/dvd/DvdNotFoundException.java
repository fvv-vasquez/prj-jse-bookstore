package com.fvv.bookstore.exception.dvd;

/**
 * Exception class for a dvd not found in a search
 * 
 * @author Fatima Vasquez
 * <p>Created on 1 de abr de 2018</p>	
 * @version 1.0 	
 *
 */
public class DvdNotFoundException extends Exception {

	/**
	 * Serial version for a dvd not found Exception
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of a dvd not found.
	 * 
	 * @param message of error.
	 */
	public DvdNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * Message of a dvd not found.
	 * 
	 * @param message of error.
	 * @param e original exception.
	 */
	public DvdNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}
