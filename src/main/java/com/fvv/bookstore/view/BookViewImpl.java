package com.fvv.bookstore.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.controller.BookController;
import com.fvv.bookstore.controller.BookControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.book.BookNotFoundException;
import com.fvv.bookstore.exception.book.BookValidationException;
import com.fvv.bookstore.util.Constants;

/**
 * BookView class to view the Book object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class BookViewImpl implements BookView {
	
	private final BookController bookController;
	
	/**
	 * Class constructor instantiating a new BookControllerImpl object.
	 */
	public BookViewImpl() {
		this.bookController = new BookControllerImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addBook() {
		try {
			final Book book = this.createBookFromInput(Boolean.FALSE);
			this.bookController.addBook(book);
			JOptionPane.showMessageDialog(null, "Book added successfully!");		
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value:" + Constants.LINE_SEPARATOR
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | BookNotFoundException | BookValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		} 	
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void listBooks() {
		try {
			StringBuilder sb = new StringBuilder();
			List<Book> books = this.bookController.listBooks();
			if(books != null && !books.isEmpty()) {
				for(Book b : books) {
					sb.append(b).append(Constants.LINE_SEPARATOR);
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing All Books", 
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "There are no items to show!");
			}			
		} catch (ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateBook() {
		try {
			final Book book = this.createBookFromInput(Boolean.TRUE);
			this.bookController.updateBook(book);
			JOptionPane.showMessageDialog(null, "Book updated successfully!");			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value: " + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | BookNotFoundException | BookValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeBook() {
		try {
			Long idDelete = (Long.parseLong(JOptionPane.showInputDialog(
					"Insert the ID to delete")));
			this.bookController.findBook(idDelete);
			this.bookController.removeBook(idDelete);
			JOptionPane.showMessageDialog(null, "Deleted successfully!");			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Problems to convert the value: " + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (BookNotFoundException | ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Creating a book from the input.
	 * 
	 * @param isUpdate of boolean type.
	 * @return a Book.
	 * @throws BookNotFoundException when a book is not found.
	 * @throws ControllerException when a problem in controller happens.
	 */
	private Book createBookFromInput(final boolean isUpdate) 
			throws BookNotFoundException, ControllerException {
		final Book book = new Book();
		
		if (isUpdate) {
			Long idUp = Long.parseLong(JOptionPane.showInputDialog("Insert the ID to update"));
			this.bookController.findBook(idUp);			
			book.setId(idUp);
		}
		
		book.setTitle(JOptionPane.showInputDialog("Insert the title"));
		book.setPublicationYear(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the publication year")));
		book.setEditionNumber(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the edition number")));
		book.setAuthor(JOptionPane.showInputDialog("Insert the author"));
		book.setUnitPrice(
				Double.parseDouble(JOptionPane.showInputDialog("Insert the price")));
		book.setIsbn(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the isbn")));
		book.setPublisher(JOptionPane.showInputDialog("Insert the publisher"));
		book.setGenre(JOptionPane.showInputDialog("Insert the genre"));
		book.setStockQty(
				Integer.parseInt(JOptionPane.showInputDialog("Insert the quantity in stock")));
		return book;
	}
}
