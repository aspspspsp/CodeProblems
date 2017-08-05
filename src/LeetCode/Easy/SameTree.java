package LeetCode.Easy;

import LeetCode.Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //到最末節點的下面，則返回true
        if(p == null && q == null)
            return true;
        
        //左有，右沒有，此樹不相同
        if(p == null && q != null)
            return false;
        //左沒有，右有，此樹不相同
        if(p != null && q == null)
            return false;
        
        //兩邊的節點值不一樣，此樹不相同
        if(p.val != q.val)
            return false;
        
        //歷遍右邊子樹
        boolean isRightSame = isSameTree(p.right, q.right);
        if(isRightSame == false)
            return false;
        
        //歷遍左邊子樹
        boolean isLeftSame = isSameTree(p.left, q.left);
        if(isLeftSame == false)
            return false;
        
        //若都經過以上的關卡都沒有返回false，這表示兩棵樹都是一樣的
        return true;
    }
}