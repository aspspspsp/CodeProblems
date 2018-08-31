package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

/*
 * 將這個二叉樹進行左右翻轉，如:
 * 
 *     4
 *   /   \
.*  2     7
.* / \   / \
.*1   3 6   9
 * 
 *    to
 * 
 *     4
.*   /   \
.*  7     2
.* / \   / \
.*9   6 3   1
 * 
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        
    	//若整棵樹為null則返回null
        if(root == null)
            return null;
        
        //進行當層的翻轉
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        
        //若右子樹不為空則進行右子樹的翻轉
        if(root.right != null) {
            invertTree(root.right);
        }
        
        //左右子樹不為空則進行左子樹的翻轉
        if(root.left != null) {
            invertTree(root.left);
        }
        
        //返回答案
        return root;
    }
}