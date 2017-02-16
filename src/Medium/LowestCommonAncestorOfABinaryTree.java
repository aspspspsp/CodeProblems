package Medium;

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
public class LowestCommonAncestorOfABinaryTree {
    /*
    如果当前节点(root)为空返回null
    如果当前节点(root)与目标节点(p或q)之一相同，则返回当前节点
    递归寻找p和q在左右子树中的位置
    如果p和q分别位于root的左右两侧，则root为它们的LCA，否则为左子树或者右子树
    
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4

    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点(root)为空，返回null
        if(root == null)
            return null;
        
        // 如果当前节点(root)與目标节点之一相同，则返回当前节
        //(找到p與q則返回自己)
        if(root == p || root == q)
            return root;
    
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, p, q); //找左子樹
        TreeNode right = lowestCommonAncestor(root.right, p, q); //找右子樹
        
        // Conquer
        //左右子樹都非null表示此節點為lca(從左右子樹都找到p與q的時候)
        if(left != null && right != null)
            return root;
        
        //將左邊找到的p或q傳給上次遞歸
        if(left != null)
            return left;
        //將右邊找到的p或q傳給上次遞歸
        if(right != null)
            return right;
        
        //若此節點葉子且子節點非p或q，則返回null(忽略此節點)
        return null;
    }
}