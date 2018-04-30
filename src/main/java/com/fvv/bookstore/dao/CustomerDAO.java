package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Customer;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

/**
 * DAO Interface of a Customer object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface CustomerDAO {
	
	/**
	 * Add a customer at the bookstore in the database.
	 * 
	 * @param customer of Customer type.
	 * @throws DaoException when a problem in database happens.
	 */
	void addCustomer(final Customer customer) throws DaoException;

	/**
	 * Lists all the customers in the database.
	 * 
	 * @return a list of customers.
	 * @throws DaoException when a problem in database happens.
	 */
	List<Customer> listCustomers() throws DaoException;

	/**
	 * Update a customer already added in the database.
	 * 
	 * @param customer of Customer type.
	 * @throws DaoException when a problem in database happens.
	 */
	void updateCustomer(final Customer customer) throws DaoException;

	/**
	 * Delete a customer from the bookstore in the database.
	 * 
	 * @param id of Long type.
	 * @throws DaoException when a problem in database happens.
	 */
	void removeCustomer(final Long id) throws DaoException;
	
	/**
	 * Search a customer in the database.
	 * 
	 * @param id of a Long type.
	 * @return a Customer.
	 * @throws PersonNotFoundException when not found a person in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	Customer findCustomer(final Long id) throws PersonNotFoundException, DaoException;
	
	/**
	 * List the customers by search name.
	 * 
	 * @param name to search.
	 * @return a list of customers by search name.
	 * @throws PersonNotFoundException when not found a person in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	List<Customer> listCustomersByName(final String name) throws PersonNotFoundException, DaoException;
}
