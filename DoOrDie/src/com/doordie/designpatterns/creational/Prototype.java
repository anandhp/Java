package com.doordie.designpatterns.creational;

/**
 *	Prototype pattern demo 
 */

public class Prototype {
	
	//Abstract cloneable
	public abstract class Shape implements Cloneable {
		public abstract void draw();
		
		public Shape clone() {
			Shape shape = null;
			try {
				shape = (Shape) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			
			return shape;
		}
	}
	
	public class Circle extends Shape {
		@Override
		public void draw() {
			System.out.println("Circle draw");
		}
	}
	
	public class Rectangle extends Shape {
		@Override
		public void draw() {
			System.out.println("Rectangle draw");
		}
	}

	//Tester
	public static void main(String[] args) {
		
		Shape[] shapes = new Shape[2];
		
		shapes[0] = new Prototype().new Circle();
		shapes[1] = new Prototype().new Rectangle();
		
		//Clone objects
		Shape clonedCircle = shapes[0].clone();
		clonedCircle.draw();

		Shape clonedRectangle = shapes[1].clone();
		clonedRectangle.draw();
	}

}
