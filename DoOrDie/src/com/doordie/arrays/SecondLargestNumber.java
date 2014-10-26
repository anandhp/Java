package com.doordie.arrays;

public class SecondLargestNumber {

	public static int secondLargestNumber(int[] A) {
		int firstMax = A[0], secondMax = -1;
		for (int i = 1; i < A.length; i++) {
			secondMax = Math.max(A[i], secondMax);
			if (secondMax > firstMax) {
				int temp = firstMax;
				firstMax = secondMax;
				secondMax = temp;
			}
		}
		
		return secondMax;
	}
	
	
	public static void main(String[] args) {
		int[] A = {5, 3, 2, 1, 9};
		System.out.println(SecondLargestNumber.secondLargestNumber(A));
	}

}
