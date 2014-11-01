package com.doordie.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *         
 *	return
 * 	[
 * 	   [5,4,11,2],
 * 	   [5,8,4,5]
 * 	]
 *
 */

public class PathSum {
	private static void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> current) {
		if (root == null)
			return;
		
		current.add(root.value);
        sum -= root.value;
		if (root.left == null && root.right == null && sum == 0)
				result.add(new ArrayList<Integer>(current));
        else {
    		pathSum(root.left, sum, result, current);
    		pathSum(root.right, sum, result, current);
        }
    	current.remove(current.size() - 1);
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();

        if (root == null)
        	return result;
        
        pathSum(root, sum, result, new ArrayList<Integer>());
        return result;
    }
	
	public static void main(String[] args) {
		String nodes = "5 4 11 7 # # 2 # # # 8 13 # # 4 5 # # 1 # #";
		TreeNode root = Tree.buildTree(nodes);
		List<List<Integer>> result = PathSum.pathSum(root, 22);
		System.out.println(result);
	}

}
