package com.fvv.bookstore.menu;

import javax.swing.JOptionPane;

import com.fvv.bookstore.view.BookView;
import com.fvv.bookstore.view.BookViewImpl;

/**
 * Menu class to create a menu for the application.
 * 
 * @author Fatima Vasquez
 * Created on 24 de mar de 2018	
 * @version 1.0 	
 *
 */
public class Menu {
	
	private BookView bookView;
	
	public Menu() {
		this.bookView = new BookViewImpl();
	}
	
	public void startApp() {
		this.createMenu();
	}

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
	
	private void addBook() {
		this.bookView.addBook();
	}
	
	private void updateBook() {
		this.bookView.updateBook();
	}
	
	private void removeBook() {
		this.bookView.removeBook();
	}
	
	private void listBooks() {
		this.bookView.listBooks();
	}
	
	private void exit() {
		System.exit(0);
	}
}
