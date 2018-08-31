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
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)
            return root;
        
        return helper(root, L, R);
    }
    
    TreeNode helper(TreeNode root, int L, int R) {
        if(root == null)
            return root;
        
        /*
          4                       2
         / \       R = 3   ->      \ 
        2   3                       3
        */
        if(root.val > R) {
            return helper(root.left, L, R);
        
        /*
          1                       3
         / \       L = 2   ->    / 
        2   3                   2  
        */
        } else if(root.val < L) {
            return helper(root.right, L, R);
        
        //若不需要進行替換，則繼續做下去
        } else {
            root.left = helper(root.left, L, R);
            root.right = helper(root.right, L, R);
            
            return root;
        }
    }
}