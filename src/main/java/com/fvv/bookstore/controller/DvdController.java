package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.bean.MovieDvd;
import com.fvv.bookstore.bean.ShowDvd;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.dvd.DvdNotFoundException;
import com.fvv.bookstore.exception.dvd.DvdValidationException;

/**
 * Controller interface for a Dvd object.
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
	 * Lists all the shows' dvds using DAO.
	 * 
	 * @return a list of shows' dvds.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<ShowDvd> listDvdsShow() throws ControllerException;
	
	/**
	 * Lists all the movies' dvds using DAO.
	 * 
	 * @return a list of movies' dvds.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<MovieDvd> listDvdsMovie() throws ControllerException;
	
	/**
	 * Update a dvd already added using DAO.
	 * 
	 * @param dvd of Dvd type.
	 * @throws DvdValidationException when a field is empty.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void updateDvd(final Dvd dvd) throws DvdValidationException, ControllerException;
	
	/**
	 * Delete a dvd using DAO.
	 * 
	 * @param id of Long type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void removeDvd(final Long id) throws ControllerException;
	
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
