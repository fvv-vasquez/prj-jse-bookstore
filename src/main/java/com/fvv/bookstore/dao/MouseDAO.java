package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Mouse;

/**
 * DAO Interface of a Mouse object, with main database operations from CRUD methods.
 * 
 * Created on 03/21/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public interface MouseDAO {

	/**
	 * Add a mouse at the bookstore in the database.
	 * 
	 * @param addMouse of Mouse type.
	 */
	public void addMouse(Mouse mouse);

	/**
	 * Lists all the mouses in the database.
	 * 
	 * @return a list of mouses.
	 */
	public List<Mouse> listMouses();

	/**
	 * Update a mouse already add in the database.
	 * 
	 * @param updateMouse of Mouse type.
	 */
	public void updateMouse(Mouse mouse);

	/**
	 * Delete a mouse from the bookstore in the database.
	 * 
	 * @param removeMouse of Integer type.
	 */
	public void removeMouse(Integer id);
}
