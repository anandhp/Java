package com.doordie.trees;

import java.util.Stack;

public class TreeZigZagTraversal {

	public static void zigZagTraversal(TreeNode root) {
		if (root == null)
			return;
		
		Stack<TreeNode> parents = new Stack<TreeNode>();
		Stack<TreeNode> childs = new Stack<TreeNode>();
		boolean forward = true;
		
		parents.add(root);
		
		while (!parents.empty()) {
			TreeNode current = parents.peek();
			parents.pop();
			
			current.print();
			if (forward) {
				if (current.right != null)
					childs.push(current.right);
				if (current.left != null)
					childs.push(current.left);
			} else {
				if (current.left != null)
					childs.push(current.left);
				if (current.right != null)
					childs.push(current.right);
			}
			
			if (parents.empty()) {
				forward = !forward;
				//swap the stacks
				Stack<TreeNode> temp = parents;
				parents = childs;
				childs = temp;
			}
		}//end of while
	}

	public static void main(String[] args) {
		String nodes = "1 2 4 # # 5 # # 3 6 # # 7 # #";
		TreeNode root = Tree.buildTree(nodes);

		Tree.inorder(root);
		TreeZigZagTraversal.zigZagTraversal(root);
	}

}
