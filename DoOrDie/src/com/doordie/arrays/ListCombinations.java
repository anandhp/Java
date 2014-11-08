package com.doordie.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of array lists containing elements, write a function that 
 * prints out the permutations of of the elements such that, each of the 
 * permutation set contains only 1 element from each array list and there 
 * are no duplicates in the list of permutation sets. 
 *
 */

public class ListCombinations {

	public static <T> void printCombinations(List<List<T>> lists, List<T> current, int  index) {
		if (index == lists.size()) {
			System.out.println(current);
			return;
		}
		
		for (T item : lists.get(index)) {
			current.add(item);
			printCombinations(lists, current, index + 1);
			current.remove(item);
		}
	}

	
	public static <T> void printCombos(T[] A, T[] B, T[] C) {
		List<List<T>> lists = new ArrayList<List<T>>();

		lists.add(Arrays.asList(A));
		lists.add(Arrays.asList(B));
		lists.add(Arrays.asList(C));

		printCombinations(lists, new ArrayList<T>(), 0);
	}
	
	public static void main(String[] args) {

		Character[] caps = {'A', 'B', 'C', 'D'};
		Character[] smalls = {'a', 'b', 'c', 'd', 'e'};
		Character[] digits = {'1', '2', '3'};
		
		printCombos(caps, smalls, digits);
		
		String[] A = {"a1", "b1", "c1", "d1"};
		String[] B = {"a2", "b2", "c2"};
		String[] C = {"a3", "b3", "c3"};
		
		printCombos(A, B, C);
		
		Integer[] X = {1, 2, 3};
		Integer[] Y = {1, 2, 3};
		Integer[] Z = {1, 2, 3};
		
		printCombos(X, Y, Z);
	}

}
