package com.fvv.bookstore.controller;

import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.order.OrderValidationException;

/**
 * Controller interface for an Order object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface OrderController {

	/**
	 * Add an order using DAO.
	 * 
	 * @param order of Order type.
	 * @throws OrderValidationException when a field is empty.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void addOrder(final Order order) throws OrderValidationException, ControllerException;
}
