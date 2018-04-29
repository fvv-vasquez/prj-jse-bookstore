package com.fvv.prj;

import java.util.ArrayList;
import java.util.List;

import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.bean.OrderItem;

/**
 * 
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class Test {
	
	public static void main(String a[]) {
		
		Order order = new Order();
		List<OrderItem> itemsOrder = new ArrayList<>();
		
		OrderItem orderItem1 = new OrderItem();		
		orderItem1.setOrder(order);
		orderItem1.setQuantity(2);
		itemsOrder.add(orderItem1);
		order.setOrderItems(itemsOrder);
		
		System.out.println(order.getOrderItems().get(0).getItemAmount());
		
		orderItem1.setItemAmount(222.44);
		
		System.out.println(order.getOrderItems().get(0).getItemAmount());
		
	}

}
