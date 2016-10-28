package Easy;

import Dependencies.TreeNode;

/**
 * 不是很难，思路大家可能都会想到用递归，分别判断左右两棵子树是不是平衡二叉树，如果都是并且左右两颗子树的高度相差不超过1，那么这棵树就是平衡二叉树。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        //若root節點為空(null節點也是平衡樹)
        /*
        null
        */
        if(root == null) {
            return true;
        }
        
        //若root節點下面沒有結點(單一節點也是平衡樹)
        /*
        1
        */
        if(root.left == null && root.right == null) {
            return true;    
        }
        
        //若左右子樹的深度差超過1，表示此樹不為平衡樹
        if(Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        
        //進行下一層的檢查(是否為平衡樹)，左右子樹一起檢查，若左右子樹所有節點的深度都一樣表示是一顆平衡樹
        return (isBalanced(root.left) && isBalanced(root.right));
    }
    
    //計算TreeNode的深度(最大)
    int depth(TreeNode root) {
        //若root為null表示為0層
        if(root == null)
            return 0;
        
        //從左右選一個最大深度，+1表示當前這一層
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}