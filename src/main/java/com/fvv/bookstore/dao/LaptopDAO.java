package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Laptop;

/**
 * DAO Interface of a Laptop object, with main database operations from CRUD methods.
 * 
 * Created on 03/21/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public interface LaptopDAO {

	/**
	 * Add a laptop at the bookstore in the database.
	 * 
	 * @param addLaptop of Laptop type.
	 */
	public void addLaptop(Laptop laptop);

	/**
	 * Lists all the laptops in the database.
	 * 
	 * @return a list of laptops.
	 */
	public List<Laptop> listLaptops();

	/**
	 * Update a laptop already add in the database.
	 * 
	 * @param updateLaptop of Laptop type.
	 */
	public void updateLaptop(Laptop laptop);

	/**
	 * Delete a laptop from the bookstore in the database.
	 * 
	 * @param removeLaptop of Integer type.
	 */
	public void removeLaptop(Integer id);	
}
