package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Magazine;

/**
 * DAO Interface of a Magazine object, with main database operations from CRUD methods.
 * 
 * Created on 03/21/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public interface MagazineDAO {

	/**
	 * Add a magazine at the bookstore in the database.
	 * 
	 * @param addMagazine of Magazine type.
	 */
	public void addMagazine(Magazine magazine);

	/**
	 * Lists all the magazines in the database.
	 * 
	 * @return a list of magazines.
	 */
	public List<Magazine> listMagazines();

	/**
	 * Update a magazine already add in the database.
	 * 
	 * @param updateMagazine of Magazine type.
	 */
	public void updateMagazine(Magazine magazine);

	/**
	 * Delete a magazine from the bookstore in the database.
	 * 
	 * @param removeMagazine of Integer type.
	 */
	public void removeMagazine(Integer editionNumber);
}
