package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.bean.MovieDvd;
import com.fvv.bookstore.bean.ShowDvd;
import com.fvv.bookstore.enums.SqlQueryEnum;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.dvd.DvdNotFoundException;

/**
 * DAO Class of a Magazine object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 1 de abr de 2018</p>	
 * @version 1.0 	
 *
 */
public class DvdDAOImpl implements DvdDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addDvd(final Dvd dvd) throws DaoException {
		String sql;
		String person;
		if (dvd instanceof MovieDvd) {
			sql = SqlQueryEnum.DVD_MOVIE_INSERT.getQuery();
			person = ((MovieDvd) dvd).getDirector();
		} else {
			sql = SqlQueryEnum.DVD_SHOW_INSERT.getQuery();
			person = ((ShowDvd) dvd).getArtist();
		}
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)
		) {
			ps.setString(1, dvd.getTitle());
			ps.setInt(2, dvd.getTotalDuration());
			ps.setDouble(3, dvd.getPrice());
			ps.setString(4, dvd.getGenre());
			ps.setInt(5, dvd.getReleaseYear());
			ps.setInt(6, dvd.getCode());
			ps.setString(7, person);
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to add a dvd", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Dvd> listDvds() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateDvd(final Dvd dvd) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeDvd(final Long id) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Dvd findDvd(final Long id) throws DvdNotFoundException, DaoException {
		Dvd dvd = null;
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.DVD_SELECT_ID.getQuery())
		) {	
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {			
				if(!rs.next()) {
					throw new DvdNotFoundException("DVD with ID " + id + " not found");
				} else {
					do {
						if(!rs.getString("dvd_movie_director").equals("")) {
							MovieDvd dvdMovie = new MovieDvd();
							dvdMovie.setDirector(rs.getString("dvd_movie_director"));
							dvd = dvdMovie;
						} else {
							ShowDvd dvdShow = new ShowDvd();
							dvdShow.setArtist(rs.getString("dvd_show_artist"));
							dvd = dvdShow;
						}
						dvd.setTitle(rs.getString("dvd_title"));
						dvd.setTotalDuration(rs.getInt("dvd_total_duration"));
						dvd.setPrice(rs.getDouble("dvd_price"));
						dvd.setGenre(rs.getString("dvd_genre"));
						dvd.setReleaseYear(rs.getInt("dvd_release_year"));
						dvd.setCode(rs.getInt("dvd_code"));
						dvd.setModificationDate(new Date(rs.getTimestamp(
								"dvd_modification_date").getTime()));
					} while (rs.next());
				}
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find a dvd", e);
		} 
		return dvd;
	}	
}