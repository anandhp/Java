package com.doordie.trees;

/**
 * Given a tree, get sum of tree nodes except leaves
 * 		   1
 *       /   \
 *      2     3
 *     / \   / \
 *    4   5 6   7
 *
 */
public class SumTreeExceptLeaves {
	public static int sumExceptLeaves(TreeNode root) {
		if (root == null)
			return 0;
		
		if (root.isLeaf())
			return 0;
		
		return root.value 
				+ sumExceptLeaves(root.left) 
				+ sumExceptLeaves(root.right);
		
	}
	public static void main(String[] args) {
		String nodes = "1 2 4 # # 5 # # 3 6 # # 7 # #";

		TreeNode root = Tree.buildTree(nodes);
		Tree.inorder(root);
		System.out.println("\nSum "+ SumTreeExceptLeaves.sumExceptLeaves(root));
	}

}
