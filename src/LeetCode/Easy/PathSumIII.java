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
 
 /*
 ����Ĳ�ͬ����path���Բ���root��ʼ������leaf�����������ڿ��Դ��ڸ����ڵ㣬����û��ͨ���Ƚϴ�С�������ڵ㣬
 �������Ǿ�ֻ�ܿ��Ǵ�ÿһ���ڵ㿪ʼ�������
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        
        //���Ҫ���]ÿ��·��(��һ����root�_ʼ)��
        //��Ҫ���������3���c�քe�M�а��L
        int pathCount = visitPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return pathCount;
    }
    
    public int visitPath(TreeNode root, int sum) 
    {
        if(root == null)
            return 0;
        
        int pathCount = 0;
        if(root.val == sum)
            pathCount ++;
        
        //Ŀǰ·���� = ���Ә�·���� + ���Ә�·����
        pathCount = pathCount + visitPath(root.left, sum - root.val) + visitPath(root.right, sum - root.val);
        return pathCount;
    }
}