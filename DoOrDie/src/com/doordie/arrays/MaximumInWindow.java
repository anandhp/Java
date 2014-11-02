package com.doordie.arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * Print maximum number of floating window in the array
 * 
 * For example
 * 		Given array {1, 3, -1, -3, 5, 3, 6, 7} and Window size as 3
 * 		Result 		{3, 3, 5, 5, 6, 7}
 *
 */

public class MaximumInWindow {

	public static void printMaxInWindow(int[] A, int windowSize) {
		Deque<Integer> queue = new LinkedList<Integer>();
		int i = 0;
		
		while (i < windowSize) {
			if (queue.isEmpty() || A[queue.getLast()] > A[i])
				queue.add(i++);
			else
				queue.removeLast();
		}
		
		while (i < A.length) {
			System.out.print(A[queue.peek()] + " ");
			
			while (!queue.isEmpty() && A[queue.getLast()] < A[i])
				queue.removeLast();
			
			if (!queue.isEmpty() && i - queue.peek() >= windowSize)
				queue.removeFirst();
			
			queue.add(i++);
		}
		
		System.out.println(A[queue.peek()]);
	}	
	
	public static void main(String[] args) {
		int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
		MaximumInWindow.printMaxInWindow(A, 3);
 	}

}
