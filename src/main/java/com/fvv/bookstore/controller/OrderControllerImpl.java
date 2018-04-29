package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.bean.Cellphone;
import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.bean.Laptop;
import com.fvv.bookstore.bean.Magazine;
import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.bean.OrderItem;
import com.fvv.bookstore.dao.OrderDAO;
import com.fvv.bookstore.dao.OrderDAOImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.util.CollectionsUtil;
import com.fvv.bookstore.util.Constants;
import com.fvv.bookstore.util.MathUtil;

/**
 * Controller class for an Order object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class OrderControllerImpl implements OrderController {
	
	private final OrderDAO orderDao;
	private final BookController bookController;
	private final CellphoneController cellphoneController;
	private final DvdController dvdController;
	private final LaptopController laptopController;
	private final MagazineController magazineController;
	
	/**
	 * Class constructor instantiating a new OrderDAOImpl object.
	 */
	public OrderControllerImpl() {
		this.orderDao = new OrderDAOImpl();
		this.bookController = new BookControllerImpl();
		this.cellphoneController = new CellphoneControllerImpl();
		this.dvdController = new DvdControllerImpl();
		this.laptopController = new LaptopControllerImpl();
		this.magazineController = new MagazineControllerImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addOrder(final Order order) throws OrderValidationException, ControllerException {
		try {
			this.validateOrder(order);
			
			for (OrderItem orderItem : order.getOrderItems()) {
				orderItem.setItemAmount(this.calculateItemAmount(orderItem.getQuantity(), 
						orderItem.getProduct().getUnitPrice()));
			}
			
			order.setOrderAmount(this.calculateTotalOrderAmount(order.getOrderItems()));
			
			this.orderDao.addOrder(order);
			
			this.calculateNewStockAmount(order);
			
		} catch (DaoException e) {
			throw new ControllerException("Error to add an order", e);
		}
	}
	
	/**
	 * Validate if a field in the order is empty.
	 * 
	 * @param order of Order type.
	 * @throws OrderValidationException if a field is empty.
	 */
	private void validateOrder(final Order order) throws OrderValidationException {
		StringBuilder sb = new StringBuilder();
		
		if (order.getEmployee() == null) {
			sb.append("Field employee cannot be null").append(Constants.LINE_SEPARATOR);
		} else {
			if(order.getEmployee().getId() <= 0) {
				sb.append("Field employee ID cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
			}
		}
		
		if(order.getCustomer() == null) {
			sb.append("Field customer cannot be null").append(Constants.LINE_SEPARATOR);
		} else {
			if(order.getCustomer().getId() <= 0) {
				sb.append("Field customer ID cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
			}
		}
		
		sb.append(this.validateOrderItem(order.getOrderItems()));
		
		if(sb.length() > 0) {
			throw new OrderValidationException(sb.toString());
		}
	}
	/**
	 * Validate if a field in the order item is empty.
	 * 
	 * @param orderItems of List<OrderItem> type.
	 * @return a String.
	 */
	private String validateOrderItem(final List<OrderItem> orderItems) {
		StringBuilder sb = new StringBuilder();
		
		if(CollectionsUtil.isNullOrEmpty(orderItems)) {
			sb.append("Field order items cannot be empty").append(Constants.LINE_SEPARATOR);
		}
		
		for (OrderItem orderItem : orderItems) {
			if(orderItem.getProduct() == null) {
				sb.append("Field product cannot be null").append(Constants.LINE_SEPARATOR);
			} else {
				if(orderItem.getProduct().getId() <= 0) {
					sb.append("Field product ID cannot be smaller than 0.").append(
							Constants.LINE_SEPARATOR);
				}			
			}
			
			if(orderItem.getQuantity() <= 0) {
				sb.append("Field quantity cannot be smaller than 0.").append(
						Constants.LINE_SEPARATOR);
			}
			
			if(orderItem.getProduct().getStockQty() <= 0) {
				sb.append("Quantity in stock is 0").append(Constants.LINE_SEPARATOR);
			}
			
			if(orderItem.getQuantity() > orderItem.getProduct().getStockQty()) {
				sb.append("Quantity in stock is not enough").append(Constants.LINE_SEPARATOR);
			}
		}
		return sb.toString();
	}
	
	/**
	 * Calculate the item amount.
	 * 
	 * @param itemsAmount of Integer type.
	 * @param individualPrice of Double type.
	 * @return the amount of Double type.
	 */
	private Double calculateItemAmount(final Integer itemsAmount, final Double individualPrice) {
		Double amount = itemsAmount * individualPrice;
		return MathUtil.round(amount, 2);
	}
	
	/**
	 * Calculate the total of order amount.
	 * 
	 * @param orderItems of List<OrderItem> type.
	 * @return the amount of Double type.
	 */
	private Double calculateTotalOrderAmount(final List<OrderItem> orderItems) {
		Double amount = 0.0;
		for (OrderItem oi : orderItems) {
			amount += oi.getItemAmount();
		}
		return MathUtil.round(amount, Constants.PRECISION);
	}
	
	/**
	 * Calculate the stock amount.
	 * 
	 * @param currentStockAmount of Product type.
	 * @param quantityBought of Integer type.
	 * @return the quantity to reduce in database.
	 */
	private Integer calculateStockAmount(final Integer currentStockAmount, final Integer quantityBought) {
		return currentStockAmount - quantityBought;
	}
	
	/**
	 * Calculate the new stock amount.
	 * 
	 * @param order of Order type.
	 * @throws ControllerException when a problem in controller happens.
	 */
	private void calculateNewStockAmount(final Order order) throws ControllerException {
		for (OrderItem items : order.getOrderItems()) {
			final Integer newStockQty = this.calculateStockAmount(items.getProduct().getStockQty(), items.getQuantity());
			
			if (items.getProduct() instanceof Book) {
				this.bookController.reduceStockItem((Book) items.getProduct(), newStockQty);
			}
			if (items.getProduct() instanceof Cellphone) {
				this.cellphoneController.reduceStockItem((Cellphone) items.getProduct(), newStockQty);
			}
			if (items.getProduct() instanceof Dvd) {
				this.dvdController.reduceStockItem((Dvd) items.getProduct(), newStockQty);
			}
			if (items.getProduct() instanceof Laptop) {
				this.laptopController.reduceStockItem((Laptop) items.getProduct(), newStockQty);
			}
			if (items.getProduct() instanceof Magazine) {
				this.magazineController.reduceStockItem((Magazine) items.getProduct(), newStockQty);
			}
		}
	}
}
