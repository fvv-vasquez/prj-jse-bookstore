package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

/**
 * DAO Interface of an Employee object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface EmployeeDAO {

	/**
	 * Add an employee at the bookstore in the database.
	 * 
	 * @param employee of Employee type.
	 * @throws DaoException when a problem in database happens.
	 */
	void addEmployee(final Employee employee) throws DaoException;

	/**
	 * Lists all the employees in the database.
	 * 
	 * @return a list of employees.
	 * @throws DaoException when a problem in database happens.
	 */
	List<Employee> listEmployees() throws DaoException;

	/**
	 * Update an employee already added in the database.
	 * 
	 * @param employee of Employee type.
	 * @throws DaoException when a problem in database happens.
	 */
	void updateEmployee(final Employee employee) throws DaoException;

	/**
	 * Delete an employee from the bookstore in the database.
	 * 
	 * @param id of Long type.
	 * @throws DaoException when a problem in database happens.
	 */
	void removeEmployee(final Long id) throws DaoException;
	
	/**
	 * Search an employee in the database.
	 * 
	 * @param id of a Long type.
	 * @return an Employee.
	 * @throws PersonNotFoundException when not found a person in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	Employee findEmployee(final Long id) throws PersonNotFoundException, DaoException;
	
	/**
	 * List the employees by search name.
	 * 
	 * @param name to search.
	 * @return a list of employees by search name.
	 * @throws PersonNotFoundException when not found a person in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	List<Employee> listEmployeesByName(final String name) throws PersonNotFoundException, DaoException;
}
