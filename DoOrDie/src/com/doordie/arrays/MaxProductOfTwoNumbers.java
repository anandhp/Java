package com.doordie.arrays;

import java.util.Arrays;

/**
 * Given an (singed) integer array, find and print two element 
 * in the array whose product is maximum. 
 */

public class MaxProductOfTwoNumbers {

	public static int[] maxProduct(int[] A) {
		int[] output = new int[2];
		int[] min = new int[2];
		
		Arrays.fill(output, Integer.MIN_VALUE);
		Arrays.fill(min, 0);
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= 0) {
				if (A[i] < min[1]) {
					min[0] = min[1];
					min[1] = A[i];
				} else if (A[i] < min[0]) {
					min[0] = A[i];
				}
			}
			
			if (A[i] > output[1]) {
				output[0] = output[1];
				output[1] = A[i];
			} else if (A[i] > output[0]) {
				output[0] = A[i];
			}
			
			if (min[0] * min[1] > output[0] * output[1]) {
				output[0] = min[0];
				output[1] = min[1];
			}
		}//end of for
		
		return output;
	}
	
	public static void print(int[] A) {
		int[] result = MaxProductOfTwoNumbers.maxProduct(A);
		
		System.out.println("Array: " + Arrays.toString(A));
		System.out.println("Max Prod Numbers: " + Arrays.toString(result) + "\n");
	}
	
	public static void main(String[] args) {
		int[][] tests = {
				{-6, -1, -2, -33, -4, -15, -7, -28, -9,-10},
				{ 0, -1, -2, -33, 4, 15, -7, -28, -9,- 10},
				{ 0, -1, -2, -33, -4, -15, -7, -28, -9, -10},
				{6, 1, 2, 33, 4, 15, 7, 28, 9, 10}
			};

		for (int[] test : tests)
			MaxProductOfTwoNumbers.print(test);
	}
}
