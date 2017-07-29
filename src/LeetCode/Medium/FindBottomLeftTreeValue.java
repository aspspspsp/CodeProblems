package LeetCode.Medium;

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
public class FindBottomLeftTreeValue {
    int leftmost = 0; //紀錄最左的元素
    int maxDepth = 0; //紀錄最大深度
    public int findBottomLeftValue(TreeNode root) {
        if(root == null)
            return 0;
        
        //一定要記錄第一個，因為只有一個的情況
        leftmost = root.val;
        
        //開始拜訪
        helper(root, 0);
        return leftmost;
    }
    
    void helper(TreeNode root, int level) {
        if(root == null)
            return;
        
        //若達最大深度，則更新
        if(level > maxDepth) {
            leftmost = root.val;
            maxDepth = level;
        }
        
        if(root.left != null)
            helper(root.left, level + 1);
        
        if(root.right != null)
            helper(root.right, level + 1);
    }
}
