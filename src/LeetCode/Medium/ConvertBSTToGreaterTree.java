package src.LeetCode.Medium;

import java.util.Stack;

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
public class ConvertBSTToGreaterTree {
    /*
    觀察答案，是中序歷遍，然後利用stack的方式疊加答案
    */
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public TreeNode convertBST(TreeNode root) {
        midFirstForeach(root);
        
        int i = 0;
        int sum = 0;
        //放入答案
        while(stack.isEmpty() == false) {
            TreeNode cur = stack.pop();
            if(i == 0) {
                sum = cur.val;
            } else {
                int tmp = cur.val;
                cur.val = sum + cur.val;
                sum = sum + tmp;
            }
            i ++;
        }
        return root;
    }
    
    //中序歷遍
    void midFirstForeach(TreeNode root) {
        if(root == null)
            return;
        midFirstForeach(root.left);
        stack.push(root);
        midFirstForeach(root.right);
    }
}