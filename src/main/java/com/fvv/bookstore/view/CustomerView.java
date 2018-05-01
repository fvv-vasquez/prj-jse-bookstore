package com.fvv.bookstore.view;

/**
 * CustomerView interface to view the Customer object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface CustomerView {

	/**
	 * Add a Customer using Controller.
	 */
	void addCustomer();
	
	/**
	 * Lists all the Customers using Controller.
	 */
	void listCustomers();

	/**
	 * Update a Customer already added using Controller.
	 */
	void updateCustomer();
	
	/**
	 * Delete a Customer using Controller.
	 */
	void removeCustomer();
	
	/**
	 * List the customers by search name using Controller.
	 */
	void listCustomersByName();
}
