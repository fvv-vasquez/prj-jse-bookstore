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
			ps.setDouble(2, laptop.getUnitPrice());
			ps.setInt(3, laptop.getWarranty());
			ps.setInt(4, laptop.getRamSize());
			ps.setDouble(5, laptop.getHdSize());
			ps.setString(6, laptop.getProcessor());
			ps.setInt(7, laptop.getStockQty());
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
				laptop.setUnitPrice(rs.getDouble("pc_unit_price"));
				laptop.setWarranty(rs.getInt("pc_warranty"));
				laptop.setRamSize(rs.getInt("pc_ram_size"));
				laptop.setHdSize(rs.getDouble("pc_hd_size"));
				laptop.setProcessor(rs.getString("pc_processor"));
				laptop.setStockQty(rs.getInt("pc_stock_qty"));
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
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.LAPTOP_UPDATE.getQuery())
		) {	
			ps.setString(1, laptop.getBrand());
			ps.setDouble(2, laptop.getUnitPrice());
			ps.setInt(3, laptop.getWarranty());
			ps.setInt(4, laptop.getRamSize());
			ps.setDouble(5, laptop.getHdSize());
			ps.setString(6, laptop.getProcessor());
			ps.setInt(7, laptop.getStockQty());
			ps.setLong(8, laptop.getId());
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to update a laptop", e);
		} 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeLaptop(final Long id) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.LAPTOP_DELETE.getQuery())
		) {	
			ps.setLong(1, id);
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to delete a laptop", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Laptop findLaptop(final Long id) throws HardwareNotFoundException, DaoException {
		Laptop laptop = new Laptop();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(
						SqlQueryEnum.LAPTOP_SELECT_ID.getQuery())
		) {	
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {			
				if(!rs.next()) {
					throw new HardwareNotFoundException("Laptop with ID " + id + " not found");
				} else {
					do {
						this.populateLaptopFromDatabase(laptop, rs);
					} while (rs.next());
				}
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find a laptop", e);
		} 
		return laptop;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Laptop findLaptopByBrand(final String brand) throws HardwareNotFoundException, DaoException {
		Laptop laptop = new Laptop();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(
						SqlQueryEnum.LAPTOP_SELECT_BRAND.getQuery())
		) {	
			ps.setString(1, brand);
			try (ResultSet rs = ps.executeQuery()) {			
				if(!rs.next()) {
					throw new HardwareNotFoundException("Laptop with brand " + brand + " not found");
				} else {
					do {
						this.populateLaptopFromDatabase(laptop, rs);
					} while (rs.next());
				}
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find a laptop", e);
		} 
		return laptop;
	}
	
	/**
	 * Populate a laptop from database.
	 * 
	 * @param laptop of Laptop type.
	 * @param rs of ResultSet type.
	 * @return a laptop.
	 * @throws DaoException when a problem in database happens.
	 */
	private Laptop populateLaptopFromDatabase(final Laptop laptop, final ResultSet rs) throws DaoException {
		try {
			laptop.setId(rs.getLong("pc_id"));
			laptop.setBrand(rs.getString("pc_brand"));
			laptop.setUnitPrice(rs.getDouble("pc_unit_price"));
			laptop.setWarranty(rs.getInt("pc_warranty"));
			laptop.setRamSize(rs.getInt("pc_ram_size"));
			laptop.setHdSize(rs.getDouble("pc_hd_size"));
			laptop.setProcessor(rs.getString("pc_processor"));
			laptop.setStockQty(rs.getInt("pc_stock_qty"));
			laptop.setModificationDate(new Date(rs.getTimestamp(
					"pc_modification_date").getTime()));
		} catch(SQLException e) {
			throw new DaoException("Error to find a laptop", e);
		} 
		return laptop;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reduceStockItem(final Laptop laptop, final Integer quantityToReduce) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.LAPTOP_REDUCE_STOCK.getQuery())
		) {	
			ps.setInt(1, quantityToReduce);	
			ps.setLong(2, laptop.getId());		
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to update stock quantity of a laptop", e);
		} 
	}
}
