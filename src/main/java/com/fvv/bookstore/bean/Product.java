package com.fvv.bookstore.bean;

import java.util.Date;

/**
 * Bean abstract class for a Product object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public abstract class Product {

	private Long id;
	private Double unitPrice;
	private Integer stockQty;
	private Date modificationDate;
	
	/**
	 * Class constructor specifying the attributes
	 * 
	 * @param id of the Product
	 * @param unitPrice of the Product
	 * @param stockQty of the Product
	 * @param modificationDate of the Product
	 */
	Product(final Long id, final Double unitPrice, final Integer stockQty, 
			final Date modificationDate) {
		this.id = id;
		this.unitPrice = unitPrice;
		this.stockQty = stockQty;
		this.modificationDate = modificationDate;
	}
	
	/**
	 * Class constructor
	 */
	Product() {
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
	 * Sets the unit price.
	 * 
	 * @param unitPrice of Double type.
	 */
	public void setUnitPrice(final Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Gets the unit price.
	 * 
	 * @return the unitPrice of Double type.
	 */
	public Double getUnitPrice() {
		return this.unitPrice;
	}

	/**
	 * Sets the stock quantity.
	 * 
	 * @param stockQty of Integer type.
	 */
	public void setStockQty(final Integer stockQty) {
		this.stockQty = stockQty;
	}

	/**
	 * Gets the stock quantity.
	 * 
	 * @return the stockQty of Integer type.
	 */
	public Integer getStockQty() {
		return this.stockQty;
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
	 * @return the modificationDate of Date type.
	 */
	public Date getModificationDate() {
		return this.modificationDate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}	
}
