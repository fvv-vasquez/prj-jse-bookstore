package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return null;
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
