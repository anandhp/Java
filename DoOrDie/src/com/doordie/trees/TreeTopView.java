package com.doordie.trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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
 * Top view: 4, 2, 1, 3, 7
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
 * Top view: 6, 3, 2, 1, 9, 8
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
 * Top view: 4, 2, 1, 3, 7, 11
 */

public class TreeTopView {
	
	public class QNode {
		public int distance;
		public TreeNode node;
		
		public QNode(int distance, TreeNode node) {
			this.distance = distance;
			this.node = node;
		}
	}
	
	//applied level order traversal for getting distance
	//used sorted map for holding data
	public void topView(TreeNode root) {
		
		if (root == null)
			return;

		Map<Integer, Integer> view = new TreeMap<Integer, Integer>();

		Queue<QNode> nodes = new LinkedList<QNode>();
		nodes.add(new QNode(0, root));
		
		while (!nodes.isEmpty()) {
			QNode qNode = nodes.remove();
			TreeNode tNode = qNode.node;
			
			if (!view.containsKey(qNode.distance))
				view.put(qNode.distance, tNode.value);
			
			if (tNode.left != null)
				nodes.add(new QNode(qNode.distance - 1, tNode.left));
			
			if (tNode.right != null)
				nodes.add(new QNode(qNode.distance + 1, tNode.right));
		}
		
		System.out.println(view.values());
	}
	
	public static void main(String[] args) {
		String [] tests = {
				 			"1 2 4 # # 5 # # 3 6 # # 7 # #",
							"1 2 3 6 # # # 4 # 7 # 8 # # 9 # #",
							"1 2 4 # 14 16 # # 15 # # 5 8 # # # 3 6 9 # # # 7 10 # # 11 12 13 # # # #"
						  };
		
		for (String test : tests) {
			TreeNode root = Tree.buildTree(test);
			new TreeTopView().topView(root);
		}
		
	}

}
