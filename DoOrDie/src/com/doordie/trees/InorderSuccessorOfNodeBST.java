package com.doordie.trees;

/**
 *	Find inorder successor of a node in BST
 *         4
 *       /   \
 *      2     6
 *     / \   / \
 *    1   3 5   9
 *             / \
 *            8   11
 *            
 *   Inorder successor of 1 is 2
 *   Inorder successor of 5 is 6
 *   Inorder successor of 2 is 3
 *   Inorder successor of 7 is null - no node with given value
 *   Inorder successor of 11 is null
 *
 */

public class InorderSuccessorOfNodeBST {
	
	//Find minimum value of given subtree
	private static TreeNode findMinimum(TreeNode root) {
		while (root != null && root.left != null)
			root = root.left;
		
		return root;
	}

	//Inorder successor
	public static TreeNode inorderSuccessor(TreeNode root, int target) {
		
		TreeNode successor = null;
		
		while (root != null) {
			if (root.value > target) {
				successor = root.isLeaf() ? null : root;
				root = root.left;
			} else if (root.value < target) {
				root = root.right;
			} else {
				TreeNode node = findMinimum(root.right);
				if (node != null)
					successor = node;
				break;
			}
		}
		
		return successor;
	}

	//main tester
	public static void main(String[] args) {
		String nodes = "4 2 1 # # 3 # # 6 5 # # 9 8 # # 11 # #";
		TreeNode root = Tree.buildTree(nodes);

		Tree.inorder(root);
		
		for (int i = 1; i < 12; i++) {
			TreeNode node = InorderSuccessorOfNodeBST.inorderSuccessor(root, i);
			if (node == null)
				System.out.println("\nInorder successor of " + i + " is null");
			else
				System.out.println("\nInorder successor of " + i + " is " + node.value);
		}
	}

}
