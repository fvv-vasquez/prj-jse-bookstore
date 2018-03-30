package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.fvv.bookstore.bean.Magazine;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.magazine.MagazineNotFoundException;

/**
 * DAO Class of a Magazine object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 30 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public class MagazineDAOImpl implements MagazineDAO {

	/**
	 * {@inheritDoc}
	 */
	public boolean addMagazine(Magazine magazine) throws DaoException {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "INSERT INTO tb_magazine (mag_name, mag_edition_number, mag_genre, "
					+ "mag_publication_date, mag_publisher, mag_price, mag_modification_date) "
					+ "VALUES (?, ?, ?, ?, ?, ?, now())";			
			ps = conn.prepareStatement(sql);
			ps.setString(1, magazine.getName());
			ps.setInt(2, magazine.getEditionNumber());
			ps.setString(3, magazine.getGenre());
			ps.setDate(4, new Date(magazine.getPublicationDate().getTime()));
			ps.setString(5, magazine.getPublisher());
			ps.setDouble(6, magazine.getPrice());
			ps.execute();
			return true;
		} catch(SQLException e) {
			throw new DaoException("Error to add a magazine", e);
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to add a magazine", e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Magazine> listMagazines() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean updateMagazine(Magazine magazine) throws DaoException {
		return false;
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public void removeMagazine(Long id) throws DaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public Magazine findMagazine(Long id) throws MagazineNotFoundException, DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
