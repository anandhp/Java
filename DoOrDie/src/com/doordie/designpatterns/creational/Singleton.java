package com.doordie.designpatterns.creational;

public class Singleton {
	//Single instance of this class
	private static Singleton instance = null;

	//private constructor
	private Singleton() {}
	
	//double locking instance method
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		}
		
		return instance;
	}
	
	//Testing function
	public static void main(String[] args) {
		Singleton instanceOne = Singleton.getInstance();
		Singleton instanceTwo = Singleton.getInstance();
		
		System.out.println("instanceOne is " + instanceOne.hashCode());
		System.out.println("instanceTwo is " + instanceTwo.hashCode());
	}

}
