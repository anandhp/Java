package com.doordie.arrays;

/**
 * Program to shuffle sorted list of numbers
 */

public class ShuffleNumbers {
	
	public static void main(String[] args) {

		//sorted list of numbers
		int []  numbers = {1, 2, 3, 4, 5, 6};
		
		for (int i = 0; i < numbers.length; i++) {
			double r = Math.random();
			int index = (int)((1 - r) + (r * numbers.length));
			
			//swap numbers
			int temp = numbers[i];
			numbers[i] = numbers[index];
			numbers[index] = temp;
		}
		
		//print shuffled numbers
		for (int i = 0; i < numbers.length; i++)
			System.out.print(numbers[i] + " ");
	}

}
