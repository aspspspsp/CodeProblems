package src.LeetCode.Medium;

import src.LeetCode.Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * �����������������������������<��<�ң�Ҳ����ͨ����������������Ϊ��������������
 * ����������������򵥵�һ�֣����������䱾��������������ʼ��ʱ����ϵͳ���ֵ����С
 * ֵ���ڵݹ�����л��������Լ��Ľڵ�ֵ����long����int����Ϊ�˰���int�ı߽�������
 * �������£�
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
            
        boolean _isValid = isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return _isValid;
    }
    
    // min��С����
    // max��󹠇�
    boolean isValid(TreeNode root, long min, long max) {
        //�ѽ��˷�֧�v������
        if(root == null)
            return true;
        
        //���˹��c������2���Ҏ�t���t����false    
        if(root.val <= min || root.val >= max)
            return false;
        
        //���L���Ә䣬ex:
        //    2
        //   / \
        //  *   3
        //�v�����Ә�r������߅��l��(���߅��)��߅��ֵ����Ŀǰ��ֵ
        boolean isValidLeft = isValid(root.left, min, root.val);
        //���L���Ә䣬ex:
        //    2      *<-��һ��root��Ҫ��2(Ŀǰ)��
        //   / \
        //  1   *
        //�v�����Ә�r������߅��l��(��С߅��)��߅��ֵ����Ŀǰ��ֵ
        boolean isValidRight = isValid(root.right, root.val, max);
        
        //�������Ә���C����������һ��������BST
        boolean _isValid = isValidLeft && isValidRight;
        return _isValid;
    }
}
