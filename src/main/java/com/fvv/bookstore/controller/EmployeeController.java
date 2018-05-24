package com.fvv.bookstore.controller;

import java.time.YearMonth;
import java.util.List;

import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.exception.person.PersonValidationException;

/**
 * Controller interface for an Employee object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface EmployeeController {

	/**
	 * Add an employee using DAO.
	 * 
	 * @param employee of Employee type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws PersonValidationException when a field is empty.
	 */
	void addEmployee(final Employee employee) throws 
		PersonValidationException, ControllerException;
	
	/**
	 * Lists all employees using DAO.
	 * 
	 * @return a list of employees.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<Employee> listEmployees() throws ControllerException;

	/**
	 * Update an employee already added using DAO.
	 * 
	 * @param employee of Employee type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws PersonValidationException when a field is empty.
	 */
	void updateEmployee(final Employee employee) throws 
		PersonValidationException, ControllerException;
	
	/**
	 * Delete an employee using DAO.
	 * 
	 * @param id of Long type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void removeEmployee(final Long id) throws ControllerException;
	
	/**
	 * Search an employee using DAO
	 * 
	 * @param id of Long type.
	 * @return an Employee.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws PersonNotFoundException when an employee is not found.
	 */
	Employee findEmployee(final Long id) throws PersonNotFoundException, ControllerException;
	
	/**
	 * Lists all employees by name using DAO.
	 * 
	 * @param name to search.
	 * @return a list of employees ordered by name.
	 * @throws PersonNotFoundException when an employee is not found.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<Employee> listEmployeesByName(final String name) throws PersonNotFoundException, ControllerException;
	
	/**
	 * Gets the salary adding the percentage.
	 * 
	 * @param commission to calculate with the salary.
	 * @param employee to get the information.
	 * @return the salary with commission.
	 */
	Double getSalaryWithCommission(final Double commission, final Employee employee);
	
	/**
	 * Gets the commission.
	 * 
	 * @param percentage for commission.
	 * @param employee to get the information.
	 * @param date to take the sales in the period.
	 * @return the commission.
	 * @throws PersonNotFoundException when not found a person in the database.
	 * @throws ControllerException when a problem in controller happens.
	 */
	Double calculateCommission(final Double percentage, final Employee employee, final YearMonth date) 
			throws PersonNotFoundException, ControllerException;
}
