package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

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
public class BinaryTreeInorderTraversal_Recursive  {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        
        helper(root, result);
        
        return result;
    }
    
    void helper(TreeNode root, List<Integer> result) {
    	//�Y���l��
        if(root == null)
            return;
        
        //�v�����Ә�
        helper(root.left, result);
        //�L�������c
        result.add(root.val);
        //�v�����Ә�
        helper(root.right, result);
    }
}