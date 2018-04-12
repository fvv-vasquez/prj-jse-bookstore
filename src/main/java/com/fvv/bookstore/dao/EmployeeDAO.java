package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

/**
 * DAO Interface of a Employee object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface EmployeeDAO {

	/**
	 * Add a employee at the bookstore in the database.
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
	 * Update a employee already added in the database.
	 * 
	 * @param employee of Employee type.
	 * @throws DaoException when a problem in database happens.
	 */
	void updateEmployee(final Employee employee) throws DaoException;

	/**
	 * Delete a employee from the bookstore in the database.
	 * 
	 * @param id of Long type.
	 * @throws DaoException when a problem in database happens.
	 */
	void removeEmployee(final Long id) throws DaoException;
	
	/**
	 * Search a employee in the database.
	 * 
	 * @param id of a Long type.
	 * @return a Employee.
	 * @throws PersonNotFoundException when not found a person in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	Employee findEmployee(final Long id) throws PersonNotFoundException, DaoException;
}
