package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderNotFoundException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

/**
 * DAO Interface of an Order object, with main database operation.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface OrderDAO {

	/**
	 * Add an order at the bookstore in the database.
	 * 
	 * @param order of Order type.
	 * @throws DaoException when a problem in database happens.
	 */
	void addOrder(final Order order) throws DaoException;
	
	/**
	 * Lists all the order by search month.
	 * 
	 * @param month to search.
	 * @param year to search.
	 * @return a list of orders.
	 * @throws DaoException when a problem in database happens.
	 * @throws OrderNotFoundException when not found an order in the database.
	 */
	List<Order> listTotalOrdersMonth(final Integer month, final Integer year) 
			throws DaoException, OrderNotFoundException;
	
	/**
	 * Lists all the sales per seller.
	 * 
	 * @param employee to search its sales.
	 * @return a list of orders.
	 * @throws DaoException when a problem in database happens.
	 * @throws PersonNotFoundException when not found a person in the database.
	 */
	List<Order> listTotalSalesPerSeller(final Employee employee) 
			throws DaoException, PersonNotFoundException;
	
	/**
	 * Search an order in the database.
	 * 
	 * @param id to search.
	 * @return an order.
	 * @throws DaoException when a problem in database happens.
	 * @throws OrderNotFoundException when not found an order in the database.
	 */
	Order listOrderByOrderId(final Long id) throws OrderNotFoundException, DaoException;
}
