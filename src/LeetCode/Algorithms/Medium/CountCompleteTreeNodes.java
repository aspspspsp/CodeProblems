package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *     1       此題是要將左右子樹一樣的樹的數量記起來，然後在合併為一整棵樹的數量
 *    / \     
 *   2   3
 *  / \ 
 * 4   5
 * 
 * 
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
            
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        
        if(leftHeight == rightHeight) {
            //這裡要用位運算，不然過不了大數據集
            return (2 << (leftHeight - 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    public int getLeftHeight(TreeNode root) {
        if(root == null)
            return 0;
            
        int height = 1;    
        while(root.left != null) {
            root = root.left;
            height ++;
        }
        
        return height;
    }
    
    public int getRightHeight(TreeNode root) {
        if(root == null)
            return 0;
            
        int height = 1;    
        while(root.right != null) {
            root = root.right;
            height ++;
        }
        
        return height;
    }
}