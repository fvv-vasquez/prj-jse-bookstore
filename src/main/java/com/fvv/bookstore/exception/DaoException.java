package com.fvv.bookstore.exception;

public class DaoException extends Exception {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of a DAO error.
	 * 
	 * @param message of error.
	 */
	public DaoException(String message, Throwable e) {
		super(message, e);
	}
}
