package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.dao.EmployeeDAO;
import com.fvv.bookstore.dao.EmployeeDAOImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.exception.person.PersonValidationException;
import com.fvv.bookstore.util.Constants;

/**
 * Controller class for a Employee object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class EmployeeControllerImpl implements EmployeeController {
	
	private final EmployeeDAO employeeDao;
	
	/**
	 * Class constructor instantiating a new EmployeeDAOImpl object.
	 */
	public EmployeeControllerImpl() {
		this.employeeDao = new EmployeeDAOImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addEmployee(final Employee employee) 
			throws PersonValidationException, ControllerException {
		try {
			this.validateEmployee(employee);
			this.employeeDao.addEmployee(employee);
		} catch (DaoException e) {
			throw new ControllerException("Error to add a employee", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Employee> listEmployees() throws ControllerException {
		try {
			return this.employeeDao.listEmployees();
		} catch (DaoException e) {
			throw new ControllerException("Error to load the list", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEmployee(final Employee employee) 
			throws PersonValidationException, ControllerException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeEmployee(final Long id) throws ControllerException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee findEmployee(final Long id) 
			throws PersonNotFoundException, ControllerException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Validate if a field is empty.
	 * 
	 * @param employee of type Employee
	 * @throws PersonValidationException if a field is empty.
	 */
	private void validateEmployee(final Employee employee) throws PersonValidationException {
		StringBuilder sb = new StringBuilder();
		if(employee.getName().equals("")) {
			sb.append("Field name cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(employee.getEmail().equals("")) {
			sb.append("Field email cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(employee.getPhone().equals("")) {
			sb.append("Field phone cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(employee.getCpf().equals("")) {
			sb.append("Field CPF cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(employee.getPosition().equals("")) {
			sb.append("Field position cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(employee.getSalary() <= 0) {
			sb.append("Field salary cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);			
		}
		if(sb.length() > 0) {
			throw new PersonValidationException(sb.toString());
		}
	}
}