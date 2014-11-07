package com.doordie.heap;

import java.util.Arrays;
import java.util.Comparator;

public class HeapTester {

	//Max heap comparator
	public static class MaxComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer parent, Integer child) {
			return parent - child;
		}
		
	}
	
	//Min heap comparator
	public static class MinComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer parent, Integer child) {
			return child - parent;
		}
		
	}
	
	//testing function
	public static <T> void testHeap(T A[], Comparator<T> comparator) {
		Heap<T> heap = new Heap<T>(comparator);
		
		for (int i = 0; i < A.length; i++)
			heap.push(A[i]);

		System.out.println("\nArray " + Arrays.toString(A));
		System.out.print("Heap ");

		while (!heap.empty())
			System.out.print(heap.pop() + ", ");

		System.out.println();
		
	}
	
	//tester of maxheap and minheap
	public static void main(String[] args) {
		
		Integer A[] = {99, 60, 23, 55, 71, 9, 20, 43, 86};
		HeapTester.testHeap(A, new MaxComparator());	//maxheap
		HeapTester.testHeap(A, new MinComparator());	//min heap
	}

}
 