package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Cellphone;

/**
 * DAO Interface of a Cellphone object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 21 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public interface CellphoneDAO {

	/**
	 * Add a cellphone at the bookstore in the database.
	 * 
	 * @param cellphone of Cellphone type.
	 */
	public void addCellphone(final Cellphone cellphone);

	/**
	 * Lists all the cellphones in the database.
	 * 
	 * @return a list of cellphones.
	 */
	public List<Cellphone> listCellphones();

	/**
	 * Update a cellphone already added in the database.
	 * 
	 * @param cellphone of Cellphone type.
	 */
	public void updateCellphone(final Cellphone cellphone);

	/**
	 * Delete a cellphone from the bookstore in the database.
	 * 
	 * @param id of Long type.
	 */
	public void removeCellphone(final Long id);
}
