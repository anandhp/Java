package myjava.core.basics;

/**
 * Duplicate methods in interfaces
 *
 */
public class Interfaces {

	public static interface StringInterface {
		public void print();
		public void print(String o);
		//public String print(Double o);
	}
	
	public static interface IntegerInterface {
		public void print();
		public void print(Integer o);
		//public Integer print(Double o);
	}
	
	public static class Implementor implements StringInterface, IntegerInterface {

		@Override
		public void print() {
			System.out.println("Common print");
		}

		@Override
		public void print(String o) {
			System.out.println("String print " + o);
		}

		@Override
		public void print(Integer o) {
			System.out.println("Integer print " + o);
		}

		/**
		THIS GIVES COMPILATION ERROR
		
		@Override
		public String print(Double o) {
			return null;
		}
		
		@Override
		public Integer print(Double o) {
			return null;
		}

		**/
		
	}
	
	public static void main(String[] args) {
		Implementor impl = new Implementor();

		StringInterface strIface = impl;
		strIface.print();
		strIface.print("Content");
		//strIface.print(1); // this gives compilation error
		
		IntegerInterface intIface = impl;
		intIface.print();
		//strIface.print("Content");// this gives compilation error
		intIface.print(100); 
	}

}
