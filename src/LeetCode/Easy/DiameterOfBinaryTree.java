package LeetCode.Easy;

import LeetCode.Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return global_max_path;
    }
    
    int global_max_path = 0;
    int helper(TreeNode root) {
        if(root == null)
            return 0;
        
        //取得左右子樹的最大深度
        int left = helper(root.left);
        int right = helper(root.right);
        
        //left + right 為左右路徑相加(最常路徑)
        int cur_max_path = left + right;
        global_max_path = Math.max(global_max_path, cur_max_path);
        
        //取得當前最大深度
        int cur_max_depth = Math.max(left, right) + 1;
        
        return cur_max_depth;
    }
}