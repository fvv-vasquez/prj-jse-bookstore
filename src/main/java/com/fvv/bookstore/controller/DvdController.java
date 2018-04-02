package com.fvv.bookstore.controller;

import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.dvd.DvdNotFoundException;
import com.fvv.bookstore.exception.dvd.DvdValidationException;

/**
 * Controller interface for a Magazine object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface DvdController {
	
	/**
	 * Add a dvd using DAO.
	 * 
	 * @param dvd of Dvd type.
	 * @throws DvdValidationException when a field is empty.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void addDvd(final Dvd dvd) throws DvdValidationException, ControllerException;
	
	/**
	 * Search a dvd using DAO.
	 * 
	 * @param id of Long type.
	 * @return a Dvd
	 * @throws DvdNotFoundException when a dvd is not found.
	 * @throws ControllerException when a problem in controller happens.
	 */
	Dvd findDvd(final Long id) throws DvdNotFoundException, ControllerException;
}
