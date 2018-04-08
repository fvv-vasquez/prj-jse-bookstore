package com.fvv.bookstore.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Bean class for a Customer object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class Customer extends Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<String> prodPref;

	/**
	 * Class constructor specifying the attributes and with super from the Class Person
	 * @param id of the Customer
	 * @param name of the Customer
	 * @param email of the Customer
	 * @param phone of the Customer
	 * @param cpf of the Customer
	 * @param prodPref of the Customer
	 */
	public Customer(final Long id, final String name, final String email, final String phone, 
			final String cpf, final List<String> prodPref) {
		super(id, name, email, phone, cpf);
		this.prodPref = prodPref;
	}
	
	/**
	 * Class constructor
	 */
	public Customer() {
	}

	/**
	 * Sets the prodPref.
	 * 
	 * @param prodPref of List type.
	 */
	public void setProdPref(List<String> prodPref) {
		this.prodPref = prodPref;
	}

	/**
	 * Gets the last products preferences list.
	 *  
	 * @return the last list prodPref.
	 */
	public List<String> getProdPref() {
		return this.prodPref;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ID: " + getId() + " - Name: " + getName() + ", Email: " + getEmail() + 
				", Phone: " + getPhone();
	}

}
