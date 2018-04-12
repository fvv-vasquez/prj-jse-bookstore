package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.exception.person.PersonValidationException;

/**
 * Controller interface for a Employee object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface EmployeeController {

	/**
	 * Add a employee using DAO.
	 * 
	 * @param employee of Employee type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws PersonValidationException when a field is empty.
	 */
	void addEmployee(final Employee employee) throws 
		PersonValidationException, ControllerException;
	
	/**
	 * Lists all the employees using DAO.
	 * 
	 * @return a list of employees.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<Employee> listEmployees() throws ControllerException;

	/**
	 * Update a employee already added using DAO.
	 * 
	 * @param employee of Employee type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws PersonValidationException when a field is empty.
	 */
	void updateEmployee(final Employee employee) throws 
		PersonValidationException, ControllerException;
	
	/**
	 * Delete a employee using DAO.
	 * 
	 * @param id of Long type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void removeEmployee(final Long id) throws ControllerException;
	
	/**
	 * Search a employee using DAO
	 * 
	 * @param id of Long type.
	 * @return a Employee.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws PersonNotFoundException when a employee is not found.
	 */
	Employee findEmployee(final Long id) throws PersonNotFoundException, ControllerException;
}
