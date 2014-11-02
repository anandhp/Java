package com.doordie.designpatterns.creational;

/**
 * 
 * ABSTRACT FACTORY provides an interface for creating families of related or 
 * dependent objects without specifying their concrete classes.
 * 
 * Below is an example Abstract Factory pattern for creating different graphic
 * controls for different platforms
 * 
 */

public class AbstractFactory {
	
	public enum ControlType {
		Button
	}
	
	public enum FactoryType {
		Windows, Linux
	}
	
	//abstract control
	public abstract class Control {
		public abstract void draw();
	}
	
	//concrete shape
	public class WinButton extends Control {
		@Override
		public void draw() {
			System.out.println("WinButton draw");
		}
	}
	
	public class LinButton extends Control {
		@Override
		public void draw() {
			System.out.println("LinButton draw");
		}
	}
	
	public abstract class ControlFactory {
		public abstract Control createControl(ControlType type);
	}
	
	public class WinFactory extends ControlFactory {
		@Override
		public Control createControl(ControlType type) {
			switch(type) {
			case Button:
				return new WinButton();
			}
			
			return null;
		}
	}
	
	public class LinFactory extends ControlFactory {
		@Override
		public Control createControl(ControlType type) {
			switch(type) {
			case Button:
				return new LinButton();
			}
			return null;
		}
	}
	
	public static ControlFactory createFactory(FactoryType type) {
		switch(type) {
		case Windows:
			return new AbstractFactory().new WinFactory();
		case Linux:
			return new AbstractFactory().new LinFactory();
		}
		return null;
	}

	//Tester function
	public static void main(String[] args) {
		//Win factory
		ControlFactory winFactory = AbstractFactory.createFactory(FactoryType.Windows);
		Control winButton = winFactory.createControl(ControlType.Button);
		winButton.draw();
		
		//Lin factory
		ControlFactory linFactory = AbstractFactory.createFactory(FactoryType.Linux);
		Control linButton = linFactory.createControl(ControlType.Button);
		linButton.draw();
	}
}
