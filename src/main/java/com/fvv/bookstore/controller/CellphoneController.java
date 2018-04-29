package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Cellphone;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.hardware.HardwareNotFoundException;
import com.fvv.bookstore.exception.hardware.HardwareValidationException;

/**
 * Controller interface for a Cellphone object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface CellphoneController {

	/**
	 * Add a cellphone using DAO.
	 * 
	 * @param cellphone of Cellphone type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws HardwareValidationException when a field is empty.
	 */
	void addCellphone(final Cellphone cellphone) throws 
		HardwareValidationException, ControllerException;
	
	/**
	 * Lists all the cellphones using DAO.
	 * 
	 * @return a list of cellphones.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<Cellphone> listCellphones() throws ControllerException;

	/**
	 * Update a cellphone already added using DAO.
	 * 
	 * @param cellphone of Cellphone type.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws HardwareValidationException when a field is empty.
	 */
	void updateCellphone(final Cellphone cellphone) throws HardwareValidationException, ControllerException;
	
	/**
	 * Delete a cellphone using DAO.
	 * 
	 * @param id of Long type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void removeCellphone(final Long id) throws ControllerException;
	
	/**
	 * Search a cellphone using DAO
	 * 
	 * @param id of Long type.
	 * @return a Cellphone.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws HardwareNotFoundException when a cellphone is not found.
	 */
	Cellphone findCellphone(final Long id) throws HardwareNotFoundException, ControllerException;
	
	/**
	 * Search a cellphone by the brand using DAO.
	 * 
	 * @param brand of String type.
	 * @return a Cellphone.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws HardwareNotFoundException when a cellphone is not found.
	 */
	Cellphone findCellphoneByBrand(final String brand) throws HardwareNotFoundException, ControllerException;
	
	/**
	 * Reduce the quantity of a stock item using DAO.
	 * 
	 * @param cellphone of Cellphone type.
	 * @param quantityToReduce of Integer type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	void reduceStockItem(final Cellphone cellphone, final Integer quantityToReduce) throws ControllerException;
}
