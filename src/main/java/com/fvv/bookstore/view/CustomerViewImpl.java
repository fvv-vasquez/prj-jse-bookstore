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
			JOptionPane.showMessageDialog(null, "Customer added successfully!");	
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value: " + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | PersonNotFoundException | PersonValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing All Customers", 
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
	public void updateCustomer() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeCustomer() {
		// TODO Auto-generated method stub

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
}
