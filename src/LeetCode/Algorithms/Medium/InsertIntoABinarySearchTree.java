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

    // 遵循BST左小右大的規則進行節點的插入
    void visit(TreeNode root, int val) {

        if(val < root.val) {
            // 若左節點不為空，則繼續左子樹的歷遍
            if(root.left != null)
                visit(root.left, val);
                // 插入左節點
            else
                root.left = new TreeNode(val);
        } else {
            // 若右節點不為空，則繼續右子樹的歷遍
            if(root.right != null)
                visit(root.right, val);
                // 插入右節點
            else
                root.right = new TreeNode(val);
        }
    }
}
