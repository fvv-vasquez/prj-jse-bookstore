package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Keyboard;

/**
 * DAO Interface of a Keyboard object, with main database operations from CRUD methods.
 * 
 * Created on 03/21/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public interface KeyboardDAO {

	/**
	 * Add a keyboard at the bookstore in the database.
	 * 
	 * @param keyboard of Keyboard type.
	 */
	public void addKeyboard(Keyboard keyboard);

	/**
	 * Lists all the keyboards in the database.
	 * 
	 * @return a list of keyboards.
	 */
	public List<Keyboard> listKeyboards();

	/**
	 * Update a keyboard already add in the database.
	 * 
	 * @param keyboard of Keyboard type.
	 */
	public void updateKeyboard(Keyboard keyboard);

	/**
	 * Delete a keyboard from the bookstore in the database.
	 * 
	 * @param id of Integer type.
	 */
	public void removeKeyboard(Integer id);
}
