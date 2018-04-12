package com.fvv.bookstore.view;

/**
 * EmployeeView interface to view the Employee object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface EmployeeView {

	/**
	 * Add a Employee using Controller.
	 */
	void addEmployee();
	
	/**
	 * Lists all the Employees using Controller.
	 */
	void listEmployees();

	/**
	 * Update a Employee already added using Controller.
	 */
	void updateEmployee();
	
	/**
	 * Delete a Employee using Controller.
	 */
	void removeEmployee();
}
