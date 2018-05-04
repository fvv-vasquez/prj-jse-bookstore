package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.OrderItem;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderNotFoundException;

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
	 * Add order items in batch at the bookstore in the database.
	 * 
	 * @param orderItems of List<OrderItem> type.
	 * @throws DaoException when a problem in database happens.
	 */
	void addOrderItemInBatch(final List<OrderItem> orderItems) throws DaoException;
	
	/**
	 * Search a book item in the database by the order.
	 * 
	 * @param idOrder to search.
	 * @return a list of order item book.
	 * @throws DaoException when a problem in database happens.
	 * @throws OrderNotFoundException when not found an order in the database.
	 */
	List<OrderItem> findBookItemsByOrder(final Long idOrder) throws DaoException, OrderNotFoundException;
	
	/**
	 * Search a cellphone item in the database by the order.
	 * 
	 * @param idOrder to search.
	 * @return a list of order item cellphone.
	 * @throws DaoException when a problem in database happens.
	 * @throws OrderNotFoundException when not found an order in the database.
	 */
	List<OrderItem> findCellphoneItemsByOrder(final Long idOrder) throws DaoException, OrderNotFoundException;
	
	/**
	 * Search a dvd item in the database by the order.
	 * 
	 * @param idOrder to search.
	 * @return a list of order item dvd.
	 * @throws DaoException when a problem in database happens.
	 * @throws OrderNotFoundException when not found an order in the database.
	 */
	List<OrderItem> findDvdtemsByOrder(final Long idOrder) throws DaoException, OrderNotFoundException;
	
	/**
	 * Search a laptop item in the database by the order.
	 * 
	 * @param idOrder to search.
	 * @return a list of order item laptop.
	 * @throws DaoException when a problem in database happens.
	 * @throws OrderNotFoundException when not found an order in the database.
	 */
	List<OrderItem> findLaptopItemsByOrder(final Long idOrder) throws DaoException, OrderNotFoundException;
	
	/**
	 * Search a magazine item in the database by the order.
	 * 
	 * @param idOrder to search.
	 * @return a list of order item magazine.
	 * @throws DaoException when a problem in database happens.
	 * @throws OrderNotFoundException when not found an order in the database.
	 */
	List<OrderItem> findMagazienItemsByOrder(final Long idOrder) throws DaoException, OrderNotFoundException;
}
