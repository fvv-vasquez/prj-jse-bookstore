package com.fvv.bookstore.exception.hardware;

/**
 * Exception class for a validation of a Hardware object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class HardwareValidationException extends Exception {

	/**
	 * Serial version for a hardware validation
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of validation for a hardware
	 * 
	 * @param message of error
	 */
	public HardwareValidationException(String message) {
		super(message);
	}
}
