package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.bean.OrderItem;
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
	
	private final OrderItemDAO ordemItemDao;

	/**
	 * Class constructor instantiating a new OrderItemDAOImpl object.
	 */
	public OrderDAOImpl() {
		this.ordemItemDao = new OrderItemDAOImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addOrder(final Order order) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(
						SqlQueryEnum.ORDER_INSERT.getQuery(), Statement.RETURN_GENERATED_KEYS)
		) {	
			ps.setLong(1, order.getEmployee().getId());
			ps.setLong(2, order.getCustomer().getId());
			ps.setDouble(3, order.getOrderAmount());
			ps.execute();
			
			Long orderPK = this.getPrimaryKey(ps);
			order.setId(orderPK);
			
			for (OrderItem orderItem : order.getOrderItems()) {
				orderItem.setOrder(order);
			}
			
			this.ordemItemDao.addOrderItemInBatch(order.getOrderItems());
			
		} catch(SQLException e) {
			throw new DaoException("Error to add an order", e);
		} 
	}
	
	/**
	 * Gets the primary key from the database.
	 * 
	 * @param ps of PreparedStament type.
	 * @return the primary key generated.
	 * @throws SQLException when a problem in database happens.
	 */
	private Long getPrimaryKey(final PreparedStatement ps) throws SQLException {
		ResultSet rs =  ps.getGeneratedKeys();
		Long generatedKey = 0L;
		if (rs.next()) {
		    generatedKey = rs.getLong(1);
		}
		return generatedKey;
	}
}
