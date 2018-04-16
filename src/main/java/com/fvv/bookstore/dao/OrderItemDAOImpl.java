package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.fvv.bookstore.bean.OrderItem;
import com.fvv.bookstore.enums.SqlQueryEnum;
import com.fvv.bookstore.exception.DaoException;

/**
 * DAO Class of an Order Item object, with main database operation.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class OrderItemDAOImpl implements OrderItemDAO {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addOrderItemInBatch(final List<OrderItem> orderItems) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(
						SqlQueryEnum.ORDER_ITEM_INSERT.getQuery())
		) {	
			for(OrderItem ordItem : orderItems) {
				ps.setLong(1, ordItem.getOrder().getId());
				ps.setLong(2, ordItem.getProduct().getId());
				ps.setInt(3, ordItem.getQuantity());
				ps.setDouble(4, ordItem.getItemAmount());
				ps.execute();
			}				
		} catch(SQLException e) {
			throw new DaoException("Error to add an order item", e);
		}
	}
}
