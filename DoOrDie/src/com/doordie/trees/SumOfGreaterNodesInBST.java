package com.doordie.trees;

/**
 * 
 * Given a BST, replace value of each node with 'sum of all nodes 
 * with value greater than or equal to the node'
 * 
 */

public class SumOfGreaterNodesInBST {

	public static int update(TreeNode root, int sum) {
		if (root == null)
			return sum;
		
		//update the value of right child node.
		int right = update(root.right, sum);
		
		//update the current node
		root.value += right;
		
		//update the left child node
		return update(root.left, root.value);
	}

	public static void main(String[] args) {
		String nodes = "4 2 1 # # 3 # # 6 5 # # 7 # #";
		TreeNode root = Tree.buildTree(nodes);

		System.out.println("Original Tree: ");
		Tree.inorder(root);

		SumOfGreaterNodesInBST.update(root, 0);
		
		System.out.println("\n\nUpdated Tree: ");
		Tree.inorder(root);
	}

}
