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
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }
    
    TreeNode buildTree(int[] nums, int left, int right) {
        if(left == right)
            return null;
        
        //找到目前最大數的index
        int maxIndex = findMaxIndex(nums, left, right);
        
        TreeNode root = new TreeNode(nums[maxIndex]);
        
        //左子樹，區間為[left, maxIndex]
        root.left = buildTree(nums, left, maxIndex);
        
        //右子樹，區間為[maxIndex + 1, right]
        root.right = buildTree(nums, maxIndex + 1, right);
        
        return root;
    }
    
    //找到最大數的index
    int findMaxIndex(int[] nums, int left, int right) {
        int maxIndex = left;
        for(int i = left; i < right; i ++) {
            if(nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        
        return maxIndex;
    }
}