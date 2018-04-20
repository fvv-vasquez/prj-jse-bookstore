package com.fvv.bookstore.view;

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
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.util.Constants;

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
			JOptionPane.showMessageDialog(null, "Order added successfully!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value:" + Constants.LINE_SEPARATOR
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | OrderValidationException | PersonNotFoundException e) {
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
		
		order.setOrderItems(this.createOrderItemFromInput());
				
		return order;
	}
	
	/**
	 * Creating a list of order items from the input.
	 * 
	 * @return a list of order items.
	 * @throws ControllerException when a problem in controller happens.
	 */
	private List<OrderItem> createOrderItemFromInput() throws ControllerException {
		final List<OrderItem> items = new ArrayList<OrderItem>();
		Character addMoreItems = 'y';
		
		while(addMoreItems == 'y') {
			final OrderItem orderItem = new OrderItem();
			String input = JOptionPane.showInputDialog(
					"Insert the Product type:" + Constants.LINE_SEPARATOR + 
					"1 - Book" + Constants.LINE_SEPARATOR +
					"2 - Cellphone" + Constants.LINE_SEPARATOR +
					"3 - DVD" + Constants.LINE_SEPARATOR +
					"4 - Laptop" + Constants.LINE_SEPARATOR +
					"5 - Magazine" + Constants.LINE_SEPARATOR
			);
			switch(input.charAt(0)) {
				case '1' : final Book book = this.findBookByTitle();
					if (book != null) {
						orderItem.setProduct(book);
						orderItem.setQuantity(Integer.parseInt(JOptionPane.showInputDialog(
								"Insert the quantity")));
					} else {
						JOptionPane.showMessageDialog(null, "Field title cannot be null");
					}
					break;
				case '2' : final Cellphone cellphone = this.findCellphoneByBrand();
					if (cellphone != null) {
						orderItem.setProduct(cellphone);
						orderItem.setQuantity(Integer.parseInt(JOptionPane.showInputDialog(
								"Insert the quantity")));
					} else {
						JOptionPane.showMessageDialog(null, "Field brand cannot be null");
					}
					break;
				case '3' : final Dvd dvd = this.findDvdByTitle();
					if (dvd != null) {
						orderItem.setProduct(dvd);
						orderItem.setQuantity(Integer.parseInt(JOptionPane.showInputDialog(
								"Insert the quantity")));
					} else {
						JOptionPane.showMessageDialog(null, "Field title cannot be null");
					}
					break;
				case '4' : final Laptop laptop = this.findLaptopByBrand();
					if (laptop != null) {
						orderItem.setProduct(laptop);
						orderItem.setQuantity(Integer.parseInt(JOptionPane.showInputDialog(
								"Insert the quantity")));
					} else {
						JOptionPane.showMessageDialog(null, "Field brand cannot be null");
					}
					break;
				case '5' : final Magazine magazine = this.findMagazineByName();
					if (magazine != null) {
						orderItem.setProduct(magazine);
						orderItem.setQuantity(Integer.parseInt(JOptionPane.showInputDialog(
								"Insert the quantity")));
					} else {
						JOptionPane.showMessageDialog(null, "Field name cannot be null");
					}
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			items.add(orderItem);
			addMoreItems = JOptionPane.showInputDialog(
					"Wanna add more products?" + Constants.LINE_SEPARATOR +
					"y = yes" + Constants.LINE_SEPARATOR +
					"n = no").charAt(0);
		}
		return items;
	}
	
	/**
	 * Search a book by the title.
	 * 
	 * @return a book.
	 */
	private Book findBookByTitle() {
		try {
			final Book book = this.bookController.findBookByTitle(
					JOptionPane.showInputDialog("Insert the book title"));
			return book;
		} catch (ControllerException | BookNotFoundException e) {
			System.err.print(e);
		}
		return null;
	}
	
	/**
	 * Search a cellphone by the brand.
	 * 
	 * @return a cellphone.
	 */
	private Cellphone findCellphoneByBrand() {
		try {
			final Cellphone cellphone = this.cellphoneController.findCellphoneByBrand(
					JOptionPane.showInputDialog("Insert the cellphone brand"));
			return cellphone;
		} catch (ControllerException | HardwareNotFoundException e) {
			System.err.print(e);
		}
		return null;
	}
	
	/**
	 * Search a dvd by the title.
	 * 
	 * @return a dvd.
	 */
	private Dvd findDvdByTitle() {
		try {
			final Dvd dvd = this.dvdController.findDvdByTitle(
					JOptionPane.showInputDialog("Insert the dvd title"));
			return dvd;
		} catch (ControllerException | DvdNotFoundException e) {
			System.err.print(e);
		}
		return null;
	}
	
	/**
	 * Search a laptop by the brand.
	 * 
	 * @return a laptop.
	 */
	private Laptop findLaptopByBrand() {
		try {
			final Laptop laptop = this.laptopController.findLaptopByBrand(
					JOptionPane.showInputDialog("Insert the laptop brand"));
			return laptop;
		} catch (ControllerException | HardwareNotFoundException e) {
			System.err.print(e);
		}
		return null;
	}
	
	/**
	 * Search a magazine by the name.
	 * 
	 * @return a magazine.
	 */
	private Magazine findMagazineByName() {
		try {
			final Magazine magazine = this.magazineController.findMagazineByName(
					JOptionPane.showInputDialog("Insert the magazine name"));
			return magazine;
		} catch (ControllerException | MagazineNotFoundException e) {
			System.err.print(e);
		}
		return null;
	}
}
