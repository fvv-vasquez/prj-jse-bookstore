package com.fvv.bookstore.exception.hardware;

/**
 * Exception class for a hardware not found in a search
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class HardwareNotFoundException extends Exception {

	/**
	 * Serial version for a hardware not found exception.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of a hardware not found.
	 * 
	 * @param message of error.
	 */
	public HardwareNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * Message of a hardware not found.
	 * 
	 * @param message of error.
	 * @param e original exception.
	 */
	public HardwareNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}
