package com.fvv.bookstore.controller;

import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.dao.DvdDAO;
import com.fvv.bookstore.dao.DvdDAOImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.dvd.DvdNotFoundException;
import com.fvv.bookstore.exception.dvd.DvdValidationException;
import com.fvv.bookstore.util.Constants;

/**
 * Controller class for a Dvd object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class DvdControllerImpl implements DvdController {
	
	private final DvdDAO dvdDao;
	
	/**
	 * Class constructor instantiating a new DvdControllerImpl object.
	 */
	public DvdControllerImpl() {
		this.dvdDao = new DvdDAOImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addDvd(final Dvd dvd) throws DvdValidationException, ControllerException {
		try {
			this.validateDvd(dvd);
			this.dvdDao.addDvd(dvd);
		} catch (DaoException e) {
			throw new ControllerException("Error to add a dvd", e);
		}
	}

	/**
	 * Validate if a field is empty.
	 * 
	 * @param dvd of Dvd type.
	 * @throws DvdValidationException if a field is empty.
	 */
	private void validateDvd(final Dvd dvd) throws DvdValidationException {
		StringBuilder sb = new StringBuilder();
		if(dvd.getTitle().equals("")) {
			sb.append("Field title cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(dvd.getGenre().equals("")) {
			sb.append("Field genre cannot be empty.").append(Constants.LINE_SEPARATOR);
		}
		if(dvd.getCode() <= 0) {
			sb.append("Field code cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(dvd.getPrice() <= 0) {
			sb.append("Field price cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(dvd.getTotalDuration() <= 0) {
			sb.append("Field total duration cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(dvd.getReleaseYear() <= 0) {
			sb.append("Field release year cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(sb.length() > 0) {
			throw new DvdValidationException(sb.toString());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Dvd findDvd(Long id) throws DvdNotFoundException, ControllerException {
		try {
			return this.dvdDao.findDvd(id);
		} catch (DaoException e) {
			throw new ControllerException("Error to find a dvd", e);
		}
	}
}
