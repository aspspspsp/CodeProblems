package src.LeetCode.Medium;

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
 * 左中右(迭代版)
 */
public class BinaryTreeInorderTraversal {
	/*
	 * 1.將首節點加入stack中
	 * =====(直到stack為空)========
	 * 2.if 當前節點不為空(還沒拜訪到當前子樹的最左節點)
	 *      2.1將root.left放入stack
	 *      2.2將root指定為root.left
	 *   else(繼續拜訪右子樹)
	 *   	2.1將root指定為stack排出的節點
	 *      2.2將root的值加入結果
	 *      2.3將root的值指定為root.right
	 * =====(stack為空後)==========
	 * 3.將結果的最後一個值(多出的)刪除
	 * 4.輸出結果
	ex:
	   4          stack     result
	  / \   =============================
	 2   5  step0  4        null
	/ \     step1  4,4      null
   1   3    step2  4,4,2    null
            step3  4,4,2,1  null
            step4  4,4,2    1
            step5  4,4,3    1,2
            step6  4,5      1,2,3
            step7  4        1,2,3,4
            step8  null     1,2,3,4,5,4
            step9  null     1,2,3,4,5
	 */
      public List<Integer> inorderTraversal(TreeNode root) {
    	//用來存儲結果
        List<Integer> result = new ArrayList<>();
        
        //對於root == null的情況
        if(root == null)
            return result;
        
        //利用stack來進行樹的歷遍
        Stack<TreeNode> stack = new Stack<>();
        
        //一定要將第一個節點放入stack中
        stack.push(root);
        
        while(stack.isEmpty() == false) {
        	//若root不為空的情況(還沒拜訪到當前子樹的最左節點)
            if(root != null) {
                stack.push(root);
                root = root.left;
          
            //若root為空的情況(繼續拜訪右子樹)
            } else if(root == null){
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        
        //將結果的最後一個值(多出的)刪除
        result.remove(result.size() - 1);

        return result;
    }
}