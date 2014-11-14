package com.doordie.problems;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class SortProduct {

	public static class Product {
		private String productName;
		private double price;
		private Date date;
		
		public Product(String name, double price, String date) throws ParseException {
			this.productName = name;
			this.price = price;
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			this.date = dateFormat.parse(date);
		}
		
		public String getName() { return productName; }
		public double getPrice() { return price; }
		public Date getDate() { return date; }

		public String toString() {
			StringBuilder strBldr = new StringBuilder();
			strBldr.append(productName + "\t");
			strBldr.append(price + "\t");
			strBldr.append(date);
			
			return strBldr.toString();
		}
		
		//Date comparator
		public static class DateComparator implements Comparator<Product> {
			@Override
			public int compare(Product first, Product second) {
				return first.getDate().compareTo(second.getDate());
			}
		}
		
		//Price comparator
		public static class PriceComparator implements Comparator<Product> {
			@Override
			public int compare(Product first, Product second) {
				return (int)(first.getPrice() - second.getPrice());
			}
		}
		
		//Name comparator
		public static class NameComparator implements Comparator<Product> {
			@Override
			public int compare(Product first, Product second) {
				return first.getName().compareTo(second.getName());
			}
		}
	}
	
	public static void main(String[] args) throws ParseException {
		Set<Product> items = new TreeSet<Product>(new Product.NameComparator());
		items.add(new Product("Book", 200.5, "11-08-2014"));
		items.add(new Product("Shirt", 102.0, "09-06-2013"));
		items.add(new Product("Pant", 500.5, "11-11-2012"));
		items.add(new Product("Mobile", 205.5, "11-12-2010"));
		
		for (Product item : items) {
			System.out.println(item.toString());
		}
	}
}
