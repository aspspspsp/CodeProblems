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

//���}�c�Ҍ������Ȳ�ͬ����
//�����Ȟ� max = 0
//��С��Ȟ� min = Integer.max
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        
        //�z���Ƿ�һ�_ʼ�͞��
        if(root == null)
            return 0;
        
        //���Ҷ��]�к��ӱ�ʾ���~�ӹ��c����ʾ����׌ӣ���׌ӵ���Ȟ�1
        if(root.left == null && root.right == null)
            return 1;
            
        //Integer.MAX_VALUE ��һ��ӛ̖����ʾ�˹��c���
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;
        
        //�����Ǳ��⌦ƫб����F�e�`�Ĵ�ex:
        /*
            1           expect:2
           / \          wrong answer:1
         null 2
        */
        if(root.left != null) 
            minLeft = minDepth(root.left);
            
        if(root.right != null) 
            minRight = minDepth(root.right);
        
        //�����҃��Ә��ҵ���С�����
        return Math.min(minLeft, minRight) + 1;
    }
}