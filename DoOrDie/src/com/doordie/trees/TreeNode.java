package com.doordie.trees;

/**
 * Class which represents tree node
 */
public class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public boolean isLeaf() {
		return left == null && right == null;
	}
	
	public String toString() {
		return Integer.toString(value);
	}
	
	public void print() {
		System.out.print(this.value + " ");
	}
}
