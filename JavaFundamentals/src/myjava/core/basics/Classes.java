package myjava.core.basics;

public class Classes {
	public interface Shape {
		public int data = 0;
		public void draw();
	}
	
	public abstract class AbstractShape implements Shape {
		public int data = 1;
		public void draw() {
			System.out.println("Abstract Shape Draw");
		}
	}
	
	public class Circle extends AbstractShape{
		public void draw() {
			super.draw();
			System.out.println("Circle draw" + super.data);
		}
	}
	
	public static void main(String[] args) {
		Shape shape = new Classes().new Circle();
		shape.draw();
	}

}
