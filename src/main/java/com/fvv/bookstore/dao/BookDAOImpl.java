package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			String sql = "INSERT INTO book (book_title, book_publication_year, "
					+ "book_edition_number, book_author, book_price, book_isbn, "
					+ "book_publisher, book_genre) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<>();
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM book";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setTitle(rs.getString("book_title"));
				book.setPublicationYear(rs.getInt("book_publication_year"));
				book.setEditionNumber(rs.getInt("book_edition_number"));
				book.setAuthor(rs.getString("book_author"));
				book.setPrice(rs.getDouble("book_price"));
				book.setIsbn(rs.getInt("book_isbn"));
				book.setPublisher(rs.getString("book_publisher"));
				book.setGenre(rs.getString("book_genre"));
				books.add(book);
			}
		} catch(SQLException e) {
			throw new DaoException("Error to load the list", e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to load the list", e);
			}
		}
		return books;
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateBook(Book book) throws DaoException {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "UPDATE book SET book_title = ?, book_publication_year = ?, "
					+ "book_edition_number = ?, book_author = ?, book_price = ?, "
					+ "book_publisher = ?, book_genre = ? WHERE book_isbn = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setInt(2, book.getPublicationYear());
			ps.setInt(3, book.getEditionNumber());
			ps.setString(4, book.getAuthor());
			ps.setDouble(5, book.getPrice());
			ps.setString(6, book.getPublisher());
			ps.setString(7, book.getGenre());
			ps.setInt(8, book.getIsbn());
			ps.execute();
			System.out.println("Updated successfully!");
		} catch(SQLException e) {
			throw new DaoException("Error to update a book", e);
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to update a book", e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeBook(Integer isbn) throws DaoException {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "DELETE FROM book WHERE book_isbn = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, isbn);
			ps.execute();
			System.out.println("Deleted successfully!");
		} catch(SQLException e) {
			throw new DaoException("Error to delete a book", e);
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to delete a book", e);
			}
		}
	}
}
