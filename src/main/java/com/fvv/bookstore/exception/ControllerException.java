package com.fvv.bookstore.exception;

/**
 * Exception class for a Controller error.
 * 
 * @author Fatima Vasquez
 * <p>Created on 24 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public class ControllerException extends Exception {

	/**
	 * Serial version for Controller Exception
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of Controller error.
	 * 
	 * @param message of error
	 * @param e original exception
	 */
	public ControllerException(String message, Throwable e) {
		super(message, e);
	}
}
