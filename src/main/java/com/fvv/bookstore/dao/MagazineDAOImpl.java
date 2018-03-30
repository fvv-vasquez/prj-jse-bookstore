package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Magazine> magazines = new ArrayList<>();
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM tb_magazine";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Magazine magazine = new Magazine();
				magazine.setId(rs.getLong("mag_id"));
				magazine.setName(rs.getString("mag_name"));
				magazine.setEditionNumber(rs.getInt("mag_edition_number"));
				magazine.setGenre(rs.getString("mag_genre"));
				magazine.setPublicationDate(rs.getDate("mag_publication_date"));
				magazine.setPublisher(rs.getString("mag_publisher"));
				magazine.setPrice(rs.getDouble("mag_price"));
				magazine.setModificationDate(new Date(rs.getTimestamp(
						"mag_modification_date").getTime()));
				magazines.add(magazine);
			}
		} catch(SQLException e) {
			throw new DaoException("Error to load the list", e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to load the list", e);
			}
		}
		return magazines;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean updateMagazine(Magazine magazine) throws DaoException {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "UPDATE tb_magazine SET mag_name = ?, mag_edition_number = ?, "
					+ "mag_genre = ?, mag_publication_date = ?, mag_publisher = ?, "
					+ "mag_price = ?, mag_modification_date = now() "
					+ "WHERE mag_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, magazine.getName());
			ps.setInt(2, magazine.getEditionNumber());
			ps.setString(3, magazine.getGenre());
			ps.setDate(4, new Date(magazine.getPublicationDate().getTime()));
			ps.setString(5, magazine.getPublisher());
			ps.setDouble(6, magazine.getPrice());
			ps.setLong(7, magazine.getId());
			ps.execute();
			return true;
		} catch(SQLException e) {
			throw new DaoException("Error to update a magazine", e);
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to update a magazine", e);
			}
		}
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
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs;
		Magazine magazine = new Magazine();
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM tb_magazine WHERE mag_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			if(!rs.next()) {
				throw new MagazineNotFoundException("Magazine with ID " + id + " not found");
			} else {
				do {
					magazine.setId(rs.getLong("mag_id"));
					magazine.setName(rs.getString("mag_name"));
					magazine.setEditionNumber(rs.getInt("mag_edition_number"));
					magazine.setGenre(rs.getString("mag_genre"));
					magazine.setPublicationDate(rs.getDate("mag_publication_date"));
					magazine.setPublisher(rs.getString("mag_publisher"));
					magazine.setPrice(rs.getDouble("mag_price"));
					magazine.setModificationDate(new Date(rs.getTimestamp(
							"mag_modification_date").getTime()));
				} while (rs.next());
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find a magazine", e);
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to find a magazine", e);
			}
		}
		return magazine;
	}
}
