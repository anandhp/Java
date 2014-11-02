package com.doordie.designpatterns.structural;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * FLYWEIGHT pattern comes in handy under low memory conditions
 * where sharing of large number of similar objects efficiently.
 * It avoids duplication of same object unnecessarily
 * 
 * Below is an example of shape object which is cached for efficient
 * sharing for its future references
 *
 */

public class Flyweight {
	
	public enum Color {
		Red, Blue, Green, Yellow
	}
	
	public enum ShapeType {
		Circle, Line
	}
	
	public abstract class Shape {
		protected Color color;
		
		public Shape(Color color) {
			this.color = color;
		}
		
		public abstract void draw(int x1, int y1, int x2, int y2);
	}
	
	public class Circle extends Shape {
		public Circle(Color color) {
			super(color);
		}
		
		@Override
		public void draw(int x1, int y1, int x2, int y2) {
			System.out.println("Drawing Circle :");
			System.out.println("\tColor :" + this.color);
			System.out.print("\tX1 :" + x1);
			System.out.print(", Y1 :" + y1);
			System.out.print(", X2 :" + x2);
			System.out.print(", Y2 :" + y2);
		}
	}
	
	public class Line extends Shape {
		public Line(Color color) {
			super(color);
		}
		
		@Override
		public void draw(int x1, int y1, int x2, int y2) {
			System.out.println("Drawing Line :");
			System.out.println("\tColor :" + this.color);
			System.out.print("\tX1 :" + x1);
			System.out.print(", Y1 :" + y1);
			System.out.print(", X2 :" + x2);
			System.out.print(", Y2 :" + y2);
		}
	}
	
	public class FlyweightFactory {
		private Map<Color, Shape> shapesByColor = new HashMap<Color, Shape>();
		
		public Shape getShape(Color color, ShapeType type) {
			Shape shape = shapesByColor.get(color);
			if (shape == null) {
				switch (type) {
				case Circle:
					shape = new Circle(color);
					break;
				case Line:
					shape = new Line(color);
				}
				
				shapesByColor.put(color, shape);
			}
			return shape;
		}
	}
	
	public static void main(String[] args) {
		FlyweightFactory flyweigher = new Flyweight().new FlyweightFactory();
		
		Shape shapeOne = flyweigher.getShape(Color.Red, ShapeType.Circle);
		Shape shapeTwo = flyweigher.getShape(Color.Red, ShapeType.Circle);
		
		System.out.println(shapeOne.hashCode() + " " + shapeTwo.hashCode());
		
	}

}
