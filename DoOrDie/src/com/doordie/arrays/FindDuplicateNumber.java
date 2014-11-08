package com.doordie.arrays;

public class FindDuplicateNumber {

	public static int findDuplicate(int[] A) {

		for (int i = 0; i < A.length; i++) {
			int index = Math.abs(A[i]);
			
			if (A[index] > 0) 
				A[index] = A[index] * -1;
			else
				return Math.abs(A[index]);
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 2, 2, 4, 5};
		System.out.println("Duplicate number "+ FindDuplicateNumber.findDuplicate(A));
	}

}
