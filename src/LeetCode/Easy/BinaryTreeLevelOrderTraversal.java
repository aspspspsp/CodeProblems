package LeetCode.Easy;

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
public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return result;
        
        //開始進行歷遍
        traversal(0, root);
        
        return result;
    }
    
    public void traversal(int level, TreeNode root) {
        //若當前拜訪的層數在結果中沒有的話就添加
        if(level >= result.size()) {
            result.add(new ArrayList<Integer>());
        }
        
        //依照目前拜訪節點所在的層數添加至結果(結果是按層數來分)
        result.get(level).add(root.val);
        
        //拜訪左子樹
        if(root.left != null)
            traversal(level + 1, root.left);
        
        //拜訪右子樹
        if(root.right != null)
            traversal(level + 1, root.right);
    }
}