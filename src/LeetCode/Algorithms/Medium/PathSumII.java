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
 */
public class PathSumII {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return result;
        
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        
        dfs(root, sum - root.val, temp);
        
        return result;
    }
    
    void dfs(TreeNode root, int sum, List<Integer> temp) {
        if(root.left == null && root.right == null) {
            if(sum == 0) {
                List<Integer> subResult = new ArrayList<Integer>(temp);
                result.add(subResult);
            }
            return;
        }
        
        if(root.left != null) {
            temp.add(root.left.val);
            //注意sum不能影響到下一個狀態
            int nextSum = sum - root.left.val;
            dfs(root.left, nextSum, temp);
            
            //回復上一個狀態
            temp.remove(temp.size() - 1);
        }
        
        if(root.right != null) {
            temp.add(root.right.val);
            int nextSum = sum - root.right.val;
            dfs(root.right, nextSum, temp);
            
            //回復上一個狀態
            temp.remove(temp.size() - 1);
        }
        
    }
}