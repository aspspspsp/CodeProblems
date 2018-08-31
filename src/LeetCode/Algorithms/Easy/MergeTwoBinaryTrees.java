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
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {        
        return helper(t1, t2);
    }
    
    //把t2合併到t1上面
    TreeNode helper(TreeNode t1, TreeNode t2) {
        //若t1對應到t2的地方沒有值，則是t2節點
        if(t1 == null)
            return t2;
        
        //若t2對應到t1的地方沒有值，則是t1節點
        if(t2 == null)
            return t1;
        
        //若都有值，則是t1與t2的值兩個加起來
        t1.val = t1.val + t2.val;
        
        //左右節點到右歷遍
        t1.left = helper(t1.left, t2.left);
        t1.right = helper(t1.right, t2.right);
        
        return t1;
    }
}