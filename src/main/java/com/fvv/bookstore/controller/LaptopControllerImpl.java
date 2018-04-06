package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Laptop;
import com.fvv.bookstore.dao.LaptopDAO;
import com.fvv.bookstore.dao.LaptopDAOImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.hardware.HardwareNotFoundException;
import com.fvv.bookstore.exception.hardware.HardwareValidationException;
import com.fvv.bookstore.util.Constants;

/**
 * Controller class for a Laptop object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class LaptopControllerImpl implements LaptopController {
	
	private final LaptopDAO laptopDao;
	
	/**
	 * Class constructor instantiating a new LaptopDAOImpl object.
	 */
	public LaptopControllerImpl() {
		this.laptopDao = new LaptopDAOImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addLaptop(final Laptop laptop) 
			throws HardwareValidationException, ControllerException {
		try {
			this.validateLaptop(laptop);
			this.laptopDao.addLaptop(laptop);
		} catch (DaoException e) {
			throw new ControllerException("Error to add a laptop", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Laptop> listLaptops() throws ControllerException {
		try {
			return this.laptopDao.listLaptops();
		} catch (DaoException e) {
			throw new ControllerException("Error to load the list", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateLaptop(final Laptop laptop) 
			throws HardwareValidationException, ControllerException {
		try {
			this.validateLaptop(laptop);
			this.laptopDao.updateLaptop(laptop);
		} catch (DaoException e) {
			throw new ControllerException("Error to update a laptop", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeLaptop(final Long id) throws ControllerException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Laptop findLaptop(final Long id) throws HardwareNotFoundException, ControllerException {
		try {
			return this.laptopDao.findLaptop(id);
		} catch (DaoException e) {
			throw new ControllerException("Error to find a laptop", e);
		}
	}

	/**
	 * Validate if a field is empty.
	 * 
	 * @param laptop of type Laptop
	 * @throws HardwareValidationException if a field is empty.
	 */
	private void validateLaptop(final Laptop laptop) throws HardwareValidationException {
		StringBuilder sb = new StringBuilder();
		if(laptop.getBrand().equals("")) {
			sb.append("Field brand cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(laptop.getPrice() <= 0) {
			sb.append("Field price cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(laptop.getWarranty() <= 0) {
			sb.append("Field warranty cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		
		if(laptop.getRamSize() <= 0) {
			sb.append("Field RAM size cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(laptop.getHdSize() <= 0) {
			sb.append("Field HD size cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(sb.length() > 0) {
			throw new HardwareValidationException(sb.toString());
		}
	}
}
