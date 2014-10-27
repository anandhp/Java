package com.doordie.trees;

import java.util.Stack;

public class IterativeTreeTraversalStacks {

	//preorder
	public static void preorder(TreeNode root) {
		if (root == null)
			return;
		
		Stack<TreeNode> S = new Stack<TreeNode>();
		S.push(root);
		
		while (!S.empty()) {
			TreeNode current = S.peek();
			S.pop();
			
			System.out.print(current.value + " ");
			
			if (current.right != null)
				S.push(current.right);

			if (current.left != null)
				S.push(current.left);
		}

		System.out.println();
	}
	
	//inorder
	public static void inorder(TreeNode root) {
		if (root == null)
			return;
		
		TreeNode previous = null;
		Stack<TreeNode> S = new Stack<TreeNode>();
		S.push(root);
		
		while (!S.empty()) {
			
			//get current node from the stack
			TreeNode current = S.peek();
			
			//going down the tree
			if (previous == null 
					|| previous.left == current 
					|| previous.right == current) {
				if(current.left != null)
					S.push(current.left);
				else if (current.right != null) {
					current.print();
					S.push(current.right);
				} else {
					current.print();
					S.pop();
				}
			} 
			//if we are at root node after traversing left sub tree. 
			//print root and go to right subtree
			else if (current.left == previous) {  
				if (current.right != null) {
					current.print();
					S.push(current.right);
				} else {
					current.print();
					S.pop();
				}
			} 
			//no further node
			else
				S.pop();
			
			previous = current;
		}//end of while
		
		System.out.println();
	}
	
	//postorder
	
	public static void postorder(TreeNode root) {
		if (root == null)
			return;
		
		Stack<TreeNode> S = new Stack<TreeNode>();
		S.push(root);
		
		TreeNode previous = null;
		
		while (!S.empty()) {
			//get the current node from the stack
			TreeNode current = S.peek();
			
			//going down the tree
			if (previous == null 
					|| previous.left == current
					|| previous.right ==current) {
				if (current.left != null)
					S.push(current.left);
				else if (current.right != null)
					S.push(current.right);
				else {
					current.print();
					S.pop();
				}
			}
			// left sub tree is traversed
			else if (current.left == previous) {
				if (current.right != null)
					S.push(current.right);
				else {
					current.print();
					S.pop();
				}
			}
			//both subtrees are processed
			else {
				current.print();
				S.pop();
			}
			
			previous = current;
		} //end of while
		
		System.out.println();
	}
	
	
	//Tester
	public static void main(String[] args) {
		String nodes = "1 2 4 # # 5 # # 3 6 # # 7 # #";
		TreeNode root = Tree.buildTree(nodes);
		
		//preorders
		Tree.preorder(root);
		IterativeTreeTraversalStacks.preorder(root);
		
		//inorders
		Tree.inorder(root);
		IterativeTreeTraversalStacks.inorder(root);
				
		//postorder
		Tree.postorder(root);
		IterativeTreeTraversalStacks.postorder(root);
	}

}
