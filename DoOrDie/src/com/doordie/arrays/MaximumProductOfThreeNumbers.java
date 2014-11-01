package com.doordie.arrays;

import java.util.Arrays;

/**
 * Given an (singed) integer array, find and print three element in the 
 * array whose product is maximum. 
 */

public class MaximumProductOfThreeNumbers {

	public static int[] maxProduct(int[] A) {
		int[] output = new int[3];
		int[] min = new int[2];
		int negative = 0;

		Arrays.fill(output, Integer.MIN_VALUE);
		Arrays.fill(min, 0);
		
		for (int i = 0; i < A.length; i++) {
			//get the two minimum values
			if (A[i] <= 0) {
				if (A[i] < min[1]) {
					min[0] = min[1];
					min[1] = A[i];
				} else if (A[i] < min[0]) {
					min[0] = A[i];
				}
				negative++; 
			}
			
			if(output[2] < A[i]) {
				output[0] = output[1];
				output[1] = output[2];
				output[2] = A[i];
			} else if (output[1] < A[i]) {
				output[0] = output[1];
				output[1] = A[i];
			} else if (output[0] < A[i]) {
				output[0] = A[i];
			}
			
		}//end of for
		
		if (negative != A.length) {
			int minProd = min[0] * min[1];
			if (minProd > output[0] * output[1]) {
				output[0] = min[0];
				output[1] = min[1];
			} else if (minProd  > output[1] * output[2]) {
				output[1] = min[0];
				output[2] = min[1];
			}
		}
		return output;
	}
	
	public static void print(int[] A) {
		int[] result = MaximumProductOfThreeNumbers.maxProduct(A);
		
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
			MaximumProductOfThreeNumbers.print(test);
	}

}
