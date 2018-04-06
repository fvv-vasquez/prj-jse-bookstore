package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fvv.bookstore.bean.Laptop;
import com.fvv.bookstore.enums.SqlQueryEnum;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.hardware.HardwareNotFoundException;

/**
 * DAO Class of a Laptop object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class LaptopDAOImpl implements LaptopDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addLaptop(final Laptop laptop) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.LAPTOP_INSERT.getQuery())
		) {	
			ps.setString(1, laptop.getBrand());
			ps.setDouble(2, laptop.getPrice());
			ps.setInt(3, laptop.getWarranty());
			ps.setInt(4, laptop.getRamSize());
			ps.setDouble(5, laptop.getHdSize());			
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to add a laptop", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Laptop> listLaptops() throws DaoException {
		List<Laptop> laptops = new ArrayList<>();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.LAPTOP_SELECT_ALL.getQuery());
				ResultSet rs = ps.executeQuery()
		) {	
			while(rs.next()) {
				Laptop laptop = new Laptop();
				laptop.setId(rs.getLong("pc_id"));
				laptop.setBrand(rs.getString("pc_brand"));
				laptop.setPrice(rs.getDouble("pc_price"));
				laptop.setWarranty(rs.getInt("pc_warranty"));
				laptop.setRamSize(rs.getInt("pc_ram_size"));
				laptop.setHdSize(rs.getDouble("pc_hd_size"));
				laptop.setModificationDate(new Date(rs.getTimestamp(
						"pc_modification_date").getTime()));
				laptops.add(laptop);
			}
		} catch(SQLException e) {
			throw new DaoException("Error to load the list", e);
		} 
		return laptops;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateLaptop(final Laptop laptop) throws DaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeLaptop(final Long id) throws DaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Laptop findLaptop(final Long id) throws HardwareNotFoundException, DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
