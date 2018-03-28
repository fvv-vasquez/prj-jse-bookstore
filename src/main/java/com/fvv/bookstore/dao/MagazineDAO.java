package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Magazine;

/**
 * DAO Interface of a Magazine object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 21 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public interface MagazineDAO {

	/**
	 * Add a magazine at the bookstore in the database.
	 * 
	 * @param magazine of Magazine type.
	 */
	public void addMagazine(final Magazine magazine);

	/**
	 * Lists all the magazines in the database.
	 * 
	 * @return a list of magazines.
	 */
	public List<Magazine> listMagazines();

	/**
	 * Update a magazine already added in the database.
	 * 
	 * @param magazine of Magazine type.
	 */
	public void updateMagazine(final Magazine magazine);

	/**
	 * Delete a magazine from the bookstore in the database.
	 * 
	 * @param editionNumber of Long type.
	 */
	public void removeMagazine(final Long id);
}
