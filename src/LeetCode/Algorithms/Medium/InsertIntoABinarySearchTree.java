package src.LeetCode.Algorithms.Medium;

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
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode head = root;
        visit(head, val);
        return root;
    }

    // ��`BST���p�k�j���W�h�i��`�I�����J
    void visit(TreeNode root, int val) {

        if(val < root.val) {
            // �Y���`�I�����šA�h�~�򥪤l�𪺾��M
            if(root.left != null)
                visit(root.left, val);
                // ���J���`�I
            else
                root.left = new TreeNode(val);
        } else {
            // �Y�k�`�I�����šA�h�~��k�l�𪺾��M
            if(root.right != null)
                visit(root.right, val);
                // ���J�k�`�I
            else
                root.right = new TreeNode(val);
        }
    }
}
