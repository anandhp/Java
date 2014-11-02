package com.doordie.trees;

public class MaxPathSum {

    private int sum = Integer.MIN_VALUE;
    
    public int maxPathSumEx(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        
        int left = maxPathSumEx(root.left);
        int right = maxPathSumEx(root.right);

        int current = Math.max(root.value, root.value + Math.max(left, right));
        sum = Math.max(sum, Math.max(current, root.value + left + right));

        System.out.println("L: " + left + " R: " + right + " V: " + root.value + " C: " + current + " S: "  + sum);
        return current;
    }
    
    public int maxPathSum(TreeNode root) {
        maxPathSumEx(root);
        return sum;    
    }
    
	public static void main(String[] args) {
		String nodes = "1 2 # # 3 # #";
		TreeNode root = Tree.buildTree(nodes);
		
		//preorders
		System.out.println(new MaxPathSum().maxPathSum(root));

	}

}
