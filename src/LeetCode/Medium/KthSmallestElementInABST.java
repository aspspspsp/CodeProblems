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
 * �M������v�飬����k���r���ǵ���kС�Ĕ�
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
                //����kС�ĕr��
                if(k == 0)
                    return temp.val;
                cur = temp.right;
            }
        }
        //�]���ҵ��Y��
        return -1;
    }
}