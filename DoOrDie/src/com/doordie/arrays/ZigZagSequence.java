package com.doordie.arrays;

import java.util.Arrays;
/**
 * A sequence of numbers is called a zig-zag sequence if the differences between 
 * successive numbers strictly alternate between positive and negative. The first 
 * difference (if one exists) may be either positive or negative. A sequence with 
 * fewer than two elements is trivially a zig-zag sequence.
 * 
 * For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) 
 * are alternately positive and negative.
 * 
 * In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences, the first because 
 * its first two differences are positive and the second because its last difference is zero.
 * 
 * Given a sequence of integers, sequence, return the length of the longest subsequence 
 * of sequence that is a zig-zag sequence. 
 * 
 * A subsequence is obtained by deleting some number of elements (possibly zero) from the 
 * original sequence, leaving the remaining elements in their original order.
 */

public class ZigZagSequence {

	public static int lengthOfZigZagSequence(int[] A) {
		if (A.length <= 2)
			return A.length;
		
		int[] up = new int[A.length];
		int[] down = new int[A.length];
		
		int maxLen = 1;
		
		up[0] = 1;
		down[0] = 1;

		for (int i = 1; i < A.length; i++) {
			up[i] = 1;
			down[i] = 1;
			
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j])
					up[i] = Math.max(down[j] + 1, up[i]);

				if (A[i] < A[j])
					down[i] = Math.max(up[j] + 1, down[i]);
			}
			
			maxLen = Math.max(maxLen, Math.max(up[i], down[i]));
		}
		
		return maxLen;
	}
	
	public static void main(String[] args) {
		int[][] tests = {
							{100},
							{10, 20},
							{10, 20, 30},
							{10, 10, 10},
							{1, 10, 2, 9, 3, 8},
							{10, 1, 9, 2, 8},
							{1, 2, 10, 5, 4, 6, 3},
						};
		
		for (int[] test : tests) {
			System.out.println(Arrays.toString(test) + " => " + ZigZagSequence.lengthOfZigZagSequence(test));
		}
	}

}
