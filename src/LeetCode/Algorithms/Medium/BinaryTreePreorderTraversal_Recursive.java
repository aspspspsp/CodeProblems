package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.List;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 中左右(遞歸版)
 */
public class BinaryTreePreorderTraversal_Recursive {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        
        helper(root, result);
   
        return result;
    }
    
    void helper(TreeNode root, List<Integer> result) {
    	//若此節點沒有值則返回
        if(root == null)
            return;
        
        //將此節點放入結果當中
        result.add(root.val);
        
        //進行左子樹的歷遍
        if(root.left != null)
            helper(root.left, result);
        
        //進行右子樹的歷遍
        if(root.right != null)
            helper(root.right, result);
    }
}