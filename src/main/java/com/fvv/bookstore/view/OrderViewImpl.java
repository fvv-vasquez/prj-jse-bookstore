package com.fvv.bookstore.view;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.bean.Cellphone;
import com.fvv.bookstore.bean.Customer;
import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.bean.Laptop;
import com.fvv.bookstore.bean.Magazine;
import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.bean.OrderItem;
import com.fvv.bookstore.bean.Product;
import com.fvv.bookstore.controller.BookController;
import com.fvv.bookstore.controller.BookControllerImpl;
import com.fvv.bookstore.controller.CellphoneController;
import com.fvv.bookstore.controller.CellphoneControllerImpl;
import com.fvv.bookstore.controller.CustomerController;
import com.fvv.bookstore.controller.CustomerControllerImpl;
import com.fvv.bookstore.controller.DvdController;
import com.fvv.bookstore.controller.DvdControllerImpl;
import com.fvv.bookstore.controller.EmployeeController;
import com.fvv.bookstore.controller.EmployeeControllerImpl;
import com.fvv.bookstore.controller.LaptopController;
import com.fvv.bookstore.controller.LaptopControllerImpl;
import com.fvv.bookstore.controller.MagazineController;
import com.fvv.bookstore.controller.MagazineControllerImpl;
import com.fvv.bookstore.controller.OrderController;
import com.fvv.bookstore.controller.OrderControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.book.BookNotFoundException;
import com.fvv.bookstore.exception.dvd.DvdNotFoundException;
import com.fvv.bookstore.exception.hardware.HardwareNotFoundException;
import com.fvv.bookstore.exception.magazine.MagazineNotFoundException;
import com.fvv.bookstore.exception.order.OrderNotFoundException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.util.Constants;
import com.fvv.bookstore.util.DateUtil;
import com.fvv.bookstore.util.MathUtil;
import com.fvv.bookstore.util.OrderViewUtil;
import com.fvv.bookstore.util.PropertiesUtil;

