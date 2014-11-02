package com.doordie.designpatterns.creational;

/**
 * SINGLETON pattern ensures a class has only one instance, 
 * and provide a global point of access to it.
 * 
 * Below is an example of Singleton class. It exposes
 * getInstace() method which always ensures only one instance
 * of the class is created
 *
 */

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
