package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fvv.bookstore.bean.Cellphone;
import com.fvv.bookstore.enums.SqlQueryEnum;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.hardware.HardwareNotFoundException;

/**
 * DAO Class of a Cellphone object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class CellphoneDAOImpl implements CellphoneDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addCellphone(final Cellphone cellphone) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.CELLPHONE_INSERT.getQuery())
		) {	
			ps.setString(1, cellphone.getBrand());
			ps.setDouble(2, cellphone.getUnitPrice());
			ps.setInt(3, cellphone.getWarranty());
			ps.setInt(4, cellphone.getStorageMemory());
			ps.setInt(5, cellphone.getCamPixels());		
			ps.setInt(6, cellphone.getStockQty());
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to add a cellphone", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Cellphone> listCellphones() throws DaoException {
		List<Cellphone> cellphones = new ArrayList<>();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.CELLPHONE_SELECT_ALL.getQuery());
				ResultSet rs = ps.executeQuery()
		) {	
			while(rs.next()) {
				Cellphone cellphone = new Cellphone();
				cellphone.setId(rs.getLong("cel_id"));
				cellphone.setBrand(rs.getString("cel_brand"));
				cellphone.setUnitPrice(rs.getDouble("cel_unit_price"));
				cellphone.setWarranty(rs.getInt("cel_warranty"));
				cellphone.setStorageMemory(rs.getInt("cel_storage_memory"));
				cellphone.setCamPixels(rs.getInt("cel_camera_pixels"));
				cellphone.setStockQty(rs.getInt("cel_stock_qty"));
				cellphone.setModificationDate(new Date(rs.getTimestamp(
						"cel_modification_date").getTime()));
				cellphones.add(cellphone);
			}
		} catch(SQLException e) {
			throw new DaoException("Error to load the list", e);
		} 
		return cellphones;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCellphone(final Cellphone cellphone) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.CELLPHONE_UPDATE.getQuery())
		) {	
			ps.setString(1, cellphone.getBrand());
			ps.setDouble(2, cellphone.getUnitPrice());
			ps.setInt(3, cellphone.getWarranty());
			ps.setInt(4, cellphone.getStorageMemory());
			ps.setInt(5, cellphone.getCamPixels());
			ps.setInt(6, cellphone.getStockQty());
			ps.setLong(7, cellphone.getId());
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to update a cellphone", e);
		} 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeCellphone(final Long id) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.CELLPHONE_DELETE.getQuery())
		) {	
			ps.setLong(1, id);
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to delete a cellphone", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Cellphone findCellphone(final Long id) throws HardwareNotFoundException, DaoException {
		Cellphone cellphone = null;
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(
						SqlQueryEnum.CELLPHONE_SELECT_ID.getQuery())
		) {	
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {			
				if(!rs.next()) {
					throw new HardwareNotFoundException("Cellphone with ID " + id + " not found");
				} else {
					do {
						cellphone = this.populateCellphoneFromDatabase(rs);
					} while (rs.next());
				}
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find a cellphone", e);
		} 
		return cellphone;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Cellphone findCellphoneByBrand(final String brand) throws HardwareNotFoundException, DaoException {
		Cellphone cellphone = null;
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(
						SqlQueryEnum.CELLPHONE_SELECT_BRAND.getQuery())
		) {	
			ps.setString(1, brand);
			try (ResultSet rs = ps.executeQuery()) {			
				if(!rs.next()) {
					throw new HardwareNotFoundException("Cellphone with brand " + brand + " not found");
				} else {
					do {
						cellphone = this.populateCellphoneFromDatabase(rs);
					} while (rs.next());
				}
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find a cellphone", e);
		} 
		return cellphone;
	}
	
	/**
	 * Populate a cellphone fron database.
	 * 
	 * @param rs of ResultSet type.
	 * @return a cellphone
	 * @throws DaoException when a problem in database happens.
	 */
	private Cellphone populateCellphoneFromDatabase(final ResultSet rs) throws DaoException {
		Cellphone cellphone = new Cellphone();
		try {
			cellphone.setId(rs.getLong("cel_id"));
			cellphone.setBrand(rs.getString("cel_brand"));
			cellphone.setUnitPrice(rs.getDouble("cel_unit_price"));
			cellphone.setWarranty(rs.getInt("cel_warranty"));
			cellphone.setStorageMemory(rs.getInt("cel_storage_memory"));
			cellphone.setCamPixels(rs.getInt("cel_camera_pixels"));
			cellphone.setStockQty(rs.getInt("cel_stock_qty"));
			cellphone.setModificationDate(new Date(rs.getTimestamp(
					"cel_modification_date").getTime()));
		} catch(SQLException e) {
			throw new DaoException("Error to find a cellphone", e);
		} 
		return cellphone;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reduceStockItem(final Cellphone cellphone, final Integer quantityToReduce) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.CELLPHONE_REDUCE_STOCK.getQuery())
		) {	
			ps.setInt(1, quantityToReduce);	
			ps.setLong(2, cellphone.getId());		
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to update stock quantity of a cellphone", e);
		} 
	}
}
