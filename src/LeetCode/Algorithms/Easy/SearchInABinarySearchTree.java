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
        // 處理例外情況
        if(root == null)
            return root;

        // 處理葉節點且該節點為非目標數值的情況
        if(root.left == null && root.right == null)
            if(root.val != val)
                return null;

        // 處理找到目標數值的情況
        if(root.val == val)
            return root;

        // 尋找符合目標數值的節點的
        TreeNode result = null;

        // 搜尋左節點(BST左大右小，加快搜索速度)
        if(root.left != null && val <= root.val) {
            result = searchBST(root.left, val);
        }

        // 剪枝
        if(result != null)
            return result;

        // 搜尋右節點(BST左大右小，加快搜索速度)
        if(root.right != null && val >= root.val) {
            result = searchBST(root.right, val);
        }

        // 返回答案
        return result;
    }
}
