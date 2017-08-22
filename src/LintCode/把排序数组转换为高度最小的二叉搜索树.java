package LintCode;

import LeetCode.Dependencies.TreeNode;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class 把排序数组转换为高度最小的二叉搜索树 {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if(A == null || A.length == 0)
            return null;
        
        TreeNode root = helper(0, A.length - 1, A);
        return root;
    }
    
    TreeNode helper(int l, int r, int[] A) {
        if(l > r)
            return null;
        if(l < 0)
            return null;
        if(r >= A.length)
            return null;
        
        //中位數的index
        int median = (l + r) / 2;
        
        //目前節點
        TreeNode cur = new TreeNode(A[median]);
        
        //左右子樹遞歸的做下去
        TreeNode left = helper(l, median - 1, A);
        TreeNode right = helper(median + 1, r, A);
        
        if(left != null)
            cur.left = left;
        if(right != null)
            cur.right = right;
        
        return cur;
    }
}