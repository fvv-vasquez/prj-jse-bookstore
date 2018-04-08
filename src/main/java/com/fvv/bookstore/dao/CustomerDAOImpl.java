package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fvv.bookstore.bean.Customer;
import com.fvv.bookstore.enums.SqlQueryEnum;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.util.Constants;
import com.fvv.bookstore.util.StringUtil;

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
			ps.setString(5, StringUtil.convertListToString(customer.getProdPref()));
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
		List<Customer> customers = new ArrayList<>();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.CUSTOMER_SELECT_ALL.getQuery());
				ResultSet rs = ps.executeQuery()
		) {	
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getLong("cus_id"));
				customer.setName(rs.getString("cus_name"));
				customer.setEmail(rs.getString("cus_email"));
				customer.setPhone(rs.getString("cus_phone"));
				customer.setCpf(rs.getString("cus_cpf"));
				customer.setProdPref(StringUtil.convertStringToList(
						rs.getString("cus_prod_pref"), Constants.PIPE));
				customer.setModificationDate(new Date(rs.getTimestamp(
						"cus_modification_date").getTime()));
				customers.add(customer);
			}
		} catch(SQLException e) {
			throw new DaoException("Error to load the list", e);
		} 
		return customers;
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
}
