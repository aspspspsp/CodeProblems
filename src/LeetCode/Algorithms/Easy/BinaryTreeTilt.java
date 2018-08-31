package src.LeetCode.Algorithms.Easy;

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
public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;
        
        List<Integer> tilts = new ArrayList<>();
        helper(root, tilts);
        
        int result = 0;
        for(int i = 0; i < tilts.size(); i ++) {
            result += tilts.get(i);
        }
        
        return result;
    }
    
    int helper(TreeNode root, List<Integer> tilts) {
        if(root == null)
            return 0;
        
        //若為葉子節點，則返回自己的值
        if(root.left == null && root.right == null)
            return root.val;
        
        //遞歸求出左子樹的總值
        int left = 0;
        if(root.left != null)
            left += helper(root.left, tilts);
        
        //遞歸求出右子樹的總值
        int right = 0;
        if(root.right != null)
            right += helper(root.right, tilts);
        
        //求出tilt
        int tilt = Math.abs(left - right);
        tilts.add(tilt);
        
        //對此子樹求出總和
        int curSum = left + right + root.val;
        
        return curSum;
    }
}