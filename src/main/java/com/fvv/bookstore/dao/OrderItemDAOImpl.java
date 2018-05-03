package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.bean.Cellphone;
import com.fvv.bookstore.bean.OrderItem;
import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.bean.Laptop;
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
		String sql;
		for(OrderItem orderItem : orderItems) {
			if (orderItem.getProduct() instanceof Book) {
				sql = SqlQueryEnum.ORDER_ITEM_BOOK_INSERT.getQuery();
			} else if (orderItem.getProduct() instanceof Cellphone){
				sql = SqlQueryEnum.ORDER_ITEM_CELLPHONE_INSERT.getQuery();
			} else if (orderItem.getProduct() instanceof Dvd) {
				sql = SqlQueryEnum.ORDER_ITEM_DVD_INSERT.getQuery();
			} else if (orderItem.getProduct() instanceof Laptop) {
				sql = SqlQueryEnum.ORDER_ITEM_LAPTOP_INSERT.getQuery();
			} else {
				sql = SqlQueryEnum.ORDER_ITEM_MAGAZINE_INSERT.getQuery();
			}
			try (
					Connection conn = ConnectionFactory.getConnection(); 
					PreparedStatement ps = conn.prepareStatement(sql)
			) {	
				ps.setLong(1, orderItem.getOrder().getId());
				ps.setLong(2, orderItem.getProduct().getId());
				ps.setInt(3, orderItem.getQuantity());
				ps.setDouble(4, orderItem.getItemAmount());
				ps.execute();
			} catch(SQLException e) {
				throw new DaoException("Error to add an order item", e);
			}
		}		
	}
}
