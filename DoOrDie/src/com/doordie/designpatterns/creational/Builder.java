package com.doordie.designpatterns.creational;

import java.util.ArrayList;

/**
 * 	BUILDER PATTERN is used to separate the construction of a
 *  complex object from its representation, allowing the same 
 *  construction process to create various representations.
 *  
 *	Below is a Builder Pattern example using typical meal order
 *	Meal consists of many items which are built by series
 *	of steps
 */

public class Builder {
	
	public interface Item {
		public String name();
		public float price();
	}
	
	public abstract class Burger implements Item {
		@Override
		public abstract String name();
		
		@Override
		public abstract float price();		
	}
	
	public class VegBurger extends Burger {
		@Override
		public String name() {
			return "Veg Burger";
		}
		
		@Override
		public float price() {
			return 15.0f;
		}
	}
	
	public class ChickenBurger extends Burger {
		@Override
		public String name() {
			return "Chicken Burger";
		}
		
		@Override
		public float price() {
			return 20.5f;
		}
	}
	
	public abstract class CoolDrink implements Item {
		@Override
		public abstract String name();
		
		@Override
		public abstract float price();
	}
	
	public class Coke extends CoolDrink {
		@Override
		public String name() {
			return "Coke";
		}
		
		@Override
		public float price() {
			return 5.5f;
		}
	}
	
	public class Pepsi extends CoolDrink {
		@Override
		public String name() {
			return "Pepsi";
		}
		
		@Override
		public float price() {
			return 4.5f;
		}
	}
	
	public class Meal {
		ArrayList<Item> items = new ArrayList<Item>();
		
		public void addItem(Item item) {
			items.add(item);
		}
		
		public float getPrice() {
			float price = 0;
			for (Item item : items)
				price += item.price();
			return price;		
		}
		
		public void showItems() {
			for (Item item : items) {
				System.out.print("Item " + item.name());
				System.out.println(", Price " + item.price());
			}
		}
	}
	
	//Builder class
	public class MealBuilder {
		public Meal buildVegMeal() {
			Meal meal = new Meal();
			meal.addItem(new VegBurger());
			meal.addItem(new Coke());
			return meal;
		}
		public Meal buildNonVegMeal() {
			Meal meal = new Meal();
			meal.addItem(new ChickenBurger());
			meal.addItem(new Pepsi());
			return meal;
		}
	}

	//Tester function
	public static void main(String[] args) {
		MealBuilder builder = new Builder().new MealBuilder();

		System.out.println("Veg Meal");
		Meal vegMeal = builder.buildVegMeal();
		vegMeal.showItems();
		System.out.println("Price of Veg meal " + vegMeal.getPrice());

		System.out.println("\nNonVeg Meal");
		Meal nonVegMeal = builder.buildNonVegMeal();
		nonVegMeal.showItems();
		System.out.println("Price of Non-Veg meal " + nonVegMeal.getPrice());
	}

}
