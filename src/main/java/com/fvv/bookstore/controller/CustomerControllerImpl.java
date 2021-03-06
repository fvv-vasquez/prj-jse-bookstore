package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Customer;
import com.fvv.bookstore.comparator.CustomerSort;
import com.fvv.bookstore.dao.CustomerDAO;
import com.fvv.bookstore.dao.CustomerDAOImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.exception.person.PersonValidationException;
import com.fvv.bookstore.util.Constants;

/**
 * Controller class for a Customer object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class CustomerControllerImpl implements CustomerController {
	
	private final CustomerDAO customerDao;
	
	/**
	 * Class constructor instantiating a new CustomerDAOImpl object.
	 */
	public CustomerControllerImpl() {
		this.customerDao = new CustomerDAOImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addCustomer(final Customer customer) throws 
		PersonValidationException, ControllerException {
		try {
			this.validateCustomer(customer);
			this.customerDao.addCustomer(customer);
		} catch (DaoException e) {
			throw new ControllerException("Error to add a customer", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Customer> listCustomers() throws ControllerException {
		try {
			return this.customerDao.listCustomers();
		} catch (DaoException e) {
			throw new ControllerException("Error to load the list", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCustomer(final Customer customer) throws 
		PersonValidationException, ControllerException {
		try {
			this.validateCustomer(customer);
			this.customerDao.updateCustomer(customer);
		} catch (DaoException e) {
			throw new ControllerException("Error to update a customer", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeCustomer(final Long id) throws ControllerException {
		try {
			this.customerDao.removeCustomer(id);
		} catch (DaoException e) {
			throw new ControllerException("Error to delete a customer", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findCustomer(final Long id) throws PersonNotFoundException, ControllerException {
		try {
			return this.customerDao.findCustomer(id);
		} catch (DaoException e) {
			throw new ControllerException("Error to find a customer", e);
		}
	}

	/**
	 * Validate if a field is empty.
	 * 
	 * @param customer of type Customer
	 * @throws PersonValidationException if a field is empty.
	 */
	private void validateCustomer(final Customer customer) throws PersonValidationException {
		StringBuilder sb = new StringBuilder();
		if(customer.getName().equals("")) {
			sb.append("Field name cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(customer.getEmail().equals("")) {
			sb.append("Field email cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(customer.getPhone().equals("")) {
			sb.append("Field phone cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(customer.getCpf().equals("")) {
			sb.append("Field CPF cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(sb.length() > 0) {
			throw new PersonValidationException(sb.toString());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Customer> listCustomersByName(final String name) throws PersonNotFoundException, ControllerException {
		try {
			List<Customer> customers = this.customerDao.listCustomersByName(name);
			customers.sort(new CustomerSort());
			return customers;
		} catch (DaoException e) {
			throw new ControllerException("Error to find a customer", e);
		}
	}
}
