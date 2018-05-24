package com.fvv.bookstore.util;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.bean.Cellphone;
import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.bean.Laptop;
import com.fvv.bookstore.bean.Magazine;
import com.fvv.bookstore.bean.Product;

/**
 * Utility class for the Order View.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class OrderViewUtil {
	
	/**
	 * Resolve proper value by product type.
	 * 
	 * @param clazz object to identify the type of product.
	 * @return the value.
	 */
	@SuppressWarnings("rawtypes")
	public static String resolveProperValueByType(final Class clazz) {
		String value = ProductValues.TITLE.getValue();
		if (clazz == Magazine.class) {
			value = ProductValues.NAME.getValue();
		} else if (clazz == Cellphone.class || clazz == Laptop.class) {
			value = ProductValues.BRAND.getValue();
		} 
		return value;
	}
	
	/**
	 * Resolve proper description for a product.
	 * 
	 * @param product to verify.
	 * @return the proper description for the product.
	 */
	public static String resolveProperDescription(final Product product) {
		String value = "";
		
		if (product instanceof Book) {
			value = ((Book) product).getTitle();
		}
		if (product instanceof Cellphone) {
			value = ((Cellphone) product).getBrand();
		}
		if (product instanceof Dvd) {
			value = ((Dvd) product).getTitle();
		}
		if (product instanceof Laptop) {
			value = ((Laptop) product).getBrand();
		}
		if (product instanceof Magazine) {
			value = ((Magazine) product).getName();
		}
		
		return value;
	}
	
	/**
	 * Enum for product values. 
	 * 
	 * @author Fatima Vasquez
	 * <p>Created on 2018</p>
	 * @version 1.0 	
	 *
	 */
	private enum ProductValues {			
		TITLE("title"),
		NAME("name"),
		BRAND("brand");
		
		private String value;
		
		/**
		 * Enum constructor.
		 * 
		 * @param value of String type.
		 */
		ProductValues(String value) {
			this.value = value;
		}
		
		/**
		 * Gets the value.
		 * 
		 * @return the value.
		 */
		public String getValue() {
			return this.value;
		}
	}
}
