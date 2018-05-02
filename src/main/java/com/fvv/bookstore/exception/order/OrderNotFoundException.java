package com.fvv.bookstore.exception.order;

/**
 * Exception class for an order not found in a search
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class OrderNotFoundException extends Exception {
	
	/**
	 * Serial version for an Order not found Exception
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message of an order not found.
	 * 
	 * @param message of error.
	 */
	public OrderNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * Message of an order not found.
	 * 
	 * @param message of error.
	 * @param e original exception.
	 */
	public OrderNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
