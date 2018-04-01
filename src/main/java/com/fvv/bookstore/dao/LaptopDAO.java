package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Laptop;

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
	 */
	void addLaptop(final Laptop laptop);

	/**
	 * Lists all the laptops in the database.
	 * 
	 * @return a list of laptops.
	 */
	List<Laptop> listLaptops();

	/**
	 * Update a laptop already added in the database.
	 * 
	 * @param laptop of Laptop type.
	 */
	void updateLaptop(final Laptop laptop);

	/**
	 * Delete a laptop from the bookstore in the database.
	 * 
	 * @param id of Long type.
	 */
	void removeLaptop(final Long id);	
}
