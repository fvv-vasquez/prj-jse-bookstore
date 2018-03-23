package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.MovieDvd;

/**
 * DAO Interface of a MovieDvd object, with main database operations from CRUD methods.
 * 
 * Created on 03/21/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public interface MovieDvdDAO {

	/**
	 * Add a movieDvd at the bookstore in the database.
	 * 
	 * @param addMovieDvd of MovieDvd type.
	 */
	public void addMovieDvd(MovieDvd movieDvd);

	/**
	 * Lists all the movieDvds in the database.
	 * 
	 * @return a list of movieDvds.
	 */
	public List<MovieDvd> listMovieDvds();

	/**
	 * Update a movieDvd already add in the database.
	 * 
	 * @param updateMovieDvd of MovieDvd type.
	 */
	public void updateMovieDvd(MovieDvd movieDvd);

	/**
	 * Delete a movieDvd from the bookstore in the database.
	 * 
	 * @param removeMovieDvd of Integer type.
	 */
	public void removeMovieDvd(Integer code);
}
