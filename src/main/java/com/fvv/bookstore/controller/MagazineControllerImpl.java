package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Magazine;
import com.fvv.bookstore.dao.MagazineDAO;
import com.fvv.bookstore.dao.MagazineDAOImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.magazine.MagazineNotFoundException;
import com.fvv.bookstore.exception.magazine.MagazineValidationException;
import com.fvv.bookstore.util.Constants;

/**
 * Controller class for a Magazine object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 30 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public class MagazineControllerImpl implements MagazineController {
	
	private final MagazineDAO magazineDao;
	
	/**
	 * Class constructor instantiating a new MagazineDAOImpl object.
	 */
	public MagazineControllerImpl() {
		this.magazineDao = new MagazineDAOImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean addMagazine(Magazine magazine) throws 
		MagazineValidationException, ControllerException {
		try {
			this.validateMagazine(magazine);
			return this.magazineDao.addMagazine(magazine);
		} catch (DaoException e) {
			throw new ControllerException("Error to add a magazine", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Magazine> listMagazines() throws ControllerException {
		try {
			return this.magazineDao.listMagazines();
		} catch (DaoException e) {
			throw new ControllerException("Error to load the list", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean updateMagazine(Magazine magazine) throws MagazineValidationException, ControllerException {
		try {
			this.validateMagazine(magazine);
			return this.magazineDao.updateMagazine(magazine);
		} catch (DaoException e) {
			throw new ControllerException("Error to update a magazine", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeMagazine(Long id) throws ControllerException {
		try {
			this.magazineDao.removeMagazine(id);
		} catch (DaoException e) {
			throw new ControllerException("Error to delete a magazine", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Magazine findMagazine(Long id) throws MagazineNotFoundException, ControllerException {
		try {
			return this.magazineDao.findMagazine(id);
		} catch (DaoException e) {
			throw new ControllerException("Error to find a magazine", e);
		}
	}
	
	/**
	 * Validate if a field is empty.
	 * 
	 * @param magazine of type Magazine
	 * @throws MagazineValidationException if a field is empty.
	 */
	private void validateMagazine(final Magazine magazine) throws MagazineValidationException {
		StringBuilder sb = new StringBuilder();
		if(magazine.getName().equals("")) {
			sb.append("Field name cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(magazine.getGenre().equals("")) {
			sb.append("Field genre cannot be empty.").append(Constants.LINE_SEPARATOR);
		}
		if(magazine.getPublisher().equals("")) {
			sb.append("Field publisher cannot be empty.").append(Constants.LINE_SEPARATOR);
		}
		if(magazine.getEditionNumber() <= 0) {
			sb.append("Field edition number cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(magazine.getPrice() <= 0) {
			sb.append("Field price cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(magazine.getPublicationDate() == null) {
			sb.append("Field publication date cannot be empty.").append(Constants.LINE_SEPARATOR);
		}
		if(sb.length() > 0) {
			throw new MagazineValidationException(sb.toString());
		}
	}

}
