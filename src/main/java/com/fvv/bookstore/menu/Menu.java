package com.fvv.bookstore.menu;

import javax.swing.JOptionPane;

import com.fvv.bookstore.util.Constants;
import com.fvv.bookstore.view.BookView;
import com.fvv.bookstore.view.BookViewImpl;
import com.fvv.bookstore.view.CellphoneView;
import com.fvv.bookstore.view.CellphoneViewImpl;
import com.fvv.bookstore.view.CustomerView;
import com.fvv.bookstore.view.CustomerViewImpl;
import com.fvv.bookstore.view.DvdView;
import com.fvv.bookstore.view.DvdViewImpl;
import com.fvv.bookstore.view.EmployeeView;
import com.fvv.bookstore.view.EmployeeViewImpl;
import com.fvv.bookstore.view.LaptopView;
import com.fvv.bookstore.view.LaptopViewImpl;
import com.fvv.bookstore.view.MagazineView;
import com.fvv.bookstore.view.MagazineViewImpl;
import com.fvv.bookstore.view.OrderView;
import com.fvv.bookstore.view.OrderViewImpl;
import com.fvv.bookstore.view.ProductsReportView;
import com.fvv.bookstore.view.ProductsReportViewImpl;

/**
 * Menu class to create a menu for the application.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class Menu {
	
	private final BookView bookView;
	private final MagazineView magazineView;
	private final DvdView dvdView;
	private final CellphoneView cellphoneView;
	private final LaptopView laptopView;
	private final CustomerView customerView;
	private final EmployeeView employeeView;
	private final OrderView orderView;
	private final ProductsReportView productsReportView;
	
	/**
	 * Class constructor instantiating a new View objects.
	 */
	public Menu() {
		this.bookView = new BookViewImpl();
		this.magazineView = new MagazineViewImpl();
		this.dvdView = new DvdViewImpl();
		this.cellphoneView = new CellphoneViewImpl();
		this.laptopView = new LaptopViewImpl();
		this.customerView = new CustomerViewImpl();
		this.employeeView = new EmployeeViewImpl();
		this.orderView = new OrderViewImpl();
		this.productsReportView = new ProductsReportViewImpl();
	}
	
	/**
	 * Public method to start the application
	 */
	public void startApp() {
		this.createMenu();
	}

	/**
	 * Method to create and show the general menu
	 */
	private void createMenu() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Products" + Constants.LINE_SEPARATOR +
					"2 - Individuals" + Constants.LINE_SEPARATOR +
					"3 - Order" + Constants.LINE_SEPARATOR +
					"4 - Reports" + Constants.LINE_SEPARATOR +
					"0 - Exit",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.createSubMenuProducts();
					break;
				case '2' : this.createSubMenuIndividuals();
					break;
				case '3' : this.addOrder();
					break;
				case '4' : this.createSubMenuReports();
					break;
				case '0' : this.exit();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the products sub menu.
	 */
	private void createSubMenuProducts() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Products Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Book" + Constants.LINE_SEPARATOR +
					"2 - DVD" + Constants.LINE_SEPARATOR +
					"3 - Hardware" + Constants.LINE_SEPARATOR +
					"4 - Magazine" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.createSubMenuBook();
					break;
				case '2' : this.createSubMenuDvd();
					break;
				case '3' : this.createSubMenuHardware();
					break;
				case '4' : this.createSubMenuMagazine();
					break;
				case '0' : this.createMenu();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the book sub menu.
	 */
	private void createSubMenuBook() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Book Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Add a book" + Constants.LINE_SEPARATOR +
					"2 - Update a book" + Constants.LINE_SEPARATOR +
					"3 - Delete a book" + Constants.LINE_SEPARATOR +
					"4 - List the books" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.addBook();
					break;
				case '2' : this.updateBook();
					break;
				case '3' : this.removeBook();
					break;
				case '4' : this.listBooks();
					break;
				case '0' : this.createSubMenuProducts();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the magazine sub menu.
	 */
	private void createSubMenuMagazine() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Magazine Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Add a magazine" + Constants.LINE_SEPARATOR +
					"2 - Update a magazine" + Constants.LINE_SEPARATOR +
					"3 - Delete a magazine" + Constants.LINE_SEPARATOR +
					"4 - List the magazines" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.addMagazine();
					break;
				case '2' : this.updateMagazine();
					break;
				case '3' : this.removeMagazine();
					break;
				case '4' : this.listMagazines();
					break;
				case '0' : this.createSubMenuProducts();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the dvd sub menu.
	 */
	private void createSubMenuDvd() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "DVD Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Add a DVD" + Constants.LINE_SEPARATOR +
					"2 - Update a DVD" + Constants.LINE_SEPARATOR +
					"3 - Delete a DVD" + Constants.LINE_SEPARATOR +
					"4 - List the DVDs" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.addDvd();
					break;
				case '2' : this.updateDvd();
					break;
				case '3' : this.removeDvd();
					break;
				case '4' : this.createSubMenuDvdsList();
					break;
				case '0' : this.createSubMenuProducts();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the list of dvds sub menu.
	 */
	private void createSubMenuDvdsList() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "List the DVDs Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - List all the shows" + Constants.LINE_SEPARATOR +
					"2 - List all the movies" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.listDvdsShow();
					break;
				case '2' : this.listDvdsMovie();
					break;
				case '0' : this.createSubMenuDvd();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the hardware sub menu.
	 */
	private void createSubMenuHardware() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Hardware Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Cellphone" + Constants.LINE_SEPARATOR +
					"2 - Laptop" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.createSubMenuCellphone();
					break;
				case '2' : this.createSubMenuLaptop();
					break;
				case '0' : this.createSubMenuProducts();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Method to create and show the cellphone sub menu.
	 */
	private void createSubMenuCellphone() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Cellphone Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Add a cellphone" + Constants.LINE_SEPARATOR +
					"2 - Update a cellphone" + Constants.LINE_SEPARATOR +
					"3 - Delete a cellphone" + Constants.LINE_SEPARATOR +
					"4 - List the cellphones" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.addCellphone();
					break;
				case '2' : this.updateCellphone();
					break;
					case '3' : this.removeCellphone();
					break;
				case '4' : this.listCellphones();
					break;
				case '0' : this.createSubMenuHardware();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the laptop sub menu.
	 */
	private void createSubMenuLaptop() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Laptop Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Add a laptop" + Constants.LINE_SEPARATOR +
					"2 - Update a laptop" + Constants.LINE_SEPARATOR +
					"3 - Delete a laptop" + Constants.LINE_SEPARATOR +
					"4 - List the laptops" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.addLaptop();
					break;
				case '2' : this.updateLaptop();
					break;
				case '3' : this.removeLaptop();
					break;
				case '4' : this.listLaptops();
					break;
				case '0' : this.createSubMenuHardware();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the individuals sub menu.
	 */
	private void createSubMenuIndividuals() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Individuals Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Customer" + Constants.LINE_SEPARATOR +
					"2 - Employee" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.createSubMenuCustomer();
					break;
				case '2' : this.createSubMenuEmployee();
					break;
				case '0' : this.createMenu();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the customer sub menu.
	 */
	private void createSubMenuCustomer() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Customer Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Add a customer" + Constants.LINE_SEPARATOR +
					"2 - Update a customer" + Constants.LINE_SEPARATOR +
					"3 - Delete a customer" + Constants.LINE_SEPARATOR +
					"4 - List the customers" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.addCustomer();
					break;
				case '2' : this.updateCustomer();
					break;
				case '3' : this.removeCustomer();
					break;
				case '4' : this.listCustomers();
					break;
				case '0' : this.createSubMenuIndividuals();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the customer sub menu.
	 */
	private void createSubMenuEmployee() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Employee Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Add an employee" + Constants.LINE_SEPARATOR +
					"2 - Update an employee" + Constants.LINE_SEPARATOR +
					"3 - Delete an employee" + Constants.LINE_SEPARATOR +
					"4 - List the employees" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.addEmployee();
					break;
				case '2' : this.updateEmployee();
					break;
				case '3' : this.removeEmployee();
					break;
				case '4' : this.listEmployees();
					break;
				case '0' : this.createSubMenuIndividuals();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the reports sub menu.
	 */
	private void createSubMenuReports() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Reports Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Individuals" + Constants.LINE_SEPARATOR +
					"2 - Products - Stock to Replace" + Constants.LINE_SEPARATOR +
					"3 - Sales" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.createSubMenuIndividualsReports();
					break;
				case '2' : this.listStockToReplace();
					break;
				case '3' : this.createSubMenuSalesReports();
					break;
				case '0' : this.createMenu();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the individuals reports sub menu.
	 */
	private void createSubMenuIndividualsReports() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Individuals Reports Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Customers Filtered and Ordered by Name" + Constants.LINE_SEPARATOR +
					"2 - Employees Filtered by Name and Ordered by Highest Salary" + Constants.LINE_SEPARATOR +
					"3 - Employee Salary with Commission by Month" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.listCustomersByName();
					break;
				case '2' : this.listEmployeesByName();
					break;
				case '3' : this.getSalaryWithCommission();
					break;
				case '0' : this.createSubMenuReports();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and show the reports sub menu for sales.
	 */
	private void createSubMenuSalesReports() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Sales Reports Section" + Constants.LINE_SEPARATOR + Constants.LINE_SEPARATOR +
					"Select an option below:" + Constants.LINE_SEPARATOR +
					"1 - Total Orders in a Month" + Constants.LINE_SEPARATOR +
					"2 - Total Sales per Seller" + Constants.LINE_SEPARATOR +
					"3 - List an Order by ID" + Constants.LINE_SEPARATOR +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.listTotalOrdersMonth();
					break;
				case '2' : this.listTotalSalesPerSeller();
					break;
				case '3' : this.listOrderByOrderId();
					break;
				case '0' : this.createSubMenuReports();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Add a book by the menu.
	 */
	private void addBook() {
		this.bookView.addBook();
	}
	
	/**
	 * Update a book by the menu.
	 */
	private void updateBook() {
		this.bookView.updateBook();
	}
	
	/**
	 * Remove a book by the menu.
	 */
	private void removeBook() {
		this.bookView.removeBook();
	}
	
	/**
	 * List all the books by the menu.
	 */
	private void listBooks() {
		this.bookView.listBooks();
	}
	
	/**
	 * Add a magazine by the menu.
	 */
	private void addMagazine() {
		this.magazineView.addMagazine();
	}
	
	/**
	 * Update a magazine by the menu.
	 */
	private void updateMagazine() {
		this.magazineView.updateMagazine();
	}
	
	/**
	 * Remove a magazine by the menu.
	 */
	private void removeMagazine() {
		this.magazineView.removeMagazine();
	}
	
	/**
	 * List all the magazines by the menu.
	 */
	private void listMagazines() {
		this.magazineView.listMagazines();
	}
	
	/**
	 * Add a dvd by the menu.
	 */
	private void addDvd() {
		this.dvdView.addDvd();
	}
	
	/**
	 * Update a dvd by the menu.
	 */
	private void updateDvd() {
		this.dvdView.updateDvd();
	}
	
	/**
	 * Remove a dvd by the menu.
	 */
	private void removeDvd() {
		this.dvdView.removeDvd();
	}
	
	/**
	 * List all the movies' dvds by the menu.
	 */
	private void listDvdsMovie() {
		this.dvdView.listDvdsMovie();
	}

	/**
	 * List all the shows' dvds by the menu.
	 */
	private void listDvdsShow() {
		this.dvdView.listDvdsShow();
	}
	
	/**
	 * Add a cellphone by the menu.
	 */
	private void addCellphone() {
		this.cellphoneView.addCellphone();
	}
	
	/**
	 * Update a cellphone by the menu.
	 */
	private void updateCellphone() {
		this.cellphoneView.updateCellphone();
	}
	
	/**
	 * Remove a cellphone by the menu.
	 */
	private void removeCellphone() {
		this.cellphoneView.removeCellphone();
	}
	
	/**
	 * List all the cellphones by the menu.
	 */
	private void listCellphones() {
		this.cellphoneView.listCellphones();
	}
	
	/**
	 * Add a laptop by the menu.
	 */
	private void addLaptop() {
		this.laptopView.addLaptop();
	}
	
	/**
	 * Update a laptop by the menu.
	 */
	private void updateLaptop() {
		this.laptopView.updateLaptop();
	}
	
	/**
	 * Remove a laptop by the menu.
	 */
	private void removeLaptop() {
		this.laptopView.removeLaptop();
	}
	
	/**
	 * List all the laptops by the menu.
	 */
	private void listLaptops() {
		this.laptopView.listLaptops();
	}
	
	/**
	 * Add a customer by the menu.
	 */
	private void addCustomer() {
		this.customerView.addCustomer();
	}
	
	/**
	 * Update a customer by the menu.
	 */
	private void updateCustomer() {
		this.customerView.updateCustomer();
	}
	
	/**
	 * Remove a customer by the menu.
	 */
	private void removeCustomer() {
		this.customerView.removeCustomer();
	}
	
	/**
	 * List all the customers by the menu.
	 */
	private void listCustomers() {
		this.customerView.listCustomers();
	}
	
	/**
	 * Add an employee by the menu.
	 */
	private void addEmployee() {
		this.employeeView.addEmployee();
	}
	
	/**
	 * Update an employee by the menu.
	 */
	private void updateEmployee() {
		this.employeeView.updateEmployee();
	}
	
	/**
	 * Remove an employee by the menu.
	 */
	private void removeEmployee() {
		this.employeeView.removeEmployee();
	}
	
	/**
	 * List all the employees by the menu.
	 */
	private void listEmployees() {
		this.employeeView.listEmployees();
	}
	
	/**
	 * Add an order by the menu.
	 */
	private void addOrder() {
		this.orderView.addOrder();
	}
	
	/**
	 * List the customers by name.
	 */
	private void listCustomersByName() {
		this.customerView.listCustomersByName();
	}
	
	/**
	 * List the employees by name.
	 */
	private void listEmployeesByName() {
		this.employeeView.listEmployeesByName();
	}
	
	/**
	 * Gets the salary with commission.
	 */
	private void getSalaryWithCommission() {
		this.employeeView.getSalaryWithCommission();
	}
	
	/**
	 * Lists all products that needs to be replaced in the stock by the menu.
	 */
	private void listStockToReplace() {
		this.productsReportView.listStockToReplace();
	}
	
	/**
	 * Lists all orders by month.
	 */
	private void listTotalOrdersMonth() {
		this.orderView.listTotalOrdersMonth();
	}
	
	/**
	 * Lists all sales per seller.
	 */
	private void listTotalSalesPerSeller() {
		this.orderView.listTotalSalesPerSeller();
	}
	
	/**
	 * Lists an order by order id.
	 */
	private void listOrderByOrderId() {
		this.orderView.listOrderByOrderId();
	}
	
	/**
	 * Exit from the application.
	 */
	private void exit() {
		System.exit(0);
	}
}
