package LeetCode.Medium;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class BinaryTreePreorderTraversal {
	/*
	ex:
	   1          stack     result
	  / \   =========================
	 2   3  step0  1         null
	/ \     step1  3,2       1
   4   5    step2  3,5,4     1,2
            step3  3,5       1,2,4
            step4  3         1,2,4,5
            step5  null      1,2,4,5,3
	*/
    public List<Integer> preorderTraversal(TreeNode root) {
        //用來存儲結果
        List<Integer> result = new ArrayList<Integer>();
        
        //對於root == null的情況
        if(root == null)
            return result;
        
        //利用stack來進行樹的歷遍
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        //一定要將第一個節點放入stack中
        stack.push(root);
        
        while(stack.empty() == false) {
            //先推出stack最後一個加入的TreeNode
            root = stack.pop();
            
            //加入結果當中
            result.add(root.val);
            
            //將右節點放入stack中(因為先進後出，故右邊會比左邊慢被排出來)
            if(root.right != null) {
                stack.push(root.right);
            }
            
            //將左節點放入stack中(因為先進後出，故左邊會比右邊快被排出來)
            if(root.left != null) {
                stack.push(root.left);
            }
            
        }
        
        //返回答案
        return result;
    }
}