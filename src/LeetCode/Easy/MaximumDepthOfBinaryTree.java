package LeetCode.Easy;

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
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
            
        return findMaxDepth(root, 1);
    }
    
    public int findMaxDepth(TreeNode root, int depth) {
        //����߅�c��߅ͬ�r��գ���ʾ���~�ӹ��c������ֱ�ӷ��خ�ǰ���
        if(root.left == null && root.right == null)
            return depth;
            
        int leftDepth = 0;
        int rightDepth = 0;
        //���L���Ә�
        if(root.left != null)
            leftDepth = findMaxDepth(root.left, depth + 1);
        
        //���L���Ә�
        if(root.right != null)
            rightDepth = findMaxDepth(root.right, depth + 1);
            
        return Math.max(leftDepth, rightDepth);
    }
}