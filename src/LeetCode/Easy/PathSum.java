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
 * ���}������Cĳһ��������Ƿ���һ�l·���ļӿ��Ϻ�Ҫ��
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return pathSum(root, 0, sum);
    }
    
    boolean pathSum(TreeNode root, int curSum, int sum) {
        //��ʾ�˹��c��oЧ���c���ӿ�����^��������sum
        if(root == null)
            return false;
        
        curSum = curSum + root.val;
        //�������~���c���t�z��sum�Ƿ���A���ֵ
        if(root.left == null && root.right == null) {
            return curSum == sum;
        } else {
            //�����������c�t�^�m��ԓ���c�����ҹ��c�M�а��L
            //�������Ә�ļӿ�����һ���Ϻ�Ҫ�󣬴��������Ә���ǺϷ��ģ�����OR
            return pathSum(root.left, curSum, sum) || pathSum(root.right, curSum, sum);
        }
    }
}