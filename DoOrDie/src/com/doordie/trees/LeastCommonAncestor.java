package com.doordie.trees;

/**
 * Find least common ancestor (LCA) of two child nodes. 
 *   For Example: In the below tree
 *
 *         1
 *       /   \
 *      2     3
 *     / \   / \
 *    4   5 6   7
 *   
 *
 *   LCA of 4, 2 is 2
 *   LCA of 5, 6 is 1
 *   LCA of 6, 7 is 3
 *
 */

public class LeastCommonAncestor {

	public static TreeNode commonAncestor(TreeNode root, int childOne, int childTwo) {
		if (root == null)
			return null;
		
		if (childOne == root.value || childTwo == root.value)
			return root;
		
		TreeNode left = commonAncestor(root.left, childOne, childTwo);
		TreeNode right = commonAncestor(root.right, childOne, childTwo);
		
		if (left != null && right != null)
			return root;
		
		return left == null ? right : left;
	}
	
	public static void main(String[] args) {
		String nodes = "1 2 4 # # 5 # # 3 6 # # 7 # #";
		TreeNode root = Tree.buildTree(nodes);

		TreeNode lca = null;
		
		lca = LeastCommonAncestor.commonAncestor(root, 4, 2);
		System.out.println(lca.value);
		
		lca = LeastCommonAncestor.commonAncestor(root, 5, 6);
		System.out.println(lca.value);

		lca = LeastCommonAncestor.commonAncestor(root, 6, 7);
		System.out.println(lca.value);
	}
} 