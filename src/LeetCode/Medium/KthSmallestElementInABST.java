package LeetCode.Medium;

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
 * 利用中序歷遍即可得到第k小的元素，經過k次歷遍過程，返回答案即可
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
                // 歷遍到k次時，得到第k小的元素
                if(k == 0)
                    return temp.val;
                cur = temp.right;
            }
        }

        // 沒有解答的情況
        return -1;
    }
}