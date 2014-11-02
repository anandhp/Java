package com.doordie.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * STRATEGY pattern define a family of algorithms, encapsulate each one,
 * and make them interchangeable. Strategy lets the algorithm vary 
 * independently from clients that use it.
 * 
 * Below is an example of payment handling in shopping. Payment options
 * are changed by client dynamically.
 *
 */
public class Strategy {

	//abstract strategy
	public interface Payment {
		public void pay(double amount);
	}
	
	//concrete strategies 
	public class CredicardPayment implements Payment {
		@Override
		public void pay(double amount) {
			System.out.println(amount + " is paid using Credit Card");
		}
	}
	
	public class CashPayment implements Payment {

		@Override
		public void pay(double amount) {
			System.out.println(amount + " is paid by cash");
		}
	}
	
	//items
	public static class Item {
		private String itemCode;
		private double price;
		
		public Item(String itemCode, double price) {
			this.itemCode = itemCode;
			this.price = price;
		}
		
		public String getItemCode() { return this.itemCode; }
		public double getPrice() { return this.price; }
	}
	
	//Strategy client
	public static class ShoppingCart {
		List<Item> items = new ArrayList<Item>();
		
		public void addItem(Item newItem) {
			items.add(newItem);
		}
		
		public void removeItem(Item itemToRemove) {
			items.remove(itemToRemove);
		}
		
		public double getTotal() {
			double total = 0;
			for (Item item : items) {
				total += item.getPrice();
			}
			
			return total;
		}
		
		public void pay(Payment paymentType) {
			double total = this.getTotal();
			paymentType.pay(total);
		}
	}

	//Strategy pattern tester
	public static void main(String[] args) {
		//Create shopping cart
		ShoppingCart cart = new ShoppingCart();
		
		//add items to be purchaged
		cart.addItem(new Item("1234", 20.5));
		cart.addItem(new Item("4532", 13.5));
		cart.addItem(new Item("2343", 1.75));
		
		//pay the amount
		cart.pay(new Strategy().new CredicardPayment());
		cart.pay(new Strategy().new CashPayment());
	}

}
