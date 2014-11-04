package com.doordie.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Given two integers k and n, list all 'k' numbers (numbers can repeat and 1 <= number <= 9) 
 * whose sum is 'n' 
 * 
 * For Example
 * 	Input: k=3, n=21. 
 * 	Output: (7,7,7), (6,7,9), ... etc
 * 
 */

public class SumOfKNumbers {

	public static void sumOfKNumbers(int n, int k, Set<List<Integer>> sequences, List<Integer> currentSequence) {
		if (currentSequence.size() == k) {
			if (n == 0) 
				sequences.add(new ArrayList<Integer>(currentSequence));
			return;
		}
		
		for (int i = 1; i < 9; i++) {
			if (i <= n) {
				Integer number = i;
				currentSequence.add(number);
				SumOfKNumbers.sumOfKNumbers(n - i, k, sequences, currentSequence);
				currentSequence.remove(number);
			}
		}
	}
	public static void main(String[] args) {
		Set<List<Integer>> sequences = new HashSet<List<Integer>>();
		int n = 21, k = 3;
		
		SumOfKNumbers.sumOfKNumbers(n, k, sequences, new ArrayList<Integer>());
		
		for (List<Integer> sequence : sequences) {
			System.out.println(sequence);
		}
	}

}
