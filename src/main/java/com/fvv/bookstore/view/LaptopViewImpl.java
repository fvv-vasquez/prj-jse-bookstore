package com.fvv.bookstore.view;

import javax.swing.JOptionPane;

import com.fvv.bookstore.bean.Laptop;
import com.fvv.bookstore.controller.LaptopController;
import com.fvv.bookstore.controller.LaptopControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.hardware.HardwareNotFoundException;
import com.fvv.bookstore.exception.hardware.HardwareValidationException;
import com.fvv.bookstore.util.Constants;

/**
 * LaptopView class to view the Laptop object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class LaptopViewImpl implements LaptopView {
	
	private final LaptopController laptopController;
	
	/**
	 * Class constructor instantiating a new LaptopViewImpl object.
	 */
	public LaptopViewImpl() {
		this.laptopController = new LaptopControllerImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addLaptop() {
		try {
			final Laptop laptop = this.createLaptopFromInput(Boolean.FALSE);
			this.laptopController.addLaptop(laptop);
			JOptionPane.showMessageDialog(null, "Laptop added successfully!");	
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
	public void listLaptops() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateLaptop() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeLaptop() {
		// TODO Auto-generated method stub

	}

	/**
	 * Creating a Laptop from the input.
	 * 
	 * @param isUpdate of boolean type.
	 * @return a Laptop.
	 * @throws HardwareNotFoundException when a laptop is not found.
	 * @throws ControllerException when a problem in controller happens.
	 */
	private Laptop createLaptopFromInput(final boolean isUpdate) 
			throws HardwareNotFoundException, ControllerException {
		final Laptop laptop = new Laptop();
		
		if(isUpdate) {
			Long idUp = Long.parseLong(JOptionPane.showInputDialog("Insert the ID to update"));
			this.laptopController.findLaptop(idUp);
			laptop.setId(idUp);
		}
		
		laptop.setBrand(JOptionPane.showInputDialog("Insert the brand"));
		laptop.setPrice(
				Double.parseDouble(JOptionPane.showInputDialog("Insert the price")));
		laptop.setWarranty(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the warranty in months")));
		laptop.setRamSize(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the RAM size - GB")));
		laptop.setHdSize(
				Double.parseDouble(JOptionPane.showInputDialog("Insert the HD size - GB")));
		return laptop;
	}
}
