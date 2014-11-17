package com.doordie.trees;

/**
 * Given a tree
 * 		   1
 *       /   \
 *      2     3
 *     / \   / \
 *    4   5 6   7
 *   / \
 *  8   9  
 * 
 * Chain length of node 1 = 3 + 2 + 1 = {count of 3 corresponds to node 2 , 
 * node 4, node 8 ; count of 2 corresponds to node 3, node 7 ; 1 corresponds 
 * to node 1 itself }
 * 
 * Similarly, chain length of node 2 = 2 + 1 + 1 The max chain length here 
 * is of node 1 which is 5. So, the output should be 5.
 *
 */

public class ChainSum {

	private static int longestChain(TreeNode root) {
		if (root == null)
			return 0;
		
		int lChain = longestChain(root.left);
		int rChain = longestChain(root.right);
		
		return Math.max(lChain, rChain) + 1;
		
	}
	
	public static int chainSum(TreeNode root) {
		if (root == null)
			return 0;
		
		return longestChain(root.left) + longestChain(root.right);
	}
	
	public static void main(String[] args) {
		String nodes = "1 2 4 8 # # 9 # # 5 # # 3 6 # # 7 # #";
		TreeNode root = Tree.buildTree(nodes);

		Tree.inorder(root);
		System.out.println("\nChain sum for root node is " + ChainSum.chainSum(root));
	}

}
