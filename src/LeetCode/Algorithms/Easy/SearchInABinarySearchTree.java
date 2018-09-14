package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.TreeNode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        // �B�z�ҥ~���p
        if(root == null)
            return root;

        // �B�z���`�I�B�Ӹ`�I���D�ؼмƭȪ����p
        if(root.left == null && root.right == null)
            if(root.val != val)
                return null;

        // �B�z���ؼмƭȪ����p
        if(root.val == val)
            return root;

        // �M��ŦX�ؼмƭȪ��`�I��
        TreeNode result = null;

        // �j�M���`�I(BST���j�k�p�A�[�ַj���t��)
        if(root.left != null && val <= root.val) {
            result = searchBST(root.left, val);
        }

        // �ŪK
        if(result != null)
            return result;

        // �j�M�k�`�I(BST���j�k�p�A�[�ַj���t��)
        if(root.right != null && val >= root.val) {
            result = searchBST(root.right, val);
        }

        // ��^����
        return result;
    }
}
