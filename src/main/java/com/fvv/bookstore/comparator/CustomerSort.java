package com.fvv.bookstore.comparator;

import java.util.Comparator;

import com.fvv.bookstore.bean.Customer;

/**
 * Customer sort by name.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class CustomerSort implements Comparator<Customer> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(final Customer c1, final Customer c2) {
		return c1.getName().compareToIgnoreCase(c2.getName());
	}

}
