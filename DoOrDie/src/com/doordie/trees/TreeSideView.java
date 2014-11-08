package com.doordie.trees;
/**
 * 
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
 * Side view: 1, 2, 4
 *    
 *    
 *    
 *        1
 *       / \
 *      2   9
 *     / \ 
 *    3   4 
 *   /     \
 *  6       7
 *           \
 *            8
 *            
 * Side view: 1, 2, 3, 6, 8
 *
 *          1           
 *       /    \         
 *      2      3        
 *     / \    / \       
 *    4   5  6   7      
 *     \  / /   / \     
 *     14 8 9  10 11    
 *     / \        /      
 *    16  15     12      
 *              /        
 *             13        
 * 
 * Side view: 1, 2, 4, 14, 16, 13
 * 
 */

public class TreeSideView {

	private Integer maxHeight = 0;
	
	//prints left side view
	private void sideViewHelper(TreeNode root, int height) {
		if (root == null)
			return;

		if (height + 1 > maxHeight) {
			System.out.print(root.value + ", ");
			maxHeight = height + 1;
		}
		sideViewHelper(root.left, height + 1);
		sideViewHelper(root.right, height + 1);
	}
	
	public void sideView(TreeNode root) {
		sideViewHelper(root, 0);
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		String [] tests = {
				 			"1 2 4 # # 5 # # 3 6 # # 7 # #",
							"1 2 3 6 # # # 4 # 7 # 8 # # 9 # #",
							"1 2 4 # 14 16 # # 15 # # 5 8 # # # 3 6 9 # # # 7 10 # # 11 12 13 # # # #"
						  };
		for (String test : tests) {
			TreeNode root = Tree.buildTree(test);
			new TreeSideView().sideView(root);
		}
		
	}

}
