package com.doordie.designpatterns.structural;

/**
 * Decorator pattern example. A class example of window system is used
 * to demo the decorator patter.
 *
 */

public class Decorator {
	
	//Component Interface
	public interface Window {
		public void draw();
	}
	
	//Concrete component
	
	public class BasicWindow implements Window {

		@Override
		public void draw() {
			System.out.println("\nBasic Window");
		}		
	}
	
	//Abstract Decorator
	public class WindowDecorator implements Window {

		private Window window = null;
		
		public WindowDecorator(Window window) {
			this.window = window;
		}
		
		@Override
		public void draw() {
			window.draw();
		}
	}
	
	//Concrete Decorator
	public class BorderedWindow extends WindowDecorator {

		public BorderedWindow(Window window) {
			super(window);
		}
		
		@Override
		public void draw() {
			super.draw();
			System.out.println("and Border");
		}
	}
	
	public class ScrollableWindow extends WindowDecorator {

		public ScrollableWindow(Window window) {
			super(window);
		}
		
		@Override
		public void draw() {
			super.draw();
			System.out.println("and Scrollbar");
		}
	}

	//Decorator tester
	public static void main(String[] args) {
		//Scrollable bordered window
		Window scrollableBordredWindow = new Decorator().new ScrollableWindow(new Decorator().new BorderedWindow(new Decorator().new BasicWindow()));
		scrollableBordredWindow.draw();
		
		//Scrollable window
		Window scrollableWindow = new Decorator().new ScrollableWindow(new Decorator().new BasicWindow());
		scrollableWindow .draw();
		
		//Bordred window
		Window borderedWindow = new Decorator().new BorderedWindow(new Decorator().new BasicWindow());
		borderedWindow .draw();
		
		
	}

}
