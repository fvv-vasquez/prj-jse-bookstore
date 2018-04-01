package com.fvv.bookstore.exception;

/**
 * Exception class for a DAO error.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class DaoException extends Exception {

	/**
	 * Serial version for DAO Exception
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of a DAO error.
	 * 
	 * @param message of error.
	 * @param e original exception.
	 */
	public DaoException(String message, Throwable e) {
		super(message, e);
	}
}
