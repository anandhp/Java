package com.doordie.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Get next greater element in the array. 
 * 
 * For example
 * 		if given array is {1, 2, 5, 4, 3}
 * 		result should be  {2, 5, -1, -1, -1}
 */

public class NextGreaterElement {

	public static int[] nextGreaterElement(int[] A) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] result = new int[A.length];
		int i = 0;

		while (i < A.length) {
			if (stack.empty() || A[stack.peek()] >= A[i])
				stack.push(i++);
			else
				result[stack.pop()] = A[i];
		}
		
		while (!stack.empty())
			result[stack.pop()] = -1;
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 2, 5, 4, 3};
		int []result = NextGreaterElement.nextGreaterElement(A);
		
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(result));
	}
}
