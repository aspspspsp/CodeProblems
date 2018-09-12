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
 *
 * BST的範圍是root比左節點大，而比右節點小，所以我們依照這個特性，來檢驗BST，
 * 再往各個節點下去檢驗，若整個BST都是合格的，那整棵樹都是合格的，若其中一個
 * 子樹不合格，則整個子樹不合格
 * 比較規則為: 左子樹的範圍(當前min~root)
 *            右子樹的範圍(root~當前max)
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
            
        boolean _isValid = isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return _isValid;
    }

    // min當前子樹值的最小範圍
    // max當前子樹值的最大範圍
    boolean isValid(TreeNode root, long min, long max) {
        //已經此分支歷遍完了
        if(root == null)
            return true;

        //若此節點不符合BST規則(超過當前BST子樹的範圍)，則返回false
        if(root.val <= min || root.val >= max)
            return false;

        //拜訪左子樹，ex:
        //    2　　　　*<-下一個(左子樹)node，要比2(root)小
        //   / \
        //  *   3
        //當前的左子樹範圍為:當前min~root，超過範圍則為非法(更新max為當前root)
        boolean isValidLeft = isValid(root.left, min, root.val);
        //拜訪右子樹，ex:
        //    2       *<-下一個(右子樹)node，要比2(root)大
        //   / \
        //  1   *
        //當前的右子樹範圍為:root~當前max，超過範圍則為非法(更新min為當前root)
        boolean isValidRight = isValid(root.right, root.val, max);

        //若左右子樹驗證都對才能算一個真正的BST
        boolean _isValid = isValidLeft && isValidRight;
        return _isValid;
    }
}
