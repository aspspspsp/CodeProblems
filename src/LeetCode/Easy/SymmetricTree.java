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
        //��left�ѽ��]��ֵ��right�]��ֵ���R���
        //��left�ѽ��]��ֵ��right��ֵ�Ͳ����R���
        if(left == null) {
            if(right == null)
                return true;
            else
                return false;
        }
        
        //��left�ѽ���ֵ��right�]��ֵ,�@Ȼ�˘䲻���R���
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
        
        
        //�z����һ�ӵ���һ�ӵ������c�����Ƿ�һ�� ex:3,3
        boolean cond1 = isSymmetric(left.left, right.right);
        //�z����һ�ӵ���һ�ӵĵڶ����c�ڶ����Ƿ�һ�� ex:4,4 
        boolean cond2 = isSymmetric(left.right, right.left);
        
        return cond1 & cond2;
    }
}