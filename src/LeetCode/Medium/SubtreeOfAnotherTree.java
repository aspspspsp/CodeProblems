package src.LeetCode.Medium;

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
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null)
            return true;
        
        if(s == null)
            return false;

        if(isSameTree(s, t) == true)
            return true;
        
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        
        if(s == null || t == null)
            return false;
        
        if(s.val != t.val)
            return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}