package com.doordie.trees;

public class IterativeTreeTraversal {

	//iterative preorder
	public static void preorder(TreeNode root) {
		while (root != null) {
			if (root.left == null) {
				System.out.print(root.value + " ");
				root = root.right;
			} else {
				TreeNode node = root.left;
				while (node.right != null && node.right != root)
					node = node.right;
				
				if (node.right == root) {
					node.right = null;
					root = root.right;
				} else {
					node.right = root;
					System.out.print(root.value + " ");
					root = root.left;
				}
			}
		}
		System.out.println();
	}
	

	//iterative inorder
	public static void inorder(TreeNode root) {
		while (root != null) {
			if (root.left == null) {
				System.out.print(root.value + " ");
				root = root.right;
			} else {
				TreeNode node = root.left;
				while (node.right != null && node.right != root)
					node = node.right;
				
				if (node.right == null) {
					node.right = root;
					root = root.left;
				} else {
					System.out.print(root.value + " " );
					node.right = null;
					root = root.right;
				}
			}
		}
		System.out.println();
	}
	
	public static void postorder(TreeNode root) {
		
	}

	//Tester
	public static void main(String[] args) {
		String nodes = "1 2 4 # # 5 # # 3 6 # # 7 # #";
		TreeNode root = Tree.buildTree(nodes);
		
		//preorders
		Tree.preorder(root);
		IterativeTreeTraversal.preorder(root);
		
		//inorders
		Tree.inorder(root);
		IterativeTreeTraversal.inorder(root);
		
		//postorder
		Tree.postorder(root);
		IterativeTreeTraversal.postorder(root);
	}

}
