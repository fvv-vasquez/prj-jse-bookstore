package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Magazine;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.magazine.MagazineNotFoundException;

/**
 * DAO Interface of a Magazine object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public interface MagazineDAO {

	/**
	 * Add a magazine at the bookstore in the database.
	 * 
	 * @param magazine of Magazine type. 
	 * @throws DaoException when a problem in database happens.
	 */
	void addMagazine(final Magazine magazine) throws DaoException;

	/**
	 * Lists all the magazines in the database.
	 * 
	 * @return a list of magazines.
	 * @throws DaoException when a problem in database happens.
	 */
	List<Magazine> listMagazines() throws DaoException;

	/**
	 * Update a magazine already added in the database.
	 * 
	 * @param magazine of Magazine type.
	 * @throws DaoException when a problem in database happens.
	 */
	void updateMagazine(final Magazine magazine) throws DaoException;

	/**
	 * Delete a magazine from the bookstore in the database.
	 * 
	 * @param id of Long type.
	 * @throws DaoException when a problem in database happens.
	 */
	void removeMagazine(final Long id) throws DaoException;
	
	/**
	 * Search a magazine in the database.
	 * 
	 * @param id of a Long type.
	 * @return a Magazine.
	 * @throws MagazineNotFoundException when not found a magazine in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	Magazine findMagazine(final Long id) throws MagazineNotFoundException, DaoException;
	
	/**
	 * Search a magazine in the database by the name.
	 * 
	 * @param name of String type.
	 * @return a Magazine.
	 * @throws MagazineNotFoundException when not found a magazine in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	Magazine findMagazineByName(final String name) throws MagazineNotFoundException, DaoException;
	
	/**
	 * Reduce the quantity of a stock item.
	 * 
	 * @param magazine of Magazine type.
	 * @param quantityToReduce of Integer type.
	 * @throws DaoException when a problem in database happens.
	 */
	void reduceStockItem(final Magazine magazine, final Integer quantityToReduce) throws DaoException;
	
	/**
	 * Lists all the magazines that needs to be replaced in the stock.
	 * 
	 * @return a list of magazines that needs to be replaced.
	 * @throws DaoException when a problem in database happens.
	 */
	List<Magazine> listStockToReplace() throws DaoException;
}
