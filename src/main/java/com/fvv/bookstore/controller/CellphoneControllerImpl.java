package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Cellphone;
import com.fvv.bookstore.dao.CellphoneDAO;
import com.fvv.bookstore.dao.CellphoneDAOImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.hardware.HardwareNotFoundException;
import com.fvv.bookstore.exception.hardware.HardwareValidationException;
import com.fvv.bookstore.util.Constants;

/**
 * Controller class for a Cellphone object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class CellphoneControllerImpl implements CellphoneController {
	
	private final CellphoneDAO cellphoneDao;

	/**
	 * Class constructor instantiating a new CellphoneDAOImpl object.
	 */
	public CellphoneControllerImpl() {
		this.cellphoneDao = new CellphoneDAOImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addCellphone(final Cellphone cellphone) 
			throws HardwareValidationException, ControllerException {
		try {
			this.validateCellphone(cellphone);
			this.cellphoneDao.addCellphone(cellphone);
		} catch (DaoException e) {
			throw new ControllerException("Error to add a cellphone", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Cellphone> listCellphones() throws ControllerException {
		try {
			return this.cellphoneDao.listCellphones();
		} catch (DaoException e) {
			throw new ControllerException("Error to load the list", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCellphone(final Cellphone cellphone) 
			throws HardwareValidationException, ControllerException {
		try {
			this.validateCellphone(cellphone);
			this.cellphoneDao.updateCellphone(cellphone);
		} catch (DaoException e) {
			throw new ControllerException("Error to update a cellphone", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeCellphone(final Long id) throws ControllerException {
		try {
			this.cellphoneDao.removeCellphone(id);
		} catch (DaoException e) {
			throw new ControllerException("Error to delete a cellphone", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Cellphone findCellphone(final Long id) 
			throws HardwareNotFoundException, ControllerException {
		try {
			return this.cellphoneDao.findCellphone(id);
		} catch (DaoException e) {
			throw new ControllerException("Error to find a cellphone", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Cellphone findCellphoneByBrand(final String brand) 
			throws HardwareNotFoundException, ControllerException {
		try {
			return this.cellphoneDao.findCellphoneByBrand(brand);
		} catch (DaoException e) {
			throw new ControllerException("Error to find a cellphone", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reduceStockItem(Cellphone cellphone, Integer quantityToReduce) throws ControllerException {
		try {
			this.cellphoneDao.reduceStockItem(cellphone, quantityToReduce);
		} catch (DaoException e) {
			throw new ControllerException("Error to update stock quantity of a cellphone", e);
		}
	}

	/**
	 * Validate if a field is empty.
	 * 
	 * @param cellphone of type Cellphone
	 * @throws HardwareValidationException if a field is empty.
	 */
	private void validateCellphone(final Cellphone cellphone) throws HardwareValidationException {
		StringBuilder sb = new StringBuilder();
		if(cellphone.getBrand().equals("")) {
			sb.append("Field brand cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(cellphone.getUnitPrice() <= 0) {
			sb.append("Field price cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(cellphone.getWarranty() <= 0) {
			sb.append("Field warranty cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		
		if(cellphone.getStorageMemory() <= 0) {
			sb.append("Field storage memory cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(cellphone.getCamPixels() <= 0) {
			sb.append("Field camera pixels cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(cellphone.getStockQty() <= 0) {
			sb.append("Field stock quantity cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(sb.length() > 0) {
			throw new HardwareValidationException(sb.toString());
		}
	}
}
