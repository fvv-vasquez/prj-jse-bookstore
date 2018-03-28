package com.fvv.bookstore.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.controller.BookController;
import com.fvv.bookstore.controller.BookControllerImpl;
import com.fvv.bookstore.exception.ControllerException;

/**
 * BookView class to view the Book object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 24 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public class BookViewImpl implements BookView {
	
	private BookController bookController;
	
	/**
	 * Class constructor instantiating a new BookControllerImpl object.
	 */
	public BookViewImpl() {
		this.bookController = new BookControllerImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	public void addBook() {
		try {
			Book book = new Book();
			book.setTitle(JOptionPane.showInputDialog("Insert the title"));
			book.setPublicationYear(
					Integer.parseInt(JOptionPane.showInputDialog("Insert the publication year")));
			book.setEditionNumber(
					Integer.parseInt(JOptionPane.showInputDialog("Insert the edition number")));
			book.setAuthor(JOptionPane.showInputDialog("Insert the author"));
			book.setPrice(
					Double.parseDouble(JOptionPane.showInputDialog("Insert the price")));
			book.setIsbn(
					Integer.parseInt(JOptionPane.showInputDialog("Insert the isbn")));
			book.setPublisher(JOptionPane.showInputDialog("Insert the publisher"));
			book.setGenre(JOptionPane.showInputDialog("Insert the genre"));
			boolean isSuccessful = this.bookController.addBook(book);
			
			if (isSuccessful) {
				JOptionPane.showMessageDialog(null, "Book added successfuly!");
			} else {
				JOptionPane.showMessageDialog(null, "Error to add the book!");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value:\n" 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}		
	}

	/**
	 * {@inheritDoc}
	 */
	public void listBooks() {
		try {
			StringBuilder sb = new StringBuilder();
			List<Book> books = this.bookController.listBooks();
			for(Book b : books) {
				sb.append(b).append("\n");
			}
			JOptionPane.showMessageDialog(null, sb.toString(), "Listing All Books", 
					JOptionPane.PLAIN_MESSAGE);
		} catch (ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateBook() {
		try {
			Book book = new Book();
			book.setId(Long.parseLong(JOptionPane.showInputDialog("Insert the ID to update")));
			book.setTitle(JOptionPane.showInputDialog("Insert the title"));
			book.setPublicationYear(
					Integer.parseInt(JOptionPane.showInputDialog("Insert the publication year")));
			book.setEditionNumber(
					Integer.parseInt(JOptionPane.showInputDialog("Insert the edition number")));
			book.setAuthor(JOptionPane.showInputDialog("Insert the author"));
			book.setPrice(
					Double.parseDouble(JOptionPane.showInputDialog("Insert the price")));
			book.setIsbn(
					Integer.parseInt(JOptionPane.showInputDialog("Insert the isbn")));
			book.setPublisher(JOptionPane.showInputDialog("Insert the publisher"));
			book.setGenre(JOptionPane.showInputDialog("Insert the genre"));
			boolean isSuccessful = this.bookController.updateBook(book);
			
			if (isSuccessful) {
				JOptionPane.showMessageDialog(null, "Book updated successfuly!");
			} else {
				JOptionPane.showMessageDialog(null, "Error to updated the book!");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value:\n" 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeBook() {
		try {
			Long idDelete = (Long.parseLong(JOptionPane.showInputDialog(
					"Insert the ID to delete")));
			this.bookController.removeBook(idDelete);
			JOptionPane.showMessageDialog(null, "Deleted successfully!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value:\n" 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
