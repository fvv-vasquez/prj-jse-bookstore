package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fvv.bookstore.bean.Customer;
import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.bean.OrderItem;
import com.fvv.bookstore.enums.SqlQueryEnum;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderNotFoundException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

/**
 * DAO Class of an Order object, with main database operation.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class OrderDAOImpl implements OrderDAO {
	
	private final OrderItemDAO orderItemDao;

	/**
	 * Class constructor instantiating a new OrderItemDAOImpl object.
	 */
	public OrderDAOImpl() {
		this.orderItemDao = new OrderItemDAOImpl();
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
			
			final Long orderPK = this.getPrimaryKey(ps);
			order.setId(orderPK);
			
			for (OrderItem orderItem : order.getOrderItems()) {
				orderItem.setOrder(order);
			}
			
			this.orderItemDao.addOrderItemInBatch(order.getOrderItems());
			
		} catch(SQLException e) {
			throw new DaoException("Error to add an order", e);
		} 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> listTotalOrdersMonth(final Integer month, final Integer year) 
			throws DaoException, OrderNotFoundException {
		List<Order> orders = new ArrayList<>();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.ORDER_SELECT_MONTH.getQuery())
		) {
			ps.setInt(1, month);
			ps.setInt(2, year);
			try (ResultSet rs = ps.executeQuery()) {
				if(!rs.next()) {
					throw new OrderNotFoundException("Not found orders on the date " + month + "-" + year);
				} else {
					do {
						Order order = new Order();
						
						Employee employee = new Employee();
						employee.setId(rs.getLong("ord_emp_id"));
						employee.setName(rs.getString("emp_name"));
						
						Customer customer = new Customer();
						customer.setId(rs.getLong("ord_cus_id"));
						customer.setName(rs.getString("cus_name"));

						
						order.setEmployee(employee);
						order.setCustomer(customer);						
						order.setId(rs.getLong("ord_id"));
						order.setOrderAmount(rs.getDouble("ord_amount"));
						order.setCreationDate(new Date(rs.getTimestamp("ord_date").getTime()));
						orders.add(order);
					} while (rs.next());
				}
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find orders in the search date", e);
		} 
		return orders;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> listTotalSalesPerSeller(final Employee employee) 
			throws DaoException, PersonNotFoundException {
		List<Order> orders = new ArrayList<>();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.ORDER_SELECT_SELLER.getQuery())
		) {
			ps.setLong(1, employee.getId());
			try (ResultSet rs = ps.executeQuery()) {
				if(!rs.next()) {
					throw new PersonNotFoundException("Not found orders for the seller " + employee.getId());
				} else {
					do {
						Order order = new Order();
					
						employee.setId(rs.getLong("ord_emp_id"));
						employee.setName(rs.getString("emp_name"));
						
						Customer customer = new Customer();
						customer.setId(rs.getLong("ord_cus_id"));
						customer.setName(rs.getString("cus_name"));

						
						order.setEmployee(employee);
						order.setCustomer(customer);						
						order.setId(rs.getLong("ord_id"));
						order.setOrderAmount(rs.getDouble("ord_amount"));
						order.setCreationDate(new Date(rs.getTimestamp("ord_date").getTime()));
						orders.add(order);
					} while (rs.next());
				}
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find orders for the seller searched", e);
		} 
		return orders;
	}

	/**
	 * Gets the primary key from the database.
	 * 
	 * @param ps of PreparedStatement type.
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
