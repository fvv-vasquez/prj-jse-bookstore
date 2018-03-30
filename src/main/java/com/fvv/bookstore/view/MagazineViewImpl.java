package com.fvv.bookstore.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.fvv.bookstore.bean.Magazine;
import com.fvv.bookstore.controller.MagazineController;
import com.fvv.bookstore.controller.MagazineControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.magazine.MagazineNotFoundException;
import com.fvv.bookstore.exception.magazine.MagazineValidationException;
import com.fvv.bookstore.util.DateUtil;

/**
 * MagazineView class to view the Book object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 30 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public class MagazineViewImpl implements MagazineView {
	
	private MagazineController magazineController;
	
	/**
	 * Class constructor instantiating a new MagazineControllerImpl object.
	 */
	public MagazineViewImpl() {
		this.magazineController = new MagazineControllerImpl();
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void addMagazine() {
		try {
			Magazine magazine = new Magazine();
			magazine.setName(JOptionPane.showInputDialog("Insert the name"));
			magazine.setEditionNumber(
					Integer.parseInt(JOptionPane.showInputDialog("Insert the edition number")));
			magazine.setGenre(JOptionPane.showInputDialog("Insert the genre"));
			magazine.setPublicationDate(DateUtil.stringToDate(
					JOptionPane.showInputDialog("Insert the date (mm/dd/yyyy)")));
			magazine.setPublisher(JOptionPane.showInputDialog("Insert the publisher"));
			magazine.setPrice(
					Double.parseDouble(JOptionPane.showInputDialog("Insert the price")));			
			boolean isSuccessful = this.magazineController.addMagazine(magazine);
			
			if (isSuccessful) {
				JOptionPane.showMessageDialog(null, "Magazine added successfully!");
			} else {
				JOptionPane.showMessageDialog(null, "Error to add the magazine!");
			}	
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value:\n" 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | MagazineValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void listMagazines() {
		try {
			StringBuilder sb = new StringBuilder();
			List<Magazine> magazines = this.magazineController.listMagazines();
			if(magazines != null && !magazines.isEmpty()) {
				for(Magazine m : magazines) {
					sb.append(m).append("\n");
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing All Magazines", 
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
	public void updateMagazine() {
		try {
			Magazine magazine = new Magazine();
			Long idUp = Long.parseLong(JOptionPane.showInputDialog("Insert the ID to update"));
			this.magazineController.findMagazine(idUp);
			
			magazine.setId(idUp);
			magazine.setName(JOptionPane.showInputDialog("Insert the name"));
			magazine.setEditionNumber(
					Integer.parseInt(JOptionPane.showInputDialog("Insert the edition number")));
			magazine.setGenre(JOptionPane.showInputDialog("Insert the genre"));
			magazine.setPublicationDate(DateUtil.stringToDate(
					JOptionPane.showInputDialog("Insert the date (mm/dd/yyyy)")));
			magazine.setPublisher(JOptionPane.showInputDialog("Insert the publisher"));
			magazine.setPrice(
					Double.parseDouble(JOptionPane.showInputDialog("Insert the price")));			
			boolean isSuccessful = this.magazineController.updateMagazine(magazine);
			
			if (isSuccessful) {
				JOptionPane.showMessageDialog(null, "Magazine updated successfully!");
			} else {
				JOptionPane.showMessageDialog(null, "Error to updated the magazine!");
			}	
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value:\n" 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | MagazineNotFoundException | MagazineValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void removeMagazine() {
		try {
			Long idDelete = (Long.parseLong(JOptionPane.showInputDialog(
					"Insert the ID to delete")));
			this.magazineController.findMagazine(idDelete);
			this.magazineController.removeMagazine(idDelete);
			JOptionPane.showMessageDialog(null, "Deleted successfully!");			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value:\n" 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (MagazineNotFoundException | ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
