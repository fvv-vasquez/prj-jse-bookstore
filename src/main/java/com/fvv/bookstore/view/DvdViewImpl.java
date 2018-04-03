package com.fvv.bookstore.view;

import java.util.List;

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
	public void listDvdsShow() {
		try {
			StringBuilder sb = new StringBuilder();
			List<ShowDvd> dvds = this.dvdController.listDvdsShow();
			if(dvds != null && !dvds.isEmpty()) {
				for(ShowDvd d : dvds) {
					sb.append(d).append(Constants.LINE_SEPARATOR);
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing All Shows' Dvds", 
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "There are no items to show!");
			}			
		} catch (ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void listDvdsMovie() {
		try {
			StringBuilder sb = new StringBuilder();
			List<MovieDvd> dvds = this.dvdController.listDvdsMovie();
			if(dvds != null && !dvds.isEmpty()) {
				for(MovieDvd d : dvds) {
					sb.append(d).append(Constants.LINE_SEPARATOR);
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing All Movies' Dvds", 
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "There are no items to show!");
			}			
		} catch (ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateDvd() {
		try {
			final Dvd dvd = this.createDvdFromInput(Boolean.TRUE);
			this.dvdController.updateDvd(dvd);
			JOptionPane.showMessageDialog(null, "DVD updated successfully!");	
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
	public void removeDvd() {
		try {
			Long idDelete = (Long.parseLong(JOptionPane.showInputDialog(
					"Insert the ID to delete")));
			this.dvdController.findDvd(idDelete);
			this.dvdController.removeDvd(idDelete);
			JOptionPane.showMessageDialog(null, "Deleted successfully!");			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value: " + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (DvdNotFoundException | ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
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
