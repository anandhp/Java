package com.doordie.trees;

import java.util.ArrayList;
import java.util.List;

/**
 *	Find pairs adding to given target
 *         4
 *       /   \
 *      2     6
 *     / \   / \
 *    1   3 5   9
 *             / \
 *            8   11
 *          
 *  Pairs adding to sum : 10
 *  1, 9
 *  2, 8
 *  4, 6
 *  
 *  Pairs adding to sum : 20
 *  9, 11
 *  
 *  Pairs adding to sum : 11
 *  2, 9
 *  3, 8
 *  5, 6
 *  
 *  Pairs adding to sum : 13
 *  2, 11
 *  4, 9
 *  5, 8
 *  
 *  Pairs adding to sum : 30
 *
 **/

public class PairsEqualsToTarget {

	// Get the items to a array
	// Find the elements in the array adding to sum
	public static void printPairs(TreeNode root, int target) {
		if (root == null)
			return;
		
		List<Integer> inorder = new ArrayList<Integer>();
		fillInOrder(root, inorder);
		
		Integer[] values = new Integer[inorder.size()];
		values = inorder.toArray(values);
		
		for (int i = 0, j = values.length - 1; i < j;) {
			int sum = values[i] + values[j];
			if (sum > target)
				j--;
			else if (sum < target)
				i++;
			else {
				System.out.println(values[i] + ", " + values[j]);
				i++;
				j--;
			}
		}
	}
	
	private static void fillInOrder(TreeNode root, List<Integer> inorder) {
		if (root == null)
			return;
		
		fillInOrder(root.left, inorder);
		inorder.add(root.value);
		fillInOrder(root.right, inorder);
	}

	
	//tester
	public static void main(String[] args) {
		String nodes = "4 2 1 # # 3 # # 6 5 # # 9 8 # # 11 # #";
		int [] tests = {10, 20, 11, 13, 30};
		
		TreeNode root = Tree.buildTree(nodes);

		Tree.inorder(root);
		
		for (int test : tests) {
			System.out.println("\nPairs adding to sum : " + test);
			PairsEqualsToTarget.printPairs(root, test);
		}
	}
}
