package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        // �츭�`�I�U���h���������(��ܳo�Ӥl��w�g���M����)
        if(root == null)
            return root;

        // �c�y��(�ѩ��V�W�c�y��)
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // �T�ر��p��^(�ѩ��V�W�c�y��)
        if(root.val == 1)
            return root;
        if(root.left != null)
            return root;
        if(root.right != null)
            return root;

        // ��L���p�ŪK
        return null;
    }
}
