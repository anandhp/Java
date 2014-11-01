package com.doordie.trees;

public class FixBST {
	
	private TreeNode first = null, second = null;
	private TreeNode previous = null;

	private void findNodes(TreeNode root) {
		if (root == null)
			return;
		
		findNodes(root.left);
		
		if (previous == null)
			previous = root;
		
		if (previous.value > root.value) {
			if (first == null)
				first = previous;
			second = root;
		}
		
		previous = root;
		
		findNodes(root.right);
	}
	
	public void fix(TreeNode root) {
		//find the invalid nodes
		findNodes(root);
		
		//swap the invalid node values
		if (first != null && second != null) {
			int temp = first.value;
			first.value = second.value;
			second.value = temp;
		}
	}
	

	public static void main(String[] args) {
		String nodes = "4 6 1 # # 3 # # 2 5 # # 7 # #";
		TreeNode root = Tree.buildTree(nodes);
		
		Tree.inorder(root);
		System.out.println();
		
		new FixBST().fix(root);
		Tree.inorder(root);
		
	}

}
