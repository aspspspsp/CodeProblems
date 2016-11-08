package Easy;

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
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
            
        return findMaxDepth(root, 1);
    }
    
    public int findMaxDepth(TreeNode root, int depth) {
        //若左邊與右邊同時為空，表示為葉子節點，可以直接返回當前深度
        if(root.left == null && root.right == null)
            return depth;
            
        int leftDepth = 0;
        int rightDepth = 0;
        //拜訪左子樹
        if(root.left != null)
            leftDepth = findMaxDepth(root.left, depth + 1);
        
        //拜訪右子樹
        if(root.right != null)
            rightDepth = findMaxDepth(root.right, depth + 1);
            
        return Math.max(leftDepth, rightDepth);
    }
}