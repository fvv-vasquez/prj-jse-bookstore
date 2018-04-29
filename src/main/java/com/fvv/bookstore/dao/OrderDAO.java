package com.fvv.bookstore.dao;

import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.exception.DaoException;

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
}
