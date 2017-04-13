package LeetCode.Medium;

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
 
 /*
  ��������⣬�ɸ��ڵ���Ҷ�ڵ㷽���ߣ����ǴӸ�λ����λ�Ӻ͵ķ���
  Ҳ����˵���������Ľڵ���Ҷ�ڵ㷽����һ���ʱ�򣬸ýڵ��ֵӦΪ:
    ���ڵ��ֵ*10+��ǰ�ڵ��ֵ��

 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        return dfs(root, 0, 0);
    }
    
    int dfs(TreeNode root, int num, int sum) {
        //avoiding situation of skewed tree caused error
        if(root == null) {
            return sum;
        }
        
        //temp path sum
        num = num * 10 + root.val;
        
        //left node
        if(root.right == null && root.left == null) {
            sum += num;
            return num;
        }
        
        // sum = left tree + right tree
        sum = dfs(root.left, num, sum) + dfs(root.right, num, sum);
        
        return sum;
    }
}