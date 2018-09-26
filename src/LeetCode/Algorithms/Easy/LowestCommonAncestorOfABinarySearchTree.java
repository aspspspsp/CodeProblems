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
 /*
 Lowest Common Ancestor
一棵有根樹，樹上兩點的共同祖先當中，離根最遠、深度最深的那一個共同祖先，稱作「最低共同祖先」，常簡稱為 LCA 。
下面有一棵二叉樹:
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
從上面的二叉樹我們可以舉下面例子:
節點2與4的LCA為:2
LCA(2,4) = 2


節點0與5的LCA為:2
LCA(0,5) = 2

因為這題有假設p與q都有於此樹出現的情況，所以才可以使用這種做法，不然可能只會返回p或q
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 至尾節點或是歷遍到要尋找的節點時，則返回
        if(root == null || root == p || root == q) {
            return root;
        }
        
        // 取得左子樹與右子樹的結果
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // 找到LCA的情況(左子樹、右子樹都不為空)
        if(left != null && right != null)
            return root;

        // 只找到左邊的子樹的情況，只返回左邊
        if(left != null)
            return left;

        // 只找到右邊的子樹的情況，只返回右邊
        if(right != null)
            return right;

        // 其他情況則返回null
        return null;
    }
}