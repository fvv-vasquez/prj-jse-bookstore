package com.fvv.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import com.fvv.bookstore.bean.Product;
import com.fvv.bookstore.dao.BookDAO;
import com.fvv.bookstore.dao.BookDAOImpl;
import com.fvv.bookstore.dao.CellphoneDAO;
import com.fvv.bookstore.dao.CellphoneDAOImpl;
import com.fvv.bookstore.dao.DvdDAO;
import com.fvv.bookstore.dao.DvdDAOImpl;
import com.fvv.bookstore.dao.LaptopDAO;
import com.fvv.bookstore.dao.LaptopDAOImpl;
import com.fvv.bookstore.dao.MagazineDAO;
import com.fvv.bookstore.dao.MagazineDAOImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;

/**
 * Controller class for Products.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class ProductsReportControllerImpl implements ProductsReportController {
	
	private final BookDAO bookDao;
	private final CellphoneDAO cellphoneDAO;
	private final DvdDAO dvdDAO;
	private final LaptopDAO laptopDAO;
	private final MagazineDAO magazineDAO;
	
	/**
	 * Class constructor instantiating new objects.
	 */
	public ProductsReportControllerImpl() {
		this.bookDao = new BookDAOImpl(); 
		this.cellphoneDAO = new CellphoneDAOImpl();
		this.dvdDAO = new DvdDAOImpl();
		this.laptopDAO = new LaptopDAOImpl();
		this.magazineDAO = new MagazineDAOImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Product> listStockToReplace() throws ControllerException {
		List<Product> products = new ArrayList<>();
		try {
			products.addAll(this.bookDao.listStockToReplace());
			products.addAll(this.cellphoneDAO.listStockToReplace());
			products.addAll(this.dvdDAO.listStockToReplace());
			products.addAll(this.laptopDAO.listStockToReplace());
			products.addAll(this.magazineDAO.listStockToReplace());
			return products;
		} catch (DaoException e) {
			throw new ControllerException("Error to load the list", e);
		}
	}
}
