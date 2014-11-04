package com.doordie.problems;

/**
 * Find the number of trailing zeros in n!
 */

public class NumberOfTrailingZeros {

	public static int numberOfTrailingZeros(int n) {
		int  count = 0;
		
		for (int i = 5; n/i >= 1; i *= 5)
			count += n/i;

		return count;
	}

	public static void main(String[] args) {
		for (int i = 10; i <= 100; i+= 10)
			System.out.println("Trailing zeros in " + i + "! " + NumberOfTrailingZeros.numberOfTrailingZeros(i));
	}

}
