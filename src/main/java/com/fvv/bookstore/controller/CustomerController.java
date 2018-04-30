package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Customer;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.exception.person.PersonValidationException;

/**
 * Controller interface for a Customer object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface CustomerController {
	
	/**
	 * Add a customer using DAO.
	 * 
	 * @param customer of Customer type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws PersonValidationException when a field is empty.
	 */
	void addCustomer(final Customer customer) throws 
		PersonValidationException, ControllerException;
	
	/**
	 * Lists all the customers using DAO.
	 * 
	 * @return a list of customers.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<Customer> listCustomers() throws ControllerException;

	/**
	 * Update a customer already added using DAO.
	 * 
	 * @param customer of Customer type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws PersonValidationException when a field is empty.
	 */
	void updateCustomer(final Customer customer) throws 
		PersonValidationException, ControllerException;
	
	/**
	 * Delete a customer using DAO.
	 * 
	 * @param id of Long type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void removeCustomer(final Long id) throws ControllerException;
	
	/**
	 * Search a customer using DAO
	 * 
	 * @param id of Long type.
	 * @return a Customer.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws PersonNotFoundException when a customer is not found.
	 */
	Customer findCustomer(final Long id) throws PersonNotFoundException, ControllerException;
	
	List<Customer> listCustomersByName(final String name) throws PersonNotFoundException, ControllerException;
}
