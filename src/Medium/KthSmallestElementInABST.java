package Medium;

import java.util.Stack;

import Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 進行中序歷遍，到第k個時就是到第k小的數
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.pop();
                k --;
                //到第k小的時候
                if(k == 0)
                    return temp.val;
                cur = temp.right;
            }
        }
        //沒有找到結果
        return -1;
    }
}