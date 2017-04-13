package LeetCode.Easy;

import LeetCode.Dependencies.TreeNode;

/**
 * ���Ǻ��ѣ�˼·��ҿ��ܶ����뵽�õݹ飬�ֱ��ж��������������ǲ���ƽ���������������ǲ����������������ĸ߶�������1����ô���������ƽ���������
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        //��root���c���(null���cҲ��ƽ���)
        /*
        null
        */
        if(root == null) {
            return true;
        }
        
        //��root���c����]�нY�c(��һ���cҲ��ƽ���)
        /*
        1
        */
        if(root.left == null && root.right == null) {
            return true;    
        }
        
        //�������Ә����Ȳ�^1����ʾ�˘䲻��ƽ���
        if(Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        
        //�M����һ�ӵęz��(�Ƿ��ƽ���)�������Ә�һ��z�飬�������Ә����й��c����ȶ�һ�ӱ�ʾ��һ�wƽ���
        return (isBalanced(root.left) && isBalanced(root.right));
    }
    
    //Ӌ��TreeNode�����(���)
    int depth(TreeNode root) {
        //��root��null��ʾ��0��
        if(root == null)
            return 0;
        
        //�������xһ�������ȣ�+1��ʾ��ǰ�@һ��
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}