package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.order.OrderNotFoundException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

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
	
	/**
	 * Lists all orders by month.
	 * 
	 * @param month to search.
	 * @param year to search.
	 * @return a list of orders.
	 * @throws OrderNotFoundException when not found an order in the database.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<Order> listTotalOrdersByMonth(final Integer month, final Integer year) 
			throws OrderNotFoundException, ControllerException;
	
	/**
	 * Calculate the total of order amount.
	 * 
	 * @param orders to calculate.
	 * @return the total.
	 */
	Double calculateTotalOrders(final List<Order> orders);
	
	/**
	 * Calculate the quantity of orders amount.
	 * 
	 * @param orders to calculate.
	 * @return the amount of orders.
	 */
	Integer calculateQtyOrders(final List<Order> orders);
	
	/**
	 * Lists all sales per seller.
	 * 
	 * @param employee to search its sales.
	 * @return a list of orders.
	 * @throws PersonNotFoundException when not found a person in the database.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<Order> listTotalSalesPerSeller(final Employee employee) 
			throws PersonNotFoundException, ControllerException;
	
	/**
	 * Lists an order by order id.
	 * 
	 * @param id to search.
	 * @return the searched order.
	 * @throws OrderNotFoundException when not found an order in the database.
	 * @throws ControllerException when a problem in controller happens.
	 */
	Order listOrderByOrderId(final Long id) throws OrderNotFoundException, ControllerException;
}
