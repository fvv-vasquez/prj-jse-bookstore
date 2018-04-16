package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.OrderItem;
import com.fvv.bookstore.exception.DaoException;

/**
 * DAO Interface of an Order Item object, with main database operation.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface OrderItemDAO {
	
	/**
	 * Add order items at the bookstore in the database.
	 * 
	 * @param ordemItems of List<OrderItem> type.
	 * @throws DaoException when a problem in database happens.
	 */
	void addOrderItemInBatch(final List<OrderItem> orderItems) throws DaoException;
}
