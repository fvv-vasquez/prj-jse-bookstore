package com.fvv.bookstore.view;

import java.util.List;

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
		try {
			StringBuilder sb = new StringBuilder();
			List<Laptop> laptops = this.laptopController.listLaptops();
			if(laptops != null && !laptops.isEmpty()) {
				for(Laptop c : laptops) {
					sb.append(c).append(Constants.LINE_SEPARATOR);
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing All Laptops", 
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
	public void updateLaptop() {
		try {
			final Laptop laptop = this.createLaptopFromInput(Boolean.TRUE);
			this.laptopController.updateLaptop(laptop);
			JOptionPane.showMessageDialog(null, "Laptop updated successfully!");
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
	public void removeLaptop() {
		try {
			Long idDelete = (Long.parseLong(JOptionPane.showInputDialog(
					"Insert the ID to delete")));
			this.laptopController.findLaptop(idDelete);
			this.laptopController.removeLaptop(idDelete);
			JOptionPane.showMessageDialog(null, "Deleted successfully!");			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value: " + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (HardwareNotFoundException | ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
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
		laptop.setUnitPrice(
				Double.parseDouble(JOptionPane.showInputDialog("Insert the price")));
		laptop.setWarranty(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the warranty in months")));
		laptop.setRamSize(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the RAM size - GB")));
		laptop.setHdSize(
				Double.parseDouble(JOptionPane.showInputDialog("Insert the HD size - GB")));
		laptop.setProcessor(JOptionPane.showInputDialog("Insert the processor"));
		laptop.setStockQty(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the quantity in stock")));
		return laptop;
	}
}
