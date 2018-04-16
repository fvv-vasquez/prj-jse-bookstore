package com.fvv.bookstore.bean;

import java.util.Date;
import java.util.List;

/**
 * Bean class for an Order object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class Order {

	private Long id;
	private Employee employee;
	private Customer customer;
	private List<OrderItem> itemsOrder;
	private Date date;
	private Double orderAmount;
	
	/**
	 * Class constructor specifying the attributes
	 * 
	 * @param id of the Order
	 * @param employee of the Order
	 * @param customer of the Order
	 * @param itemsOrder of the Order
	 * @param date of the Order
	 * @param amount of the Order
	 */
	public Order(final Long id, final Employee employee, final Customer customer, 
			final List<OrderItem> itemsOrder, final Date date, final Double amount) {
		this.id = id;
		this.employee = employee;
		this.customer = customer;
		this.itemsOrder = itemsOrder;
		this.date = date;
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
	public void setItemsOrder(final List<OrderItem> itemsOrder) {
		this.itemsOrder = itemsOrder;
	}

	/**
	 * Gets the items of an order.
	 * 
	 * @return the itemsOrder list of List<> type.
	 */
	public List<OrderItem> getItemsOrder() {
		return this.itemsOrder;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date of Date type.
	 */
	public void setDate(final Date date) {
		this.date = date;
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date of Date type.
	 */
	public Date getDate() {
		return this.date;
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
		return "Order ID: " + getId() + " - Customer: " + getCustomer() + ", Employee: " +
				getEmployee() + ", Order Amount: " + getOrderAmount() + ", Date: " + getDate();
	}
}
