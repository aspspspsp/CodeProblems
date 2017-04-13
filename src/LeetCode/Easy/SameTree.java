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
        //���~�ӹ��c���ttrue
        if(p == null && q == null)
            return true;
        
        //���У��қ]�У��˘䲻��ͬ
        if(p == null && q != null)
            return false;
        //��]�У����У��˘䲻��ͬ    
        if(p != null && q == null)
            return false;
        
        //��߅�Ĺ��cֵ��һ�ӣ��˘䲻��ͬ
        if(p.val != q.val)
            return false;
        
        //�v����߅
        boolean isRightSame = isSameTree(p.right, q.right);
        if(isRightSame == false)
            return false;
        
        //�v����߅
        boolean isLeftSame = isSameTree(p.left, q.left);
        if(isLeftSame == false)
            return false;
        
        //̎��ֻ��һ��ֵ�ĕr��
        return true;
    }
}