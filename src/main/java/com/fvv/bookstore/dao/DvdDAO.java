package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.bean.MovieDvd;
import com.fvv.bookstore.bean.ShowDvd;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.dvd.DvdNotFoundException;

/**
 * DAO Interface of a Dvd object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public interface DvdDAO {

	/**
	 * Add a dvd at the bookstore in the database.
	 * 
	 * @param dvd of Dvd type.
	 * @throws DaoException when a problem in database happens.
	 */
	void addDvd(final Dvd dvd) throws DaoException;

	/**
	 * Lists all the shows' dvds in the database.
	 * 
	 * @return a list of shows' dvds.
	 * @throws DaoException when a problem in database happens.
	 */
	List<ShowDvd> listDvdsShow() throws DaoException;
	
	/**
	 * Lists all the movies' dvds in the database.
	 * 
	 * @return a list of movies' dvds.
	 * @throws DaoException when a problem in database happens.
	 */
	List<MovieDvd> listDvdsMovie() throws DaoException;

	/**
	 * Update a Dvd already added in the database.
	 * 
	 * @param dvd of Dvd type.
	 * @throws DaoException when a problem in database happens.
	 */
	void updateDvd(final Dvd dvd) throws DaoException;

	/**
	 * Delete a Dvd from the bookstore in the database.
	 * 
	 * @param id of Long type.
	 * @throws DaoException when a problem in database happens.
	 */
	void removeDvd(final Long id) throws DaoException;
	
	/**
	 * Search a dvd in the database.
	 * 
	 * @param id of Long type.
	 * @return a Dvd.
	 * @throws DvdNotFoundException when not found a dvd in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	Dvd findDvd(final Long id) throws DvdNotFoundException, DaoException;
	
	/**
	 * Search a dvd in the database by the title.
	 * 
	 * @param title of String type..
	 * @return a Dvd.
	 * @throws DvdNotFoundException when not found a dvd in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	Dvd findDvdByTitle(final String title) throws DvdNotFoundException, DaoException;
}
