package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Collections;
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
public class BinaryTreeLevelOrderTraversalII {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)
            return result;
            
        //歷遍這棵樹
        TraversalTree(root, 0);
        
        //將結果倒反
        Collections.reverse(result);
        
        return result;
    }
    
    void TraversalTree(TreeNode root, int level) {
        if(root == null)
            return;
        
        if(result.size() == level) {
            result.add(new ArrayList<Integer>());
        }
        
        result.get(level).add(root.val);
            
        if(root.left != null)
            TraversalTree(root.left, level + 1);
            
        if(root.right != null)
            TraversalTree(root.right, level + 1);
    }
}