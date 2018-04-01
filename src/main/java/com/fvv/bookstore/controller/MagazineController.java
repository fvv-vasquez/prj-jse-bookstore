package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Magazine;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.magazine.MagazineNotFoundException;
import com.fvv.bookstore.exception.magazine.MagazineValidationException;

/**
 * Controller interface for a Magazine object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public interface MagazineController {

	/**
	 * Add a magazine using DAO.
	 * 
	 * @param magazine of Magazine type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws MagazineValidationException when a field is empty.
	 */
	void addMagazine(final Magazine magazine) throws 
		MagazineValidationException, ControllerException;
	
	/**
	 * Lists all the magazines using DAO.
	 * 
	 * @return a list of magazines.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<Magazine> listMagazines() throws ControllerException;

	/**
	 * Update a magazine already added using DAO.
	 * 
	 * @param magazine of Magazine type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws MagazineValidationException when a field is empty.
	 */
	void updateMagazine(final Magazine magazine) throws MagazineValidationException, ControllerException;
	
	/**
	 * Delete a magazine using DAO.
	 * 
	 * @param id of Long type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void removeMagazine(final Long id) throws ControllerException;
	
	/**
	 * Search a magazine using DAO
	 * 
	 * @param id of Long type.
	 * @return a Magazine.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws MagazineNotFoundException when a magazine is not found.
	 */
	Magazine findMagazine(final Long id) throws MagazineNotFoundException, ControllerException;
}
