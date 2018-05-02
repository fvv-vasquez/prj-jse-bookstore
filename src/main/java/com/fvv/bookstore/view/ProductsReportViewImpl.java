package com.fvv.bookstore.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.fvv.bookstore.bean.Product;
import com.fvv.bookstore.controller.ProductsReportController;
import com.fvv.bookstore.controller.ProductsReportControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.util.Constants;

/**
 * ProductsReportView class to view the Products object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class ProductsReportViewImpl implements ProductsReportView {

	private final ProductsReportController productsReportController;
	
	/**
	 * Class constructor instantiating a new ProductsReportControllerImpl object.
	 */
	public ProductsReportViewImpl() {
		this.productsReportController = new ProductsReportControllerImpl();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void listStockToReplace() {
		try {
			StringBuilder sb = new StringBuilder();
			List<Product> products = this.productsReportController.listStockToReplace();
			if(products != null && !products.isEmpty()) {
				for(Product prod : products) {
					sb.append(prod).append(Constants.LINE_SEPARATOR);
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing All Products that Needs to be Replace", 
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
}
