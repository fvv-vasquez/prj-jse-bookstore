package com.fvv.bookstore.bean;

import java.io.Serializable;

/**
 * Bean class for an Employee object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class Employee extends Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private String position;
	private Double salary;
	
	/**
	 * Class constructor specifying the attributes and with super from the Class Person
	 * 
	 * @param id of the Employee
	 * @param name of the Employee
	 * @param email of the Employee
	 * @param phone of the Employee
	 * @param cpf of the Employee
	 * @param position of the Employee
	 * @param salary of the Employee
	 */
	public Employee(final Long id, final String name, final String email, final String phone, 
			final String cpf, final String position, final Double salary) {
		super(id, name, email, phone, cpf);
		this.position = position;
		this.salary = salary;
	}

	/**
	 * Class constructor
	 */
	public Employee() {	
	}
	
	/**
	 * Sets the position of an employee.
	 * 
	 * @param position of String type.
	 */
	public void setPosition(final String position) {
		this.position = position;
	}

	/**
	 * Gets the employee' position.
	 * 
	 * @return the position.
	 */
	public String getPosition() {
		return this.position;
	}

	/**
	 * Sets the salary of an employee.
	 * 
	 * @param salary of Double type.
	 */
	public void setSalary(final Double salary) {
		this.salary = salary;
	}

	/**
	 * Gets the employee' salary.
	 * 
	 * @return the salary.
	 */
	public Double getSalary() {
		return this.salary;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ID: " + getId() + " - Name: " + getName() + ", Phone: " + getPhone() +
				", Position: " + getPosition() + ", Salary: R$" + getSalary();
	}
}
