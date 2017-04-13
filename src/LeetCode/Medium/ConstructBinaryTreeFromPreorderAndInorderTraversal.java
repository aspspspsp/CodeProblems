package LeetCode.Medium;

import java.util.HashMap;

import LeetCode.Dependencies.TreeNode;

/**
 * ��Ŀ���⣺���ڸ�����һ�ö�������ǰ������������������ԭ��ö�����
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
preorder				inorder
       1                 4
      / \               / \
     2   5             2   6
    / \ / \           / \ / \
   3  4 6  7         1  3 5  7
 ����ѧ�����ݽṹ��ͬѧӦ�ö��������Ŀ����̵�ӡ����Ȼ���Ƕ���������Ŀ�����������ʹ�õ��Ļ��Ƿ��ε�˼�롣
���ڸ�����ǰ�����preorder���������inorder���������ǲ��ѷ��֣�������ĸ����(root)��ʵ����preorder[0]��
����preorder��inorder�Ƕ�ͬһ�����ı��������ǿ���֪��preorder[0]��inorder��һ��Ҳ���ڣ�
������preorder[0]==inorder[k]��
����inorder���������������k��ߵľ��Ǹ��ڵ������������������k�ұߵľ��Ǹ��ڵ������������������
���ң����������Ѿ�֪���˸��ڵ��������Ľڵ��������������������ͬ����������Ϊl��
���ǿ���֪��preorder��1��l+1���Ǹ��ڵ���������ǰ�������ʣ�µ����һ���־��Ǹ��ڵ���������ǰ�������
Ҳ����˵�����ǿ��Լ��������������������ǰ�����������������Ӷ������÷��ε�˼�룬
����ģ�ϴ������ֽ��Ϊ������С�����⣬Ȼ��ݹ�Ľ��д�����ԭ����������������
�����ͨ���ڵ�һ�����һ������������
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {  
        if(preorder == null || inorder == null)  
            return null;  
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // ����hashMap�惦���ڵ���inorder�е�λ��
        for(int i = 0; i < inorder.length; i++)  
        {  
            map.put(inorder[i],i);  
        }  
        
        return helper(preorder, 0, preorder.length - 1,
                      inorder, 0, inorder.length - 1, map);  
    }
    private TreeNode helper(int[] preorder, int preL, int preR,
                            int[] inorder, int inL, int inR,
                            HashMap<Integer, Integer> map)  
    {  
        if(preL > preR || inL > inR)  
            return null;
        
        // ����Ŀǰ�ĸ��ڵ�
        TreeNode root = new TreeNode(preorder[preL]);
        // �ҵ�Ŀǰ���ڵ���inorder�е�λ��
        int index = map.get(root.val);
        
        // ���δ�����������(����ǰ���c�����λ�Á��ҵ���һ��root��λ��)
        root.left = helper(preorder, preL + 1, index - inL + preL,
                           inorder, inL, index - 1,
                           map);  
        root.right = helper(preorder, preL + index - inL + 1, preR,
                            inorder, index + 1, inR,
                            map);  
        return root;  
    }  
    
}