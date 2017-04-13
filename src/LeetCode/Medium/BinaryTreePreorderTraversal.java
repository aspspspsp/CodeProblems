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
 * The key is using a stack to store left and right children, and push right child first so that it is processed after the left child.
 * �@�}������ǰ���vһ�wtree
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        //�Y��list
        List<Integer> ans = new ArrayList<Integer>();
        
        //��root��null��ʾһ�_ʼ���
        if(root == null)
            return ans;
        
        //����һ��stack��ŕ���Y��(��)
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        //��root����stack��ʾroot���L��
        stack.push(root);
        
        while(stack.empty() == false) {
            //��Ŀǰ���v�Ĺ��c�ų�
            TreeNode node = stack.pop();
            
            //��Ŀǰ���v�Ĺ��c����Y��lost��(��)
            ans.add(node.val);
            
            //���ҹ��c����stack(�ҹ��c���L��)
            if(node.right != null) {
                stack.push(node.right);
            }
            
            //���ҹ��c����stack(���c���L��)
            if(node.left != null) {
                stack.push(node.left);
            }
            
        }
        
        //���ش�
        return ans;
    }
}