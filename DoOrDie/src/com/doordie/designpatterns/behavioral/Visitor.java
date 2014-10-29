package com.doordie.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor pattern example
 *
 */

public class Visitor {
	
	//Abstract visitor
	public interface BaseVisitor {
		public double visit(Book book);
		public double visit(Fruit fruit);
		public double visit(Cloth cloth);
	}
	
	//Visitable interface
	public interface Visitable {
		public double accept(BaseVisitor visitor);
	}
	
	
	//Abstract element
	public interface Item {
		public double getPrice();
		public double accept(BaseVisitor visitor);
	}
	
	public class Book implements Item, Visitable {

		private double price;
		
		public Book(double price) {
			this.price = price;
		}
		
		public double getPrice() { return this.price; }
		
		@Override
		public double accept(BaseVisitor visitor) {
			return visitor.visit(this);
		}
	}
	
	//Concrete elements
	public class Fruit implements Item, Visitable {

		private double price;
		
		public Fruit(double price) {
			this.price = price;
		}
		
		public double getPrice() { return this.price; }
		
		@Override
		public double accept(BaseVisitor visitor) {
			return visitor.visit(this);
		}
	}

	public class Cloth implements Item, Visitable {

		private double price;
		
		public Cloth(double price) {
			this.price = price;
		}
		
		public double getPrice() { return this.price; }
		
		@Override
		public double accept(BaseVisitor visitor) {
			return visitor.visit(this);
		}
	}
	
	//Concrete visitor
	public class RegularShoppingVisitor implements BaseVisitor {

		@Override
		public double visit(Book book) {
			return book.getPrice() * 0.18 + book.getPrice();
		}

		@Override
		public double visit(Fruit fruit) {
			return fruit.getPrice() * 0.0 + fruit.getPrice();
		}

		@Override
		public double visit(Cloth cloth) {
			return cloth.getPrice() * 0.18 + cloth.getPrice();
		}
	}
	
	
	//Visitor pattern client
	public static void main(String[] args) {
		List<Item> items = new ArrayList<Item>();

		items.add(new Visitor().new Book(12.5));
		items.add(new Visitor().new Cloth(10.5));
		items.add(new Visitor().new Fruit(4.5));
		
		BaseVisitor visitor = new Visitor().new RegularShoppingVisitor();
		
		System.out.println("Item prices after tax");
		
		for (Item item : items) {
			System.out.println("Item " + item.accept(visitor));
		}
		
	}

}
