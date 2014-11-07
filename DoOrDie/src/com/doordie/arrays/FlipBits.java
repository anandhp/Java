package com.doordie.arrays;

/**
 * You are given a binary array with N elements: d[0], d[1], ... d[N - 1]. 
 * You can perform AT MOST one move on the array: choose any two integers [L, R], 
 * and flip all the elements between (and including) the L-th and R-th bits. 
 * L and R represent the left-most and right-most index of the bits marking the 
 * boundaries of the segment which you have decided to flip. 
 * 
 * What is the maximum number of '1'-bits (indicated by S) which you can obtain 
 * in the final bit-string? 
 *
 */

public class FlipBits {

	public static void flipBits(int[] bits) {
		int ones = 0, flippedOnes = 0;
		int startIndex = 0, endIndex = 0;
		int index = 0, currentOnes = 0;
		
		for (int i = 0; i < bits.length; i++) {
			//get current number of ones
			ones += bits[i];
			
			//flip the bits
			bits[i] = bits[i] == 0 ? 1 : -1;
			
			currentOnes += bits[i];

			//if current bit reduces the sequence
			//start from next index
			if (currentOnes < 0){
				index = i+1;
				currentOnes = 0;
			}	
			//check index is increasing the ones sequence
			else if (flippedOnes < currentOnes) {
				flippedOnes = currentOnes;
				startIndex = index;
				endIndex = i;
			} 
		}
		
		System.out.println("Total ones " + (ones + flippedOnes));
		System.out.println("Start Index " + startIndex);
		System.out.println("End Index " + endIndex);
	}

	public static void main(String[] args) {
		int[] bits = {1, 0, 1, 0, 0, 0, 0, 0 };
		
		FlipBits.flipBits(bits);
	}
}
