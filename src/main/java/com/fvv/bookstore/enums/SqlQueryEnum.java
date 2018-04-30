package com.fvv.bookstore.enums;

/**
 * Enum for SQL constants.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public enum SqlQueryEnum {
	
	BOOK_INSERT("INSERT INTO tb_book (book_title, book_publication_year, book_edition_number, "
			+ "book_author, book_unit_price, book_isbn, book_publisher, book_genre, "
			+ "book_stock_qty, book_modification_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, now())"),
	
	BOOK_SELECT_ALL("SELECT * FROM tb_book"),
	
	BOOK_UPDATE("UPDATE tb_book SET book_title = ?, book_publication_year = ?, "
					+ "book_edition_number = ?, book_author = ?, book_unit_price = ?, "
					+ "book_isbn = ?, book_publisher = ?, book_genre = ?, book_stock_qty = ?, "
					+ "book_modification_date = now() WHERE book_id = ?"),
	
	BOOK_DELETE("DELETE FROM tb_book WHERE book_id = ?"),
	
	BOOK_SELECT_ID("SELECT * FROM tb_book WHERE book_id = ?"),
	
	BOOK_SELECT_TITLE("SELECT * FROM tb_book WHERE book_title = ?"),
	
	BOOK_REDUCE_STOCK("UPDATE tb_book SET book_stock_qty = ? WHERE book_id = ?"),
	
	MAGAZINE_INSERT("INSERT INTO tb_magazine (mag_name, mag_edition_number, mag_genre, "
					+ "mag_publication_date, mag_publisher, mag_unit_price, mag_stock_qty, "
					+ "mag_modification_date) VALUES (?, ?, ?, ?, ?, ?, ?, now())"),
	
	MAGAZINE_SELECT_ALL("SELECT * FROM tb_magazine"),
	
	MAGAZINE_UPDATE("UPDATE tb_magazine SET mag_name = ?, mag_edition_number = ?, "
					+ "mag_genre = ?, mag_publication_date = ?, mag_publisher = ?, "
					+ "mag_unit_price = ?, mag_stock_qty = ?, mag_modification_date = now() "
					+ "WHERE mag_id = ?"),
	
	MAGAZINE_DELETE("DELETE FROM tb_magazine WHERE mag_id = ?"),
	
	MAGAZINE_SELECT_ID("SELECT * FROM tb_magazine WHERE mag_id = ?"),
	
	MAGAZINE_SELECT_NAME("SELECT * FROM tb_magazine WHERE mag_name = ?"),
	
	MAGAZINE_REDUCE_STOCK("UPDATE tb_magazine SET mag_stock_qty = ? WHERE mag_id = ?"),
	
	DVD_SHOW_INSERT("INSERT INTO tb_dvd (dvd_title, dvd_total_duration, dvd_unit_price, "
			+ "dvd_genre, dvd_release_year, dvd_code, dvd_show_artist, dvd_stock_qty, "
			+ "dvd_modification_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, now())"),
	
	DVD_MOVIE_INSERT("INSERT INTO tb_dvd (dvd_title, dvd_total_duration, dvd_unit_price, "
			+ "dvd_genre, dvd_release_year, dvd_code, dvd_movie_director, dvd_stock_qty, "
			+ "dvd_modification_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, now())"),
	
	DVD_SELECT_ALL_SHOW("SELECT * FROM tb_dvd WHERE dvd_show_artist IS NOT NULL"),
	
	DVD_SELECT_ALL_MOVIE("SELECT * FROM tb_dvd WHERE dvd_movie_director IS NOT NULL"),
	
	DVD_SHOW_UPDATE("UPDATE tb_dvd SET dvd_title = ?, dvd_total_duration = ?, dvd_unit_price = ?, "
			+ "dvd_genre = ?, dvd_release_year = ?, dvd_code = ?, dvd_show_artist = ?, "
			+ "dvd_stock_qty = ?, dvd_modification_date = now() WHERE dvd_id = ?"),
	
	DVD_MOVIE_UPDATE("UPDATE tb_dvd SET dvd_title = ?, dvd_total_duration = ?, "
			+ "dvd_unit_price = ?, dvd_genre = ?, dvd_release_year = ?, dvd_code = ?, "
			+ "dvd_movie_director = ?, dvd_stock_qty = ?, dvd_modification_date = now() "
			+ "WHERE dvd_id = ?"),
	
	DVD_DELETE("DELETE FROM tb_dvd WHERE dvd_id = ?"),
	
	DVD_SELECT_ID("SELECT * FROM tb_dvd WHERE dvd_id = ?"),
	
	DVD_SELECT_TITLE("SELECT * FROM tb_dvd WHERE dvd_title = ?"),
	
	DVD_REDUCE_STOCK("UPDATE tb_dvd SET dvd_stock_qty = ? WHERE dvd_id = ?"),
	
	CELLPHONE_INSERT("INSERT INTO tb_cellphone (cel_brand, cel_unit_price, cel_warranty, "
			+ "cel_storage_memory, cel_camera_pixels, cel_stock_qty, cel_modification_date) "
			+ "VALUES (?, ?, ?, ?, ?, ?, now())"),
	
	CELLPHONE_SELECT_ALL("SELECT * FROM tb_cellphone"),
	
	CELLPHONE_UPDATE("UPDATE tb_cellphone SET cel_brand = ?, cel_unit_price = ?, "
			+ "cel_warranty = ?, cel_storage_memory = ?, cel_camera_pixels = ?, "
			+ "cel_stock_qty = ?, cel_modification_date = now() WHERE cel_id = ?"),
	
	CELLPHONE_DELETE("DELETE FROM tb_cellphone WHERE cel_id = ?"),
	
	CELLPHONE_SELECT_ID("SELECT * FROM tb_cellphone WHERE cel_id = ?"),
	
	CELLPHONE_SELECT_BRAND("SELECT * FROM tb_cellphone WHERE cel_brand = ?"),
	
	CELLPHONE_REDUCE_STOCK("UPDATE tb_cellphone SET cel_stock_qty = ? WHERE cel_id = ?"),
	
	LAPTOP_INSERT("INSERT INTO tb_laptop (pc_brand, pc_unit_price, pc_warranty, pc_ram_size, "
			+ "pc_hd_size, pc_processor, pc_stock_qty, pc_modification_date) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, now())"),
	
	LAPTOP_SELECT_ALL("SELECT * FROM tb_laptop"),
	
	LAPTOP_UPDATE("UPDATE tb_laptop SET pc_brand = ?, pc_unit_price = ?, pc_warranty = ?, "
			+ "pc_ram_size = ?, pc_hd_size = ?, pc_processor = ?, pc_stock_qty = ?, "
			+ "pc_modification_date = now() WHERE pc_id = ?"),
	
	LAPTOP_DELETE("DELETE FROM tb_laptop WHERE pc_id = ?"),
	
	LAPTOP_SELECT_ID("SELECT * FROM tb_laptop WHERE pc_id = ?"),
	
	LAPTOP_SELECT_BRAND("SELECT * FROM tb_laptop WHERE pc_brand = ?"),
	
	LAPTOP_REDUCE_STOCK("UPDATE tb_laptop SET pc_stock_qty = ? WHERE pc_id = ?"),
	
	CUSTOMER_INSERT("INSERT INTO tb_customer (cus_name, cus_email, cus_phone, cus_cpf, "
			+ "cus_prod_pref, cus_modification_date) VALUES (?, ?, ?, ?, ?, now())"),
	
	CUSTOMER_SELECT_ALL("SELECT * FROM tb_customer"),
	
	CUSTOMER_UPDATE("UPDATE tb_customer SET cus_name = ?, cus_email = ?, cus_phone = ?, "
			+ "cus_cpf = ?, cus_prod_pref = ?, cus_modification_date = now() WHERE cus_id = ?"),
	
	CUSTOMER_DELETE("DELETE FROM tb_customer WHERE cus_id = ?"),
	
	CUSTOMER_SELECT_ID("SELECT * FROM tb_customer WHERE cus_id = ?"),
	
	CUSTOMER_SELECT_NAME("SELECT * FROM tb_customer WHERE cus_name LIKE ?"),
	
	EMPLOYEE_INSERT("INSERT INTO tb_employee (emp_name, emp_email, emp_phone, emp_cpf, "
			+ "emp_position, emp_salary, emp_modification_date) VALUES (?, ?, ?, ?, ?, ?, now())"),
	
	EMPLOYEE_SELECT_ALL("SELECT * FROM tb_employee"),
	
	EMPLOYEE_UPDATE("UPDATE tb_employee SET emp_name = ?, emp_email = ?, emp_phone = ?, "
			+ "emp_cpf = ?, emp_position = ?, emp_salary = ?, emp_modification_date = now() "
			+ "WHERE emp_id = ?"),
	
	EMPLOYEE_DELETE("DELETE FROM tb_employee WHERE emp_id = ?"),
	
	EMPLOYEE_SELECT_ID("SELECT * FROM tb_employee WHERE emp_id = ?"),
	
	ORDER_INSERT("INSERT INTO tb_order (ord_emp_id, ord_cus_id, ord_amount, ord_date) VALUES "
			+ "(?, ?, ?, now())"),
	
	ORDER_ITEM_BOOK_INSERT("INSERT INTO tb_order_item_book (ord_ite_book_ord_id, "
			+ "ord_ite_book_book_id, ord_ite_book_quantity, ord_ite_book_amount) "
			+ "VALUES (?, ?, ?, ?)"),
	
	ORDER_ITEM_CELLPHONE_INSERT("INSERT INTO tb_order_item_cellphone (ord_ite_cel_ord_id, "
			+ "ord_ite_cel_cel_id, ord_ite_cel_quantity, ord_ite_cel_amount) "
			+ "VALUES (?, ?, ?, ?)"),
	
	ORDER_ITEM_DVD_INSERT("INSERT INTO tb_order_item_dvd (ord_ite_dvd_ord_id, ord_ite_dvd_dvd_id, "
			+ "ord_ite_dvd_quantity, ord_ite_dvd_amount) VALUES (?, ?, ?, ?)"),
	
	ORDER_ITEM_LAPTOP_INSERT("INSERT INTO tb_order_item_laptop (ord_ite_pc_ord_id, "
			+ "ord_ite_pc_pc_id, ord_ite_pc_quantity, ord_ite_pc_amount) "
			+ "VALUES (?, ?, ?, ?)"),
	
	ORDER_ITEM_MAGAZINE_INSERT("INSERT INTO tb_order_item_magazine (ord_ite_mag_ord_id, "
			+ "ord_ite_mag_mag_id, ord_ite_mag_quantity, ord_ite_mag_amount) "
			+ "VALUES (?, ?, ?, ?)");
	
	private final String query;
	
	/**
	 * Enum constructor.
	 * 
	 * @param query of String type.
	 */
	SqlQueryEnum(final String query) {
		this.query = query;
	}

	/**
	 * @return the query.
	 */
	public String getQuery() {
		return query;
	}	
}
