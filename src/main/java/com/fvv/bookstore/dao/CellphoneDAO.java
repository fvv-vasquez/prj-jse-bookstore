package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Cellphone;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.hardware.HardwareNotFoundException;

/**
 * DAO Interface of a Cellphone object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public interface CellphoneDAO {

	/**
	 * Add a Cellphone at the bookstore in the database.
	 * 
	 * @param cellphone of a Cellphone type.
	 * @throws DaoException when a problem in database happens.
	 */
	void addCellphone(final Cellphone cellphone) throws DaoException;

	/**
	 * Lists all the Cellphones in the database.
	 * 
	 * @return a list of cellphones.
	 * @throws DaoException when a problem in database happens.
	 */
	List<Cellphone> listCellphones() throws DaoException;

	/**
	 * Update a Cellphone already added in the database.
	 * 
	 * @param cellphone of Cellphone type.
	 * @throws DaoException when a problem in database happens.
	 */
	void updateCellphone(final Cellphone cellphone) throws DaoException;

	/**
	 * Delete a Cellphone from the bookstore in the database.
	 * 
	 * @param id of Long type.
	 * @throws DaoException when a problem in database happens.
	 */
	void removeCellphone(final Long id) throws DaoException;
	
	/**
	 * Search a Cellphone in the database.
	 * 
	 * @param id of Long type.
	 * @return a Cellphone.
	 * @throws HardwareNotFoundException when not found a hardware in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	Cellphone findCellphone(final Long id) throws HardwareNotFoundException, DaoException;
}
