package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Laptop;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.hardware.HardwareNotFoundException;

/**
 * DAO Interface of a Laptop object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public interface LaptopDAO {

	/**
	 * Add a laptop at the bookstore in the database.
	 * 
	 * @param laptop of Laptop type.
	 * @throws DaoException when a problem in database happens.
	 */
	void addLaptop(final Laptop laptop) throws DaoException;

	/**
	 * Lists all laptops in the database.
	 * 
	 * @return a list of laptops.
	 * @throws DaoException when a problem in database happens.
	 */
	List<Laptop> listLaptops() throws DaoException;

	/**
	 * Update a laptop already added in the database.
	 * 
	 * @param laptop of Laptop type.
	 * @throws DaoException when a problem in database happens.
	 */
	void updateLaptop(final Laptop laptop) throws DaoException;

	/**
	 * Delete a laptop from the bookstore in the database.
	 * 
	 * @param id of Long type.
	 * @throws DaoException when a problem in database happens.
	 */
	void removeLaptop(final Long id) throws DaoException;
	
	/**
	 * Search a laptop in the database.
	 * 
	 * @param id of a Long type.
	 * @return a Laptop.
	 * @throws HardwareNotFoundException when not found a laptop in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	Laptop findLaptop(final Long id) throws HardwareNotFoundException, DaoException;
	
	/**
	 * Search a laptop in the database by the brand.
	 * 
	 * @param brand of String type.
	 * @return a Laptop.
	 * @throws HardwareNotFoundException when not found a laptop in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	Laptop findLaptopByBrand(final String brand) throws HardwareNotFoundException, DaoException;
	
	/**
	 * Reduce the quantity of a stock item.
	 * 
	 * @param laptop of Laptop type.
	 * @param quantityToReduce of Integer type.
	 * @throws DaoException when a problem in database happens.
	 */
	void reduceStockItem(final Laptop laptop, final Integer quantityToReduce) throws DaoException;
	
	/**
	 * Lists all laptops that needs to be replaced in the stock.
	 * 
	 * @return a list of laptops that needs to be replaced.
	 * @throws DaoException when a problem in database happens.
	 */
	List<Laptop> listStockToReplace() throws DaoException;
}
