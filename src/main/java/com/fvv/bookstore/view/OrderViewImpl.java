package com.fvv.bookstore.view;

import java.awt.HeadlessException;
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
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.book.BookNotFoundException;
import com.fvv.bookstore.exception.dvd.DvdNotFoundException;
import com.fvv.bookstore.exception.hardware.HardwareNotFoundException;
import com.fvv.bookstore.exception.magazine.MagazineNotFoundException;
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
		// TODO Auto-generated method stub

	}

	private Order createOrderFromInput() throws ControllerException, PersonNotFoundException {
		final Order order = new Order();
		
		final Employee employee = this.employeeController.findEmployee(
				Long.parseLong(JOptionPane.showInputDialog("Insert the employee ID")));
		order.setEmployee(employee);
		
		final Customer customer = this.customerController.findCustomer(
				Long.parseLong(JOptionPane.showInputDialog("Insert the customer ID")));
		order.setCustomer(customer);
		
		return order;
	}
	
	private OrderItem createOrderItemFromInput() throws ControllerException {
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
				} else {
					JOptionPane.showMessageDialog(null, "Book: " + book + "not found");
				}
				break;
			case '2' : final Cellphone cellphone = this.findCellphoneByBrand();
				if (cellphone != null) {
					orderItem.setProduct(cellphone);
				} else {
					JOptionPane.showMessageDialog(null, "Cellphone: " + cellphone + "not found");
				}
				break;
			case '3' : final Dvd dvd = this.findDvdByTitle();
				if (dvd != null) {
					orderItem.setProduct(dvd);
				} else {
					JOptionPane.showMessageDialog(null, "DVD: " + dvd + "not found");
				}
				break;
			case '4' : final Laptop laptop = this.findLaptopByBrand();
				if (laptop != null) {
					orderItem.setProduct(laptop);
				} else {
					JOptionPane.showMessageDialog(null, "Laptop: " + laptop + "not found");
				}
				break;
			case '5' : final Magazine magazine = this.findMagazineByName();
				if (magazine != null) {
					orderItem.setProduct(magazine);
				} else {
					JOptionPane.showMessageDialog(null, "Magazine: " + magazine + "not found");
				}
				break;
			default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
					"Error", JOptionPane.ERROR_MESSAGE);
		}	
		return orderItem;
	}
	
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
