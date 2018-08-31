package src.LeetCode.Algorithms.Hard;

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
public class BinaryTreeMaximumPathSum {
/*
首先我们分析一下对于指定某个节点为根时，最大的路径和有可能是哪些情况：
第一种：左子树的路径加上当前节点
第二种：右子树的路径加上当前节点
第三种：左右子树的路径加上当前节点（相当于一条横跨当前节点的路径）
第四种：只有自己的路径。
乍一看似乎以此为条件进行自下而上递归就行了，然而这四种情况只是用来计算以当前节点根的最大
路径，如果当前节点上面还有节点，那它的父节点是不能累加第三种情况的。所以我们要计算两个最
大值，一个是当前节点下最大路径和，另一个是如果要连接父节点时最大的路径和。我们用前者更新
全局最大量，用后者返回递归值就行了。
*/
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumDFS(root);
        return max;
    }
    
    int maxPathSumDFS(TreeNode root) {
       if(root == null)
           return 0;
        
        int left = maxPathSumDFS(root.left);
        int right = maxPathSumDFS(root.right);
        
        //連接父節點的最大路徑是1,2,4這三種情況的最大值
        int curSum = Math.max(Math.max(left + root.val, right + root.val), root.val);
        
        //當前節點的最大路徑是1,2,3,4這四種情況的最大值
        int curMax = Math.max(curSum, left + root.val + right);
        
        //用當前最大來更新全局最大
        max = Math.max(curMax, max);
        
        return curSum;
    }
}