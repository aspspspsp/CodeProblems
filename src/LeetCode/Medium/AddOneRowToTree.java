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
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null)
            return root;
        
        if(d == 1) {
            /*處理特殊case，替換最上層的節點，就像下面的例子的過程:
              1           1
             / \    to   /
            2   3       1
                       / \
                      2   3
            */
            TreeNode orig = root;
            TreeNode new_left = new TreeNode(v);
            new_left.left = orig;
            return new_left;
        } else if(d > 0) {
            //一般case
            TreeNode rootNode = root;
            helper(root, v, d, 1); 
            return rootNode;
        } else {
            return null;
        }
    }
    
    void helper(TreeNode root, int v, int d, int level) {
        if(root == null)
            return;
        
        //當拜訪的節點是要置換的節點的上一層
        if(level == d - 1) {
            //將原本要替換的那一層的點暫存起來
            TreeNode left_orig = root.left;
            TreeNode right_orig = root.right;
            
            //新增將要替換的兩個點
            TreeNode left_new = new TreeNode(v);
            TreeNode right_new = new TreeNode(v);
            
            //進行替換過程
            root.left = left_new;
            root.right = right_new;
            
            left_new.left = left_orig;
            right_new.right = right_orig;
            
            //置換完就可以結束了(剪枝)
            return;
        }
        
        //繼續拜訪左右節點
        if(root.left != null)
            helper(root.left, v, d, level + 1);
        
        if(root.right != null)
            helper(root.right, v, d, level + 1);
    }
}