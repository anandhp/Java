package com.doordie.designpatterns.structural;

/**
 * Adapter pattern example. Adapter pattern makes two in 
 * compatible interfaces work together.
 */
public class Adapter {
	
	//Adaptee
	class LegacyRectangle {
		public LegacyRectangle(int x, int y, int w, int h) {
		}
		
		public void draw() {
			System.out.println("Legacy rectangle draw");
		}
	}
	
	public interface Rectangle {
		public void draw();
	}
	
	//Adapter class
	class RectangleAdapter extends LegacyRectangle implements Rectangle {
		public RectangleAdapter(int x1, int y1, int x2, int y2) {
			super(x1, y1, Math.abs(x2-x1), Math.abs(y2 -y1));
		}

		@Override
		public void draw() {
			super.draw();
		}
	}

	//Test adapter functionality
	public static void main(String[] args) {
		Rectangle rectangle = new Adapter().new RectangleAdapter(0, 0, 20, 20);
		rectangle.draw();
	}

}
