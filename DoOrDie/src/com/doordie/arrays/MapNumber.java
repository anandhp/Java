package com.doordie.arrays;

public class MapNumber {

	public static int mapNumber(int min, int max) {
		double random = Math.random(); //Generates values 0 - 1
		System.out.print(random + " ");
		return (int) (min * (1.0 - random) + max * random);
	}
	
	public static void main(String[] args) {
		System.out.println(MapNumber.mapNumber(250, 500));
		System.out.println(MapNumber.mapNumber(300, 400));
		System.out.println(MapNumber.mapNumber(100, 200));
		System.out.println(MapNumber.mapNumber(100, 1000));
	}

}
