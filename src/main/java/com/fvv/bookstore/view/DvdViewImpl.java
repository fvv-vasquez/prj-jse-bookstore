package com.fvv.bookstore.view;

import javax.swing.JOptionPane;

import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.bean.MovieDvd;
import com.fvv.bookstore.bean.ShowDvd;
import com.fvv.bookstore.controller.DvdController;
import com.fvv.bookstore.controller.DvdControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.dvd.DvdNotFoundException;
import com.fvv.bookstore.exception.dvd.DvdValidationException;
import com.fvv.bookstore.util.Constants;

/**
 * DvdView class to view the Dvd object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class DvdViewImpl implements DvdView {
	
	private final DvdController dvdController;
	
	public DvdViewImpl() {
		this.dvdController = new DvdControllerImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addDvd() {
		try {
			final Dvd dvd = this.createDvdFromInput(Boolean.FALSE);
			this.dvdController.addDvd(dvd);
			JOptionPane.showMessageDialog(null, "DVD added successfully!");	
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value: " + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | DvdNotFoundException | DvdValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void listDvds() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateDvd() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeDvd() {
		// TODO Auto-generated method stub

	}

	private Dvd createDvdFromInput(final boolean isUpdate) 
			throws DvdNotFoundException, ControllerException {
		Dvd dvd = null;
		
		if(isUpdate) {
			Long idUp = Long.parseLong(JOptionPane.showInputDialog("Insert the ID to update"));
			Dvd dvdFound = this.dvdController.findDvd(idUp);			
			if(dvdFound instanceof MovieDvd) {
				MovieDvd dvdMovie = new MovieDvd();
				dvdMovie.setDirector(JOptionPane.showInputDialog("Insert the director"));
				dvd = dvdMovie;
			} else {
				ShowDvd dvdShow = new ShowDvd();
				dvdShow.setArtist(JOptionPane.showInputDialog("Insert the artist"));
				dvd = dvdShow;
			}
			dvd.setId(idUp);
		} else {
			String input = JOptionPane.showInputDialog("Insert the DVD type: Movie (M) or Show (S)");
			if (input.charAt(0) == 'M') {
				MovieDvd dvdMovie = new MovieDvd();
				dvdMovie.setDirector(JOptionPane.showInputDialog("Insert the director"));
				dvd = dvdMovie;
			} else {
				ShowDvd dvdShow = new ShowDvd();
				dvdShow.setArtist(JOptionPane.showInputDialog("Insert the artist"));
				dvd = dvdShow;
			}
		}
		dvd.setTitle(JOptionPane.showInputDialog("Insert the title"));
		dvd.setTotalDuration(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the total duration")));
		dvd.setPrice(
				Double.parseDouble(JOptionPane.showInputDialog("Insert the price")));
		dvd.setGenre(JOptionPane.showInputDialog("Insert the genre"));
		dvd.setReleaseYear(Integer.parseInt(JOptionPane.showInputDialog("Insert the release year")));
		dvd.setCode(Integer.parseInt(JOptionPane.showInputDialog("Insert the code")));
		return dvd;		
	}
}