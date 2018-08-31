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
 * 給定一棵樹，還有目標數，若其中有一條路徑符合目標數，則返回true，若都沒有
 * 則返回false
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        return helper(root, sum);
    }
    
    boolean helper(TreeNode root, int sum) {
        boolean hasPath = false;
        //若已經到子節點下方，表示此路徑無法再繼續下去了，則返回false
        if(root == null) {
            return false;
        }
        
        sum = sum - root.val;
        //若到子節點，sum為0，表示此條路徑加總符合sum，則返回ture
        if(sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        
        //歷遍左右子樹
        hasPath = hasPath || helper(root.left, sum);
        hasPath = hasPath || helper(root.right, sum);
        
        return hasPath;
    }
}