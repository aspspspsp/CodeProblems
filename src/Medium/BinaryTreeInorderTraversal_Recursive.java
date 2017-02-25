package Medium;

import java.util.ArrayList;
import java.util.List;

import Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeInorderTraversal_Recursive  {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        
        helper(root, result);
        
        return result;
    }
    
    void helper(TreeNode root, List<Integer> result) {
    	//結束條件
        if(root == null)
            return;
        
        //歷遍左子樹
        helper(root.left, result);
        //訪問根節點
        result.add(root.val);
        //歷遍右子樹
        helper(root.right, result);
    }
}