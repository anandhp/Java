package com.doordie.trees;

import java.util.Arrays;

/**
 * 	Given post order traversal of BST, validate if its valid
 * 
 * 		   4
 *       /   \
 *      2     6
 *     / \   / \
 *    1   3 5   7
 * 
 *	
 *	For example:
 *		{1, 3, 2, 5, 7, 6, 4}  returns true
 *		{1, 3, 6, 5, 7, 2, 4}  returns false
 *
 **/

public class ValidBSTInPostOrder {

	public static boolean validBST(int[] values) {
		//if less than two elements in the array.
		//its always valid
		if (values.length < 2) return true;
		
		int i = 0;
		
		//find the beginnig of right sub tree 
		for (; i < values.length  && values[i] < values[values.length - 1]; i++);
		
		//now valid right subtreee
		for (int j = i; j < values.length - 1; j++) {
			if (values[j] < values[values.length - 1])
				return false;
		}
		
		return validBST(Arrays.copyOfRange(values, 0, i))
				&& validBST(Arrays.copyOfRange(values, i, values.length - 1));
	}
	
	//main function
	public static void main(String[] args) {
		int[][] tests = {
							{ 1, 3, 2, 5, 7, 6, 4 }, 	//valid BST
							{ 1, 2, 6, 5, 7, 3, 4 },	//Invalid BST
							{ 5, 7, 6, 9, 11, 10, 8 },	//valid BST
							{ 5, 7, 9, 6, 11, 10, 8 },	//Invalid BST
						};
		
		for (int[] test : tests) {
			System.out.println(Arrays.toString(test));
			System.out.println(ValidBSTInPostOrder.validBST(test));
			System.out.println();
		}
	}
}
