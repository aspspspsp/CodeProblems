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
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null)
            return true;
            
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        //若left已經沒有值且right沒有值是鏡像樹
        //若left已經沒有值且right有值就不是鏡像樹
        if(left == null) {
            if(right == null)
                return true;
            else
                return false;
        }
        
        //若left已經有值而right沒有值,顯然此樹不是鏡像樹
        if(right == null)
            return false;
            
        if (left.val != right.val) {
            return false;
        }
        
        /*
    1
   / \
  2   2
 / \ / \
3  4 4  3
        */
        
        
        //檢查下一層的下一層的最左與最右是否一樣 ex:3,3
        boolean cond1 = isSymmetric(left.left, right.right);
        //檢查下一層的下一層的第二左與第二右是否一樣 ex:4,4 
        boolean cond2 = isSymmetric(left.right, right.left);
        
        return cond1 & cond2;
    }
}