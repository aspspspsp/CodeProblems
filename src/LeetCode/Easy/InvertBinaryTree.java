package LeetCode.Easy;

import LeetCode.Dependencies.TreeNode;

/*
 * ���D�����
 * 
 *     4
 *   /   \
.*  2     7
.* / \   / \
.*1   3 6   9
 * 
 *    to
 * 
 *     4
.*   /   \
.*  7     2
.* / \   / \
.*9   6 3   1
 * 
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        
        //�����Ø��null�t����null
        if(root == null)
            return null;
        
        //�M�Ю��ӵķ��D
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        
        //�����Ә䲻��Մt�M�����Ә�ķ��D
        if(root.right != null) {
            invertTree(root.right);
        }
        
        //�����Ә䲻��Մt�M�����Ә�ķ��D
        if(root.left != null) {
            invertTree(root.left);
        }
        
        //���ش�
        return root;
    }
}