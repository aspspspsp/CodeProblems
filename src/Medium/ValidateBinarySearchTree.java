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
 * 
 * 可以利用它本身的性质来做，即左<根<右，也可以通过利用中序遍历结果为有序数列来做，
 * 下面我们先来看最简单的一种，就是利用其本身性质来做，初始化时带入系统最大值和最小
 * 值，在递归过程中换成它们自己的节点值，用long代替int就是为了包括int的边界条件，
 * 代码如下：
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
            
        boolean _isValid = isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return _isValid;
    }
    
    // min最小範圍
    // max最大範圍
    boolean isValid(TreeNode root, long min, long max) {
        //已經此分支歷遍完了
        if(root == null)
            return true;
        
        //若此節點不符合2插樹規則，則返回false    
        if(root.val <= min || root.val >= max)
            return false;
        
        //拜訪左子樹，ex:
        //    2
        //   / \
        //  *   3
        //歷遍左子樹時，更新邊界條件(最大邊界)，邊界值即為目前的值
        boolean isValidLeft = isValid(root.left, min, root.val);
        //拜訪右子樹，ex:
        //    2      *<-下一個root，要比2(目前)大
        //   / \
        //  1   *
        //歷遍右子樹時，更新邊界條件(最小邊界)，邊界值即為目前的值
        boolean isValidRight = isValid(root.right, root.val, max);
        
        //若左右子樹驗證都對才能算一個真正的BST
        boolean _isValid = isValidLeft && isValidRight;
        return _isValid;
    }
}
