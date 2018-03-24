package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.ShowDvd;

/**
 * DAO Interface of a ShowDvd object, with main database operations from CRUD methods.
 * 
 * Created on 03/21/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public interface ShowDvdDAO {

	/**
	 * Add a showDvd at the bookstore in the database.
	 * 
	 * @param showDvd of ShowDvd type.
	 */
	public void addShowDvd(ShowDvd showDvd);

	/**
	 * Lists all the showDvds in the database.
	 * 
	 * @return a list of showDvds.
	 */
	public List<ShowDvd> listShowDvds();

	/**
	 * Update a showDvd already add in the database.
	 * 
	 * @param showDvd of ShowDvd type.
	 */
	public void updateShowDvd(ShowDvd showDvd);

	/**
	 * Delete a showDvd from the bookstore in the database.
	 * 
	 * @param code of Integer type.
	 */
	public void removeShowDvd(Integer code);
}
