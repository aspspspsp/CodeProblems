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
 * 
 * �����:root
 * ������:lt
 * ������:rt
 * �����ӽ��:x
 * ��root��lt�е�x����root��rt�ӵ�x���������ϣ�x��������Ϊ�գ���root���������������Ϊ��������root�����������ա� 
 */
public class FlattenBinaryTreeToLinkedList {
    //�o���һ�����v������һ�����c
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        //̎��������r
        if(root == null) {
            return;
        }
        
        //������һ�����c����һ�����c(Ŀǰ���c)����������
        if(lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        
        //���^��һ�����E�ᣬ���^�m����һ��
        lastNode = root;
        
        //���ʹ�ô˷N�v�鷽ʽ���������գ���Ȼ�����e
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        //�����Ә���һ�ӵ�̎��
        flatten(left);
        
        //�����Ә���һ�ӵ�̎��
        flatten(right);
    }
}