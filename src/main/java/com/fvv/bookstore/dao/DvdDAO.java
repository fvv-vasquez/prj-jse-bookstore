package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.MovieDvd;

/**
 * DAO Interface of a MovieDvd object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 211 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public interface DvdDAO {

	/**
	 * Add a movieDvd at the bookstore in the database.
	 * 
	 * @param movieDvd of MovieDvd type.
	 */
	void addMovieDvd(final MovieDvd movieDvd);

	/**
	 * Lists all the movieDvds in the database.
	 * 
	 * @return a list of movieDvds.
	 */
	List<MovieDvd> listMovieDvds();

	/**
	 * Update a movieDvd already added in the database.
	 * 
	 * @param movieDvd of MovieDvd type.
	 */
	void updateMovieDvd(final MovieDvd movieDvd);

	/**
	 * Delete a movieDvd from the bookstore in the database.
	 * 
	 * @param id of Long type.
	 */
	void removeMovieDvd(final Long id);
}
