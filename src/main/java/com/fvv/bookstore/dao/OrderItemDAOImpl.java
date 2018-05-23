package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.bean.Cellphone;
import com.fvv.bookstore.bean.OrderItem;
import com.fvv.bookstore.bean.ShowDvd;
import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.bean.Laptop;
import com.fvv.bookstore.bean.Magazine;
import com.fvv.bookstore.bean.MovieDvd;
import com.fvv.bookstore.bean.Order;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<OrderItem> findBookItemsByOrder(final Long idOrder) throws DaoException {
		List<OrderItem> orderItems = new ArrayList<>();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.ORDER_ITEM_BOOK_SELECT_ORDER_ID.getQuery())
		) {
			ps.setLong(1, idOrder);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Book book = new Book();
					book.setId(rs.getLong("ord_ite_book_book_id"));
					book.setTitle(rs.getString("book_title"));
					book.setUnitPrice(rs.getDouble("book_unit_price"));
					
					OrderItem bookItem = new OrderItem();
					bookItem.setProduct(book);
					
					Order order = new Order();
					order.setId(idOrder);
					bookItem.setOrder(order);
					
					bookItem.setQuantity(rs.getInt("ord_ite_book_quantity"));
					bookItem.setItemAmount(rs.getDouble("ord_ite_book_amount"));
					
					orderItems.add(bookItem);
				} 
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find an order", e);
		} 
		return orderItems;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<OrderItem> findCellphoneItemsByOrder(final Long idOrder) throws DaoException {
		List<OrderItem> orderItems = new ArrayList<>();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.ORDER_ITEM_CELLPHONE_SELECT_ORDER_ID.getQuery())
		) {
			ps.setLong(1, idOrder);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Cellphone cellphone = new Cellphone();
					cellphone.setId(rs.getLong("ord_ite_cel_cel_id"));
					cellphone.setBrand(rs.getString("cel_brand"));
					cellphone.setUnitPrice(rs.getDouble("cel_unit_price"));
					
					OrderItem celItem = new OrderItem();
					celItem.setProduct(cellphone);
					
					Order order = new Order();
					order.setId(idOrder);
					celItem.setOrder(order);
					
					celItem.setQuantity(rs.getInt("ord_ite_cel_quantity"));
					celItem.setItemAmount(rs.getDouble("ord_ite_cel_amount"));
					
					orderItems.add(celItem);
				} 
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find an order", e);
		} 
		return orderItems;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<OrderItem> findDvdItemsByOrder(final Long idOrder) throws DaoException {
		List<OrderItem> orderItems = new ArrayList<>();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.ORDER_ITEM_DVD_SELECT_ORDER_ID.getQuery())
		) {
			ps.setLong(1, idOrder);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Dvd dvd;
					if(rs.getString("dvd_movie_director") != null) {
						MovieDvd dvdMovie = new MovieDvd();
						dvd = dvdMovie;
					} else {
						ShowDvd dvdShow = new ShowDvd();
						dvd = dvdShow;
					}
					
					dvd.setId(rs.getLong("ord_ite_dvd_dvd_id"));
					dvd.setTitle(rs.getString("dvd_title"));
					dvd.setUnitPrice(rs.getDouble("dvd_unit_price"));
					
					OrderItem dvdItem = new OrderItem();
					dvdItem.setProduct(dvd);
					
					Order order = new Order();
					order.setId(idOrder);
					dvdItem.setOrder(order);
					
					dvdItem.setQuantity(rs.getInt("ord_ite_dvd_quantity"));
					dvdItem.setItemAmount(rs.getDouble("ord_ite_dvd_amount"));
					
					orderItems.add(dvdItem);
				} 
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find an order", e);
		} 
		return orderItems;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<OrderItem> findLaptopItemsByOrder(final Long idOrder) throws DaoException {
		List<OrderItem> orderItems = new ArrayList<>();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.ORDER_ITEM_LAPTOP_SELECT_ORDER_ID.getQuery())
		) {
			ps.setLong(1, idOrder);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Laptop laptop = new Laptop();
					laptop.setId(rs.getLong("ord_ite_pc_pc_id"));
					laptop.setBrand(rs.getString("pc_brand"));
					laptop.setUnitPrice(rs.getDouble("pc_unit_price"));
					
					OrderItem pcItem = new OrderItem();
					pcItem.setProduct(laptop);
					
					Order order = new Order();
					order.setId(idOrder);
					pcItem.setOrder(order);
					
					pcItem.setQuantity(rs.getInt("ord_ite_pc_quantity"));
					pcItem.setItemAmount(rs.getDouble("ord_ite_pc_amount"));
					
					orderItems.add(pcItem);
				}
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find an order", e);
		} 
		return orderItems;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<OrderItem> findMagazineItemsByOrder(final Long idOrder) throws DaoException {
		List<OrderItem> orderItems = new ArrayList<>();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.ORDER_ITEM_MAGAZINE_SELECT_ORDER_ID.getQuery())
		) {
			ps.setLong(1, idOrder);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Magazine magazine = new Magazine();
					magazine.setId(rs.getLong("ord_ite_mag_mag_id"));
					magazine.setName(rs.getString("mag_name"));
					magazine.setUnitPrice(rs.getDouble("mag_unit_price"));
					
					OrderItem magazineItem = new OrderItem();
					magazineItem.setProduct(magazine);
					
					Order order = new Order();
					order.setId(idOrder);
					magazineItem.setOrder(order);
					
					magazineItem.setQuantity(rs.getInt("ord_ite_mag_quantity"));
					magazineItem.setItemAmount(rs.getDouble("ord_ite_mag_amount"));
					
					orderItems.add(magazineItem);
				}
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find an order", e);
		} 
		return orderItems;
	}
}
