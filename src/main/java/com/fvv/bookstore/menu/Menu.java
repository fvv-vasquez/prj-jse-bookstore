package com.fvv.bookstore.menu;

import javax.swing.JOptionPane;

import com.fvv.bookstore.view.BookView;
import com.fvv.bookstore.view.BookViewImpl;

/**
 * Menu class to create a menu for the application.
 * 
 * @author Fatima Vasquez
 * <p>Created on 24 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public class Menu {
	
	private BookView bookView;
	
	/**
	 * Class constructor instantiating a new BookViewImpl object.
	 */
	public Menu() {
		this.bookView = new BookViewImpl();
	}
	
	/**
	 * Public method to start the application
	 */
	public void startApp() {
		this.createMenu();
	}

	/**
	 * Method to create and appear the general menu
	 */
	private void createMenu() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Select an option below:\n" +
					"1 - Books\n" +
					"2 - DVDs\n" +
					"3 - Hardwares\n" +
					"4 - Magazines\n" +
					"0 - Exit",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.createSubMenuBooks();
					break;
				case '0' : this.exit();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and appear the book sub menu.
	 */
	private void createSubMenuBooks() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Books Section\n\n" +
					"Select an option below:\n" +
					"1 - Add a book\n" +
					"2 - Update a book\n" +
					"3 - Delete a book\n" +
					"4 - List the books\n" +
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
				case '0' : this.createMenu();
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
	 * Exit from the application.
	 */
	private void exit() {
		System.exit(0);
	}
}
