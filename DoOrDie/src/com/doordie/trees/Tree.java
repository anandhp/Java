package com.doordie.trees;

import java.util.StringTokenizer;

/**
 * class to hold helper functions of tree data structure
 */
public class Tree {
	
	public static TreeNode buildTree(String nodes) {
		StringTokenizer tokenizer = new StringTokenizer(nodes);
		return Tree.buildTree(tokenizer);
	}

	private static TreeNode buildTree(StringTokenizer tokenizer) {
		//No more tokens
		if (tokenizer.hasMoreElements() == false)
			return null;

		//get the next token and create tree node with it
		String token = tokenizer.nextToken();
		try {
			TreeNode root = new TreeNode(Integer.parseInt(token));
			root.left = buildTree(tokenizer);
			root.right = buildTree(tokenizer);
			return  root;
			
		}catch(NumberFormatException e) {
			//if token is not a number return null node
			return null;
		}
	}
	
	//recursive preorder
	public static void preorder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.value + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	//recursive inorder
	public static void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}
	
	//recursive posorder
	public static void postorder(TreeNode root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.value + " ");
	}
	
}
