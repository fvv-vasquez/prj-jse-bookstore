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
	 * Add an Employee using Controller.
	 */
	void addEmployee();
	
	/**
	 * Lists all the Employees using Controller.
	 */
	void listEmployees();

	/**
	 * Update an Employee already added using Controller.
	 */
	void updateEmployee();
	
	/**
	 * Delete an Employee using Controller.
	 */
	void removeEmployee();
}
