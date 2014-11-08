package com.doordie.trees;

/**
 * Given a tree, get sum of tree nodes except leaves
 * 
 * For example 
 * 		
 *         1
 *       /   \
 *      2     3
 *     / \   / \
 *    4   5 6   7
 *   
 *    has diameter 5
 *    
 *    
 *    
 *        1
 *       / \
 *      2   2
 *     / \ 
 *    3   4 
 *   /     \
 *  6       7
 *           \
 *            8
 *            
 *  has diameter 6  
 *
 */

public class DiameterOfTree {

	//result
	private static Integer result = 0;

	public static int diameter(TreeNode root) {
		if (root == null)
			return 0;
		
		int left = diameter(root.left);
		int right = diameter(root.right);
		
		result = Math.max(result, left + right + 1);
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		String[] tests =  {
							"1 2 4 # # 5 # # 3 6 # # 7 # #",
							"1 2 3 6 # # # 4 # 7 # 8 # # 2 # #"
						  };

		for (String test : tests) {
			TreeNode root = Tree.buildTree(test);
			Tree.inorder(root);
	
			DiameterOfTree.diameter(root);
			System.out.println("\nDiameter "+ DiameterOfTree.result);
		}
	}
}