/**
 * OrderView class to view the Order object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class OrderViewImpl implements OrderView {
	
	private final OrderController orderController;
	private final EmployeeController employeeController;
	private final CustomerController customerController;
	private final BookController bookController;
	private final CellphoneController cellphoneController;
	private final DvdController dvdController;
	private final LaptopController laptopController;
	private final MagazineController magazineController;
	private List<OrderItem> items;
	
	/**
	 * Class constructor instantiating a new Controller objects.
	 */
	public OrderViewImpl() {
		this.orderController = new OrderControllerImpl();
		this.employeeController = new EmployeeControllerImpl();
		this.customerController = new CustomerControllerImpl();
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
	public void addOrder() {
		try {
			final Order order = this.createOrderFromInput();
			this.orderController.addOrder(order);
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("orderAdd"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("problemsToConvert") + Constants.LINE_SEPARATOR
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | OrderValidationException | PersonNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void listTotalOrdersMonth() {
		try {
			StringBuilder sb = new StringBuilder();
			final YearMonth date = YearMonth.parse(JOptionPane.showInputDialog("Insert the date (yyyy-mm)"));
			List<Order> orders = this.orderController.listTotalOrdersByMonth(date);
			if(orders != null && !orders.isEmpty()) {
				Integer quantity = this.orderController.calculateQtyOrders(orders);
				Double amount = this.orderController.calculateTotalOrders(orders);
				sb.append("Amount of orders: ").append(quantity).append(" - Amount in the month: ").append(MathUtil.formatNumbers(amount))
				.append(Constants.LINE_SEPARATOR).append(Constants.LINE_SEPARATOR);
				for(Order ord : orders) {
					sb.append("Date: ").append(DateUtil.dateToString(ord.getCreationDate())).append(" - Order: ").append(ord.getId()).
					append(" - Order Amount: ").append(MathUtil.formatNumbers(ord.getOrderAmount())).append(Constants.LINE_SEPARATOR).append("Employee: ").
					append(ord.getEmployee().getId()).append(" - Name: ").append(ord.getEmployee().getName()).append(", Customer: ").
					append(ord.getCustomer().getId()).append(" - Name: ").append(ord.getCustomer().getName()).append(Constants.LINE_SEPARATOR).
					append(Constants.LINE_SEPARATOR);
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing the Orders of the Date: " + date, 
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "There are no items to show!");
			}			
		} catch (ControllerException | OrderNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void listTotalSalesPerSeller() {
		try {
			StringBuilder sb = new StringBuilder();
			Long idSearch = Long.parseLong(JOptionPane.showInputDialog("Insert the employee ID to search"));
			Employee employee = this.employeeController.findEmployee(idSearch);
			List<Order> orders = this.orderController.listTotalSalesPerSeller(employee);
			
			if(orders != null && !orders.isEmpty()) {
				Integer quantity = this.orderController.calculateQtyOrders(orders);
				Double amount = this.orderController.calculateTotalOrders(orders);
				sb.append("Employee: ").append(employee.getId()).append(" - Name: ").append(employee.getName()).append(Constants.LINE_SEPARATOR)
				.append("Amount of orders: ").append(quantity).append(" - Amount in the period: ").append(MathUtil.formatNumbers(amount))
				.append(Constants.LINE_SEPARATOR).append(Constants.LINE_SEPARATOR);
				
				for(Order ord : orders) {
					sb.append("Order: ").append(ord.getId()).append(" - Order Amount: ").append(MathUtil.formatNumbers(ord.getOrderAmount()))
					.append(" - Customer: ").append(ord.getCustomer().getId()).append(" - Name: ").append(ord.getCustomer().getName())
					.append(Constants.LINE_SEPARATOR).append(Constants.LINE_SEPARATOR);
				}
				
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing the Orders of the Employee: " + idSearch, 
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "There are no items to show!");
			}			
		} catch (ControllerException | PersonNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void listOrderByOrderId() {
		try {
			StringBuilder sb = new StringBuilder();
			Long idSearch = Long.parseLong(JOptionPane.showInputDialog("Insert the Order ID to list"));
			Order order = this.orderController.listOrderByOrderId(idSearch);
			List<OrderItem> items = order.getOrderItems();
			if(order != null) {
				sb.append("Order: ").append(order.getId()).append(" - Amount: ").append(MathUtil.formatNumbers(order.getOrderAmount()))
				.append(" - Date: ").append(DateUtil.dateToString(order.getCreationDate())).append(Constants.LINE_SEPARATOR).append("Employee: ")
				.append(order.getEmployee().getId()).append(" - Name: ").append(order.getEmployee().getName()).append(", Customer: ")
				.append(order.getCustomer().getId()).append(" - Name: ").append(order.getCustomer().getName()).append(Constants.LINE_SEPARATOR)
				.append(Constants.LINE_SEPARATOR);
				
				for(OrderItem orderItem : items) {
					sb.append("Product ID: ").append(orderItem.getProduct().getId()).append(" - Description: ")
					.append(OrderViewUtil.resolveProperDescription(orderItem.getProduct())).append(" - Quantity: ").append(orderItem.getQuantity())
					.append(" - Unit Price: ").append(MathUtil.formatNumbers(orderItem.getItemAmount())).append(Constants.LINE_SEPARATOR).append(Constants.LINE_SEPARATOR);
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing the Order: " + idSearch, 
						JOptionPane.PLAIN_MESSAGE);
			}	
		} catch (ControllerException | OrderNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Creating an order from the input.
	 * 
	 * @return an Order.
	 * @throws ControllerException when a problem in controller happens.
	 * @throws PersonNotFoundException when a person is not found.
	 */
	private Order createOrderFromInput() throws ControllerException, PersonNotFoundException {
		final Order order = new Order();
		
		final Employee employee = this.employeeController.findEmployee(
				Long.parseLong(JOptionPane.showInputDialog("Insert the employee ID")));
		order.setEmployee(employee);
		
		final Customer customer = this.customerController.findCustomer(
				Long.parseLong(JOptionPane.showInputDialog("Insert the customer ID")));
		order.setCustomer(customer);
		
		order.setOrderItems(this.createOrderItemsFromInput());
				
		return order;
	}
	
	/**
	 * Creating a list of order items from the input.
	 * 
	 * @return a list of order items.
	 */
	private List<OrderItem> createOrderItemsFromInput() {
		this.items = new ArrayList<>();
		Character addMoreItems = Constants.YES;
		boolean isOrderItemAdded = Boolean.FALSE;
		
		while(addMoreItems == Constants.YES) {
			String input = JOptionPane.showInputDialog(
					"Insert the Product type:" + Constants.LINE_SEPARATOR + 
					"1 - Book" + Constants.LINE_SEPARATOR +
					"2 - Cellphone" + Constants.LINE_SEPARATOR +
					"3 - DVD" + Constants.LINE_SEPARATOR +
					"4 - Laptop" + Constants.LINE_SEPARATOR +
					"5 - Magazine" + Constants.LINE_SEPARATOR
			);
			switch(input.charAt(0)) {
				case '1' : 
					isOrderItemAdded = this.addOrderItemByProductType(Book.class); 
					break;
				case '2' : 
					isOrderItemAdded = this.addOrderItemByProductType(Cellphone.class);
					break;
				case '3' : 
					isOrderItemAdded = this.addOrderItemByProductType(Dvd.class);
					break;
				case '4' : 
					isOrderItemAdded = this.addOrderItemByProductType(Laptop.class);
					break;
				case '5' : 
					isOrderItemAdded = this.addOrderItemByProductType(Magazine.class);
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			if (isOrderItemAdded) {
				addMoreItems = JOptionPane.showInputDialog(
						"Wanna add more products?" + Constants.LINE_SEPARATOR +
						"y = yes" + Constants.LINE_SEPARATOR +
						"n = no").charAt(0);
			}							
		}
		return items;
	}
	
	/**
	 * Add an order item to an order item list.
	 * 
	 * @param product of Product type.
	 * @return true if the order item was add to the list, otherwise, return false.
	 */
	private boolean addOrderItemToOrderItemsList(final Product product) {
		boolean isOrderItemAdded = Boolean.FALSE;
		if (!this.isProductExistsInOrderItemsList(this.items, product)) {																					
			if(product.getStockQty() > 0) {
				final Integer amount = Integer.parseInt(JOptionPane.showInputDialog("Insert the quantity"));
				if(product.getStockQty() >= amount) {
					OrderItem orderItem = new OrderItem();
					orderItem.setProduct(product);
					orderItem.setQuantity(amount);
					this.items.add(orderItem);
					isOrderItemAdded = Boolean.TRUE;
				} else {
					JOptionPane.showMessageDialog(null, "Quantity in stock is not enough." + 
							Constants.LINE_SEPARATOR + "Choose less items please");
				}
			} else {
				JOptionPane.showMessageDialog(null, "There is no stock left for the selected item." + 
						Constants.LINE_SEPARATOR + "Choose another one please");
			}							
		} else {
			JOptionPane.showMessageDialog(null, "Product already in the list");	
		}
		return isOrderItemAdded;
	}
	
	/**
	 * Verify if the product already exists in the database.
	 * 
	 * @param items of an order item list.
	 * @param productToAdd of Product type.
	 * @return true if a product already exists in the order item, otherwise, return false.
	 */
	private boolean isProductExistsInOrderItemsList(final List<OrderItem> items, final Product productToAdd) {
		if (items.size() > 0) {
			for (OrderItem orderItem : items) {
				Product product = orderItem.getProduct();
				if (product.equals(productToAdd)) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}
	
	/**
	 * Add an order item by product type.
	 * 
	 * @param clazz object to identify the type of product.
	 * @return true if an order item was add, otherwise, return false.
	 */
	@SuppressWarnings("rawtypes") 
	private boolean addOrderItemByProductType(final Class clazz) {
		boolean isOrderItemAdded = Boolean.FALSE;
		final Product product = this.findProductByType(clazz, 
				JOptionPane.showInputDialog("Insert the " + clazz.getSimpleName() + " " + OrderViewUtil.resolveProperValueByType(clazz)));
		if (product != null) {
			isOrderItemAdded = this.addOrderItemToOrderItemsList(product);
		} else {
			JOptionPane.showMessageDialog(null, clazz.getSimpleName() + " not found");
		}
		return isOrderItemAdded;
	}
	
	/**
	 * Find a product by type.
	 * 
	 * @param clazz object to identify the type of product.
	 * @param value from the input to find the product.
	 * @return a product.
	 */
	@SuppressWarnings("rawtypes") 
	private Product findProductByType(final Class clazz, final String value) {
		Product product = null;
		try {
			if (clazz == Book.class) {
				product = this.bookController.findBookByTitle(value);
			} else if (clazz == Cellphone.class) {
				product = this.cellphoneController.findCellphoneByBrand(value);
			} else if (clazz == Dvd.class) {
				product = this.dvdController.findDvdByTitle(value);
			} else if (clazz == Laptop.class) {
				product = this.laptopController.findLaptopByBrand(value);
			} else if (clazz == Magazine.class) {
				product = this.magazineController.findMagazineByName(value);
			}
		} catch (ControllerException | BookNotFoundException | HardwareNotFoundException 
				| DvdNotFoundException | MagazineNotFoundException e) {
			System.err.print(e);
		}
		return product;
	}
}
