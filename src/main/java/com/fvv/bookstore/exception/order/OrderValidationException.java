package com.fvv.bookstore.exception.order;

/**
 * Exception class for a validation of an Order object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class OrderValidationException extends Exception {

	/**
	 * Serial version for an order validation
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Message of validation for an order.
	 * 
	 * @param message of error.
	 */
	public OrderValidationException(String message) {
		super(message);
	}
}
