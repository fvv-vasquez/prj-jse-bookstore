package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.book.BookNotFoundException;

/**
 * DAO Interface of a Book object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public interface BookDAO {

	/**
	 * Add a book at the bookstore in the database.
	 * 
	 * @param book of Book type.
	 * @throws DaoException when a problem in database happens.
	 */
	void addBook(final Book book) throws DaoException;

	/**
	 * Lists all the books in the database.
	 * 
	 * @return a list of books.
	 * @throws DaoException when a problem in database happens.
	 */
	List<Book> listBooks() throws DaoException;

	/**
	 * Update a book already added in the database.
	 * 
	 * @param book of Book type.
	 * @throws DaoException when a problem in database happens.
	 */
	void updateBook(final Book book) throws DaoException;

	/**
	 * Delete a book from the bookstore in the database.
	 * 
	 * @param id of Long type.
	 * @throws DaoException when a problem in database happens.
	 */
	void removeBook(final Long id) throws DaoException;
	
	/**
	 * Search a book in the database.
	 * 
	 * @param id of Long type.
	 * @return a Book.
	 * @throws BookNotFoundException when not found a book in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	Book findBook(final Long id) throws BookNotFoundException, DaoException;
	
	/**
	 * Search a book in the database by the title.
	 * 
	 * @param title of String type.
	 * @return a book.
	 * @throws BookNotFoundException when not found a book in the database.
	 * @throws DaoException when a problem in database happens.
	 */
	Book findBookByTitle(final String title) throws BookNotFoundException, DaoException;
	
	/**
	 * Reduce the quantity of a stock item.
	 * 
	 * @param book of Book type.
	 * @param quantityToReduce of Integer type.
	 * @throws DaoException when a problem in database happens.
	 */
	void reduceStockItem(final Book book, final Integer quantityToReduce) throws DaoException;
	
	/**
	 * Lists all the books that needs to be replaced in the stock.
	 * 
	 * @return a list of books that needs to be replaced.
	 * @throws DaoException when a problem in database happens.
	 */
	List<Book> listStockToReplace() throws DaoException;
}
