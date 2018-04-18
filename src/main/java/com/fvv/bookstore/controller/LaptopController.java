package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Laptop;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.hardware.HardwareNotFoundException;
import com.fvv.bookstore.exception.hardware.HardwareValidationException;

/**
 * Controller interface for a Laptop object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface LaptopController {

	/**
	 * Add a laptop using DAO.
	 * 
	 * @param laptop of Laptop type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws HardwareValidationException when a field is empty.
	 */
	void addLaptop(final Laptop laptop) throws 
		HardwareValidationException, ControllerException;
	
	/**
	 * Lists all the laptops using DAO.
	 * 
	 * @return a list of laptops.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<Laptop> listLaptops() throws ControllerException;

	/**
	 * Update a laptop already added using DAO.
	 * 
	 * @param laptop of Laptop type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws HardwareValidationException when a field is empty.
	 */
	void updateLaptop(final Laptop laptop) throws HardwareValidationException, ControllerException;
	
	/**
	 * Delete a laptop using DAO.
	 * 
	 * @param id of Long type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void removeLaptop(final Long id) throws ControllerException;
	
	/**
	 * Search a laptop using DAO
	 * 
	 * @param id of Long type.
	 * @return a Laptop.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws HardwareNotFoundException when a laptop is not found.
	 */
	Laptop findLaptop(final Long id) throws HardwareNotFoundException, ControllerException;
	
	/**
	 * Search a laptop by the brand using DAO
	 * 
	 * @param brand of String type.
	 * @return a Laptop.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws HardwareNotFoundException when a laptop is not found.
	 */
	Laptop findLaptopByBrand(final String brand) throws HardwareNotFoundException, ControllerException;
}
