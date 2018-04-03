package com.fvv.bookstore.menu;

import javax.swing.JOptionPane;

import com.fvv.bookstore.view.BookView;
import com.fvv.bookstore.view.BookViewImpl;
import com.fvv.bookstore.view.CellphoneView;
import com.fvv.bookstore.view.CellphoneViewImpl;
import com.fvv.bookstore.view.DvdView;
import com.fvv.bookstore.view.DvdViewImpl;
import com.fvv.bookstore.view.MagazineView;
import com.fvv.bookstore.view.MagazineViewImpl;

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
	
	/**
	 * Class constructor instantiating a new View objects.
	 */
	public Menu() {
		this.bookView = new BookViewImpl();
		this.magazineView = new MagazineViewImpl();
		this.dvdView = new DvdViewImpl();
		this.cellphoneView = new CellphoneViewImpl();
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
					"1 - Book\n" +
					"2 - DVD\n" +
					"3 - Hardware\n" +
					"4 - Magazine\n" +
					"0 - Exit",
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
	private void createSubMenuBook() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Book Section\n\n" +
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
	 * Method to create and appear the magazine sub menu.
	 */
	private void createSubMenuMagazine() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Magazine Section\n\n" +
					"Select an option below:\n" +
					"1 - Add a magazine\n" +
					"2 - Update a magazine\n" +
					"3 - Delete a magazine\n" +
					"4 - List the magazines\n" +
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
				case '0' : this.createMenu();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and appear the dvd sub menu.
	 */
	private void createSubMenuDvd() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "DVD Section\n\n" +
					"Select an option below:\n" +
					"1 - Add a DVD\n" +
					"2 - Update a DVD\n" +
					"3 - Delete a DVD\n" +
					"4 - List the DVDs\n" +
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
				case '0' : this.createMenu();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Method to create and appear the list of dvds sub menu.
	 */
	private void createSubMenuDvdsList() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "List the DVDs Section\n\n" +
					"Select an option below:\n" +
					"1 - List all the shows\n" +
					"2 - List all the movies\n" +
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
	 * Method to create and appear the hardware sub menu.
	 */
	private void createSubMenuHardware() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Hardware Section\n\n" +
					"Select an option below:\n" +
					"1 - Cellphone\n" +
					"2 - Laptop\n" +
					"0 - Return",
					"RAINBOW BOOKSTORE", JOptionPane.PLAIN_MESSAGE
			);
			switch(input.charAt(0)) {
				case '1' : this.createSubMenuCellphone();
					break;
				/*case '2' : this.createSubMenuLaptop();
					break;*/
				case '0' : this.createMenu();
					break;
				default : JOptionPane.showMessageDialog(null, "Choose a valid option!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Method to create and appear the cellphone sub menu.
	 */
	private void createSubMenuCellphone() {
		while(true) {
			String input = JOptionPane.showInputDialog(
					null, "Cellphone Section\n\n" +
					"Select an option below:\n" +
					"1 - Add a cellphone\n" +
					"2 - Update a cellphone\n" +
					"3 - Delete a cellphone\n" +
					"4 - List the cellphone\n" +
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
	 * Exit from the application.
	 */
	private void exit() {
		System.exit(0);
	}
}
