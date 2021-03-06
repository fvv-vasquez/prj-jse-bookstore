package com.fvv.bookstore.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fvv.bookstore.util.DateUtil;
import com.fvv.bookstore.util.MathUtil;

/**
 * Bean class for an Order object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Employee employee;
	private Customer customer;
	private List<OrderItem> orderItems;
	private Date creationDate;
	private Double orderAmount;
	
	/**
	 * Class constructor specifying the attributes
	 * 
	 * @param id of the Order
	 * @param employee of the Order
	 * @param customer of the Order
	 * @param date of the Order
	 * @param amount of the Order
	 */
	public Order(final Long id, final Employee employee, final Customer customer, 
			final Date date, final Double amount) {
		this.id = id;
		this.employee = employee;
		this.customer = customer;
		this.creationDate = date;
		this.orderAmount = amount;
	}
	
	/**
	 * Class constructor
	 */
	public Order() {
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
	 * Sets the employee.
	 * 
	 * @param employee of Employee type.
	 */
	public void setEmployee(final Employee employee) {
		this.employee = employee;
	}

	/**
	 * Gets the employee.
	 * 
	 * @return the employee of Employee type.
	 */
	public Employee getEmployee() {
		return this.employee;
	}

	/**
	 * Sets the customer.
	 * 
	 * @param customer of Customer type.
	 */
	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}

	/**
	 * Gets the customer.
	 * 
	 * @return the customer of Customer type.
	 */
	public Customer getCustomer() {
		return this.customer;
	}

	/**
	 * Sets the items of an order.
	 * 
	 * @param itemsOrder of List<> type.
	 */
	public void setOrderItems(final List<OrderItem> itemsOrder) {
		this.orderItems = itemsOrder;
	}

	/**
	 * Gets the items of an order.
	 * 
	 * @return the itemsOrder list of List<> type.
	 */
	public List<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	/**
	 * Sets the creation date.
	 * 
	 * @param creationDate of Date type.
	 */
	public void setCreationDate(final Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the creation date.
	 * 
	 * @return the creationDate of Date type.
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * Sets the order amount.
	 * 
	 * @param orderAmount of Double type.
	 */
	public void setOrderAmount(final Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	/**
	 * Gets the order amount.
	 * 
	 * @return the orderAmount of Double type.
	 */
	public Double getOrderAmount() {
		return this.orderAmount;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order ID: " + getId() + " - Customer: " + getCustomer() + ", Employee: " + getEmployee() 
			+ ", Order Amount: " + MathUtil.formatNumbers(getOrderAmount()) + ", Date: " + DateUtil.dateToString(getCreationDate());
	}
}
