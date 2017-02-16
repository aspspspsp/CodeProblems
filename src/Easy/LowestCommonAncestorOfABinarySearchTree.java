package Easy;

import Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 Lowest Common Ancestor
一棵有根樹，樹上兩點的共同祖先當中，離根最遠、深度最深的那一個共同祖先，
稱作「最低共同祖先」，常簡稱為 LCA 。
先从最简单的二叉搜索树BST讲起，给定一棵 BST如下：
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
比如如求2和8的LCA，那么为6，简单记为LCA(2,8) = 6

更多例子：
LCA(2,4) = 2
LCA(0,5) = 2

很简单的思路就是看两个值在root的哪边：
两个值都在左边，则LCA在左边
两个值都在右边，则LCA在右边
一个在左一个在右，则说明LCA就是当前的root节点。
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // Conquer
        if(left != null && right != null)
            return root;
        if(left != null)
            return left;
        if(right != null)
            return right;
        
        return null;
    }
}