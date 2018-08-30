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
 
/*
分析这道题，由根节点往叶节点方向走，就是从高位往地位加和的方向。
也就是说，当遍历的节点往叶节点方向走一层的时候，该节点的值应为:
  父节点的值*10+当前节点的值。

*/
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        return dfs(root, 0, 0);
    }
    
    int dfs(TreeNode root, int num, int sum) {
        //avoiding situation of skewed tree caused error
        if(root == null) {
            return sum;
        }
        
        //temp path sum
        num = num * 10 + root.val;
        
        //left node
        if(root.right == null && root.left == null) {
            sum += num;
            return num;
        }
        
        // sum = left tree + right tree
        sum = dfs(root.left, num, sum) + dfs(root.right, num, sum);
        
        return sum;
    }
}