package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.fvv.bookstore.bean.Customer;
import com.fvv.bookstore.enums.SqlQueryEnum;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

/**
 * DAO Class of a Customer object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class CustomerDAOImpl implements CustomerDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addCustomer(Customer customer) throws DaoException {		
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.CUSTOMER_INSERT.getQuery())
		) {	
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPhone());
			ps.setString(4, customer.getCpf());
			ps.setString(5, this.convertListToString(customer.getProdPref()));
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to add a customer", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Customer> listCustomers() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCustomer(Customer customer) throws DaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeCustomer(Long id) throws DaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findCustomer(Long id) throws PersonNotFoundException, DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convert a List into a String.
	 * 
	 * @param customer of Customer type.
	 * @return a String of preferences products.
	 */
	private String convertListToString(final List<String> list) {
		String preferences = "";
		for(String pp : list) {
			preferences += pp + "|";
		}
		return preferences.substring(0, preferences.length()-1);
	}
}
