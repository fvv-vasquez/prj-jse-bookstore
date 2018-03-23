package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.exception.DaoException;

/**
 * DAO Class of a Book object, with main database operations from CRUD methods.
 * 
 * Created on 03/21/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public class BookDAOImpl implements BookDAO {

	/**
	 * {@inheritDoc}
	 */
	public void addBook(Book book) throws DaoException {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "INSERT INTO book (title, publicationYear, editionNumber, author, price, "
					+ "isbn, publisher, genre) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setInt(2, book.getPublicationYear());
			ps.setInt(3, book.getEditionNumber());
			ps.setString(4, book.getAuthor());
			ps.setDouble(5, book.getPrice());
			ps.setInt(6, book.getIsbn());
			ps.setString(7, book.getPublisher());
			ps.setString(8, book.getGenre());
			ps.execute();
			System.out.println("Saved successfully!");
		} catch(SQLException e) {
			throw new DaoException("Error to add a book", e);
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to add a book", e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Book> listBooks() throws DaoException {
		
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeBook(Integer isbn) {
		// TODO Auto-generated method stub
		
	}

}
