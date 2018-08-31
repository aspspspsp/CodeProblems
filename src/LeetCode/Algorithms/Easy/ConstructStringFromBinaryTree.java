package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructStringFromBinaryTree {
    
    String result = "";
    public String tree2str(TreeNode t) {
        if(t == null)
            return "";
        
        //從根結點開始歷遍
        helper(t);
        
        //去除頭尾多的括號
        result = result.substring(1, result.length() - 1);
        
        return result;
    }
    
    void helper(TreeNode t) {
        //當沒有元素時直接返回
        if(t == null) {
            return;
        }
        
        //前面加前括號
        result += "(" + t.val;
        
        /*對於 case :
               1
             /   \
            2     3
             \  
              4 

        Output: "1(2()(4))(3)"
        */
        if(t.left == null && t.right != null) {
            result += "()";
        }
        
        //歷遍左與右
        helper(t.left);
        helper(t.right);

        //前面加後括號
        result += ")";
    }
}