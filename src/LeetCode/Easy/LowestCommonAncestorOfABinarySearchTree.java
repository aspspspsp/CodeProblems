package src.LeetCode.Easy;

import src.LeetCode.Dependencies.TreeNode;

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
һ���и��䣬���σ��c�Ĺ�ͬ���Ȯ��У��x�����h������������һ����ͬ���ȣ�
�Q������͹�ͬ���ȡ��������Q�� LCA ��
�ȴ���򵥵Ķ���������BST���𣬸���һ�� BST���£�
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
��������2��8��LCA����ôΪ6���򵥼�ΪLCA(2,8) = 6

�������ӣ�
LCA(2,4) = 2
LCA(0,5) = 2

�ܼ򵥵�˼·���ǿ�����ֵ��root���ıߣ�
����ֵ������ߣ���LCA�����
����ֵ�����ұߣ���LCA���ұ�
һ������һ�����ң���˵��LCA���ǵ�ǰ��root�ڵ㡣
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