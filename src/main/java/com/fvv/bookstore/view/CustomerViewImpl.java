package com.fvv.bookstore.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.fvv.bookstore.bean.Customer;
import com.fvv.bookstore.controller.CustomerController;
import com.fvv.bookstore.controller.CustomerControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.exception.person.PersonValidationException;
import com.fvv.bookstore.util.Constants;
import com.fvv.bookstore.util.PropertiesUtil;
import com.fvv.bookstore.util.StringUtil;

/**
 * CustomerView class to view the Customer object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class CustomerViewImpl implements CustomerView {
	
	private final CustomerController customerController;
	
	/**
	 * Class constructor instantiating a new CustomerControllerImpl object.
	 */
	public CustomerViewImpl() {
		this.customerController = new CustomerControllerImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addCustomer() {
		try {
			final Customer customer = this.createCustomerFromInput(Boolean.FALSE);
			this.customerController.addCustomer(customer);
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("customerAdd"));	
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("problemsToConvert") + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | PersonNotFoundException | PersonValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void listCustomers() {
		try {
			StringBuilder sb = new StringBuilder();
			List<Customer> customers = this.customerController.listCustomers();
			if(customers != null && !customers.isEmpty()) {
				for(Customer c : customers) {
					sb.append(c).append(Constants.LINE_SEPARATOR);
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing All Customers", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, PropertiesUtil.get("noItems"));
			}			
		} catch (ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCustomer() {
		try {
			final Customer customer = this.createCustomerFromInput(Boolean.TRUE);
			this.customerController.updateCustomer(customer);
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("customerUpdated"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("problemsToConvert") + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | PersonNotFoundException | PersonValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeCustomer() {
		try {
			Long idDelete = (Long.parseLong(JOptionPane.showInputDialog(
					"Insert the ID to delete")));
			this.customerController.findCustomer(idDelete);
			this.customerController.removeCustomer(idDelete);
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("deletedOk"));			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("problemsToConvert") + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (PersonNotFoundException | ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private Customer createCustomerFromInput(final boolean isUpdate) 
			throws PersonNotFoundException, ControllerException {
		final Customer customer = new Customer();
		
		if(isUpdate) {
			Long idUp = Long.parseLong(JOptionPane.showInputDialog("Insert the ID to update"));
			this.customerController.findCustomer(idUp);
			customer.setId(idUp);
		}
		
		customer.setName(JOptionPane.showInputDialog("Insert the full name"));
		customer.setEmail(JOptionPane.showInputDialog("Insert the email"));
		customer.setPhone(JOptionPane.showInputDialog("Insert the phone"));
		customer.setCpf(JOptionPane.showInputDialog("Insert the CPF"));
		customer.setProdPref(StringUtil.convertStringToList(JOptionPane.showInputDialog(
				"Insert the products of preference. Use ',' to separate"), Constants.COMMA));
		return customer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void listCustomersByName() {
		try {
			StringBuilder sb = new StringBuilder();
			String searchName = JOptionPane.showInputDialog("Insert a name to find");
			List<Customer> customers = this.customerController.listCustomersByName(searchName);
			if(customers != null && !customers.isEmpty()) {
				for(Customer cus : customers) {
					sb.append(cus).append(Constants.LINE_SEPARATOR);
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing the Customers", 
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "There are no items to show!");
			}			
		} catch (ControllerException | PersonNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
