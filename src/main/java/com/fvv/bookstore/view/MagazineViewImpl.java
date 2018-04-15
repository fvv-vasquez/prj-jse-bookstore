package com.fvv.bookstore.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.fvv.bookstore.bean.Magazine;
import com.fvv.bookstore.controller.MagazineController;
import com.fvv.bookstore.controller.MagazineControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.magazine.MagazineNotFoundException;
import com.fvv.bookstore.exception.magazine.MagazineValidationException;
import com.fvv.bookstore.util.Constants;
import com.fvv.bookstore.util.DateUtil;

/**
 * MagazineView class to view the Book object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class MagazineViewImpl implements MagazineView {
	
	private final MagazineController magazineController;
	
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
			final Magazine magazine = this.createMagazineFromInput(Boolean.FALSE);
			this.magazineController.addMagazine(magazine);
			JOptionPane.showMessageDialog(null, "Magazine added successfully!");	
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value: " + Constants.LINE_SEPARATOR 
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
	public void listMagazines() {
		try {
			StringBuilder sb = new StringBuilder();
			List<Magazine> magazines = this.magazineController.listMagazines();
			if(magazines != null && !magazines.isEmpty()) {
				for(Magazine m : magazines) {
					sb.append(m).append(Constants.LINE_SEPARATOR);
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
			final Magazine magazine = this.createMagazineFromInput(Boolean.TRUE);			
			this.magazineController.updateMagazine(magazine);
			JOptionPane.showMessageDialog(null, "Magazine updated successfully!");	
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value: " + Constants.LINE_SEPARATOR 
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
			JOptionPane.showMessageDialog(null, "Problems to convert the value: " + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (MagazineNotFoundException | ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Creating a magazine from the input.
	 * 
	 * @param isUpdate of boolean type.
	 * @return a Magazine.
	 * @throws MagazineNotFoundException when a magazine is not found.
	 * @throws ControllerException when a problem in controller happens.
	 */
	private Magazine createMagazineFromInput(final boolean isUpdate) 
			throws MagazineNotFoundException, ControllerException {
		final Magazine magazine = new Magazine();
		
		if(isUpdate) {
			Long idUp = Long.parseLong(JOptionPane.showInputDialog("Insert the ID to update"));
			this.magazineController.findMagazine(idUp);
			magazine.setId(idUp);
		}
		
		magazine.setName(JOptionPane.showInputDialog("Insert the name"));
		magazine.setEditionNumber(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the edition number")));
		magazine.setGenre(JOptionPane.showInputDialog("Insert the genre"));
		magazine.setPublicationDate(DateUtil.stringToDate(
				JOptionPane.showInputDialog("Insert the date (mm/dd/yyyy)")));
		magazine.setPublisher(JOptionPane.showInputDialog("Insert the publisher"));
		magazine.setUnitPrice(
				Double.parseDouble(JOptionPane.showInputDialog("Insert the price")));
		magazine.setStockQty(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the quantity in stock")));
		return magazine;
	}
}
