package src.LeetCode.Easy;

import src.LeetCode.Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return sum;
            
        count(root);
        
        return sum;
    }
    
    void count(TreeNode root) {
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null)
                sum = sum + root.left.val;
            count(root.left);
        }
        
        if(root.right != null) {
            count(root.right);
        }
        
    }
}