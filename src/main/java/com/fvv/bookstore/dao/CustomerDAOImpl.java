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
	public void addCustomer(final Customer customer) throws DaoException {		
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
	public void updateCustomer(final Customer customer) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.CUSTOMER_UPDATE.getQuery())
		) {	
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPhone());
			ps.setString(4, customer.getCpf());
			ps.setString(5, StringUtil.convertListToString(customer.getProdPref()));
			ps.setLong(6, customer.getId());
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to update a customer", e);
		} 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeCustomer(final Long id) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.CUSTOMER_DELETE.getQuery())
		) {	
			ps.setLong(1, id);
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to delete a customer", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findCustomer(final Long id) throws PersonNotFoundException, DaoException {
		Customer customer = new Customer();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(
						SqlQueryEnum.CUSTOMER_SELECT_ID.getQuery())
		) {	
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {			
				if(!rs.next()) {
					throw new PersonNotFoundException("Customer with ID " + id + " not found");
				} else {
					do {
						customer.setId(rs.getLong("cus_id"));
						customer.setName(rs.getString("cus_name"));
						customer.setEmail(rs.getString("cus_email"));
						customer.setPhone(rs.getString("cus_phone"));
						customer.setCpf(rs.getString("cus_cpf"));
						customer.setProdPref(StringUtil.convertStringToList(
								rs.getString("cus_prod_pref"), Constants.PIPE));
						customer.setModificationDate(new Date(rs.getTimestamp(
								"cus_modification_date").getTime()));
					} while (rs.next());
				}
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find a customer", e);
		} 
		return customer;
	}
}
