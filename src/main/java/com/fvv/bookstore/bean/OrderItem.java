package com.fvv.bookstore.bean;

import java.io.Serializable;

/**
 * Bean class for an Order Item object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private Product product;
	private Order order;
	private Integer quantity;
	private Double itemAmount;
	
	/**
	 * Class constructor specifying the attributes
	 * 
	 * @param product of the Order Item
	 * @param order of the Order Item
	 * @param quantity of the Order Item
	 * @param itemAmount of the Order Item
	 */
	public OrderItem(final Product product, final Order order, final Integer quantity, 
			final Double itemAmount) {
		this.product = product;
		this.order = order;
		this.quantity = quantity;
		this.itemAmount = itemAmount;
	}
	
	/**
	 * Class constructor
	 */
	public OrderItem() {
	}

	/**
	 * Sets the product.
	 * 
	 * @param product of Product type.
	 */
	public void setProduct(final Product product) {
		this.product = product;
	}

	/**
	 * Gets the product.
	 * 
	 * @return the product of Product type.
	 */
	public Product getProduct() {
		return this.product;
	}

	/**
	 * Sets the order.
	 * 
	 * @param order of Order type.
	 */
	public void setOrder(final Order order) {
		this.order = order;
	}

	/**
	 * Gets the order.
	 * 
	 * @return the order of Order type.
	 */
	public Order getOrder() {
		return this.order;
	}

	/**
	 * Sets the quantity.
	 * 
	 * @param quantity of Integer type.
	 */
	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the quantity.
	 * 
	 * @return the quantity of Integer type.
	 */
	public Integer getQuantity() {
		return this.quantity;
	}

	/**
	 * Sets the item amount.
	 * 
	 * @param itemAmount of Double type.
	 */
	public void setItemAmount(final Double itemAmount) {
		this.itemAmount = itemAmount;
	}

	/**
	 * Gets the item amount.
	 * 
	 * @return the itemAmount of Double type.
	 */
	public Double getItemAmount() {
		return this.itemAmount;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order: " + getOrder() + ", Product: " + getProduct() + ", Quantity: " + 
				getQuantity() + ", Item Amount: " + getItemAmount();
	}
}
