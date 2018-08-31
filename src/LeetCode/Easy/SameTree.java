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
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	return helper(p, q);
    }
    
    boolean helper(TreeNode p, TreeNode q) {
    	//到最末節點的下面，則返回true
        if(p == null && q == null)
            return true;
        
        // 左沒有，右有，此樹不相同             左有，右沒有，此樹不相同
        if((p == null && q != null) || (p != null && q == null))
            return false;
        
        //兩邊的節點值不一樣，此樹不相同
        if(p.val != q.val)
            return false;
        
        boolean isSame = true;
        
        //歷遍左邊子樹
        isSame &= helper(p.left, q.left);
        //歷遍右邊子樹
        isSame &= helper(p.right, q.right);
        
        return isSame;
    }
}