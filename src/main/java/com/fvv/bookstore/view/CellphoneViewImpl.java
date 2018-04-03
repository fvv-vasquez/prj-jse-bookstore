package com.fvv.bookstore.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.fvv.bookstore.bean.Cellphone;
import com.fvv.bookstore.controller.CellphoneController;
import com.fvv.bookstore.controller.CellphoneControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.hardware.HardwareNotFoundException;
import com.fvv.bookstore.exception.hardware.HardwareValidationException;
import com.fvv.bookstore.util.Constants;

/**
 * CellphoneView class to view the Cellphone object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class CellphoneViewImpl implements CellphoneView {
	
	private final CellphoneController cellphoneController;
	
	/**
	 * Class constructor instantiating a new MagazineControllerImpl object.
	 */
	public CellphoneViewImpl() {
		this.cellphoneController = new CellphoneControllerImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addCellphone() {
		try {
			final Cellphone cellphone = this.createCellphoneFromInput(Boolean.FALSE);
			this.cellphoneController.addCellphone(cellphone);
			JOptionPane.showMessageDialog(null, "Cellphone added successfully!");	
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value: " + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | HardwareNotFoundException | HardwareValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void listCellphones() {
		try {
			StringBuilder sb = new StringBuilder();
			List<Cellphone> cellphones = this.cellphoneController.listCellphones();
			if(cellphones != null && !cellphones.isEmpty()) {
				for(Cellphone c : cellphones) {
					sb.append(c).append(Constants.LINE_SEPARATOR);
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing All Cellphones", 
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
	public void updateCellphone() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeCellphone() {
		// TODO Auto-generated method stub

	}

	/**
	 * Creating a Cellphone from the input.
	 * 
	 * @param isUpdate of boolean type.
	 * @return a Cellphone.
	 * @throws HardwareNotFoundException when a cellphone is not found.
	 * @throws ControllerException when a problem in controller happens.
	 */
	private Cellphone createCellphoneFromInput(final boolean isUpdate) 
			throws HardwareNotFoundException, ControllerException {
		final Cellphone cellphone = new Cellphone();
		
		if(isUpdate) {
			Long idUp = Long.parseLong(JOptionPane.showInputDialog("Insert the ID to update"));
			this.cellphoneController.findCellphone(idUp);
			cellphone.setId(idUp);
		}
		
		cellphone.setBrand(JOptionPane.showInputDialog("Insert the brand"));
		cellphone.setPrice(
				Double.parseDouble(JOptionPane.showInputDialog("Insert the price")));
		cellphone.setWarranty(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the warranty in months")));
		cellphone.setStorageMemory(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the storage memory - GB")));
		cellphone.setCamera(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the camera - MP")));
		return cellphone;
	}
}
