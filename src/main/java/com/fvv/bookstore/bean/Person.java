package com.fvv.bookstore.bean;

import java.util.Date;

/**
 * Bean abstract class for a Person object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public abstract class Person {
	
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String cpf;
	private Date modificationDate;
	
	/**
	 * Class constructor specifying the attributes
	 * 
	 * @param id of the person
	 * @param name of the person
	 * @param email of the person
	 * @param phone of the person
	 * @param cpf of the person
	 */
	public Person(final Long id, final String name, final String email, final String phone, 
			final String cpf) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
	}
	
	/**
	 * Class constructor
	 */
	public Person() {
	}

	/**
	 * Sets the id.
	 * 
	 * @param id of Long type.
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id of Long type.
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name of String type.
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name of String type.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email of String type.
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email of String type.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets the phone.
	 * 
	 * @param phone of String type.
	 */
	public void setPhone(final String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the phone.
	 * 
	 * @return the phone of String type.
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * Sets the cpf.
	 * 
	 * @param cpf of String type.
	 */
	public void setCpf(final String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the cpf.
	 * 
	 * @return the cpf of String type.
	 */
	public String getCpf() {
		return this.cpf;
	}
	
	/**
	 * Sets the modification date.
	 * 
	 * @param modificationDate of Date type.
	 */
	public void setModificationDate(final Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	/**
	 * Gets the modification date.
	 * 
	 * @return the modification date of Date type.
	 */
	public Date getModificationDate() {
		return this.modificationDate;
	}
}
