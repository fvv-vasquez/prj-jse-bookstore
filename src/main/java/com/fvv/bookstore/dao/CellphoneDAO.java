package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Cellphone;

/**
 * DAO Interface of a Cellphone object, with main database operations from CRUD methods.
 * 
 * Created on 03/21/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public interface CellphoneDAO {

	/**
	 * Add a cellphone at the bookstore in the database.
	 * 
	 * @param cellphone of Cellphone type.
	 */
	public void addCellphone(Cellphone cellphone);

	/**
	 * Lists all the cellphones in the database.
	 * 
	 * @return a list of cellphones.
	 */
	public List<Cellphone> listCellphones();

	/**
	 * Update a cellphone already add in the database.
	 * 
	 * @param cellphone of Cellphone type.
	 */
	public void updateCellphone(Cellphone cellphone);

	/**
	 * Delete a cellphone from the bookstore in the database.
	 * 
	 * @param id of Integer type.
	 */
	public void removeCellphone(Integer id);
}
