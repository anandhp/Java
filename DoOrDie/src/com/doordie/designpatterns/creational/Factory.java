package com.doordie.designpatterns.creational;

/**
 * Factory pattern example
 */
public class Factory {
	//Type of controls
	public enum ControlType {
		Button, TextBox, SelectBox
	}

	//Abstract type
	public abstract class Control {
		
		public abstract void draw();
	}
	
	//Concrete types 
	public class Button extends Control {

		@Override
		public void draw() {
			System.out.println("Drawing button control");
		}
		
	}
	
	public class TextBox extends Control {

		@Override
		public void draw() {
			System.out.println("Drawing textbox control");
		}
		
	}
	
	public class SelectBox extends Control {

		@Override
		public void draw() {
			System.out.println("Drawing selectbox control");
		}
		
	}
	
	public static Control createControl(ControlType type) {
		switch (type) {
		case Button:
			return new Factory().new Button();
		case TextBox:
			return new Factory().new TextBox();
		case SelectBox:
			return new Factory().new SelectBox();
		}
		
		return null;
	}

	public static void main(String[] args) {
		Control[] controls = new Control[3];

		//create controls
		controls[0] = Factory.createControl(ControlType.Button);
		controls[1] = Factory.createControl(ControlType.TextBox);
		controls[2] = Factory.createControl(ControlType.SelectBox);
		
		//test controls
		for (int i = 0; i < controls.length; i++) {
			controls[i].draw();
		}
	}

}
