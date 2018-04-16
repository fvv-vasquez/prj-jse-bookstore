package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.enums.SqlQueryEnum;
import com.fvv.bookstore.exception.DaoException;

/**
 * DAO Class of an Order object, with main database operation.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class OrderDAOImpl implements OrderDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addOrder(final Order order) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.ORDER_INSERT.getQuery())
		) {	
			ps.setLong(1, order.getEmployee().getId());
			ps.setLong(2, order.getCustomer().getId());
			ps.setDouble(3, order.getOrderAmount());
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to add an order", e);
		} 
	}
}
