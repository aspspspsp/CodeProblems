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
public class LowestCommonAncestorOfABinaryTree {
    /*
    �����ǰ�ڵ�(root)Ϊ�շ���null
    �����ǰ�ڵ�(root)��Ŀ��ڵ�(p��q)֮һ��ͬ���򷵻ص�ǰ�ڵ�
    �ݹ�Ѱ��p��q�����������е�λ��
    ���p��q�ֱ�λ��root���������࣬��rootΪ���ǵ�LCA������Ϊ����������������
    
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4

    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // �����ǰ�ڵ�(root)Ϊ�գ�����null
        if(root == null)
            return null;
        
        // �����ǰ�ڵ�(root)�cĿ��ڵ�֮һ��ͬ���򷵻ص�ǰ��
        //(�ҵ�p�cq�t�����Լ�)
        if(root == p || root == q)
            return root;
    
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, p, q); //�����Ә�
        TreeNode right = lowestCommonAncestor(root.right, p, q); //�����Ә�
        
        // Conquer
        //�����Ә䶼��null��ʾ�˹��c��lca(�������Ә䶼�ҵ�p�cq�ĕr��)
        if(left != null && right != null)
            return root;
        
        //����߅�ҵ���p��q���o�ϴ��f�w
        if(left != null)
            return left;
        //����߅�ҵ���p��q���o�ϴ��f�w
        if(right != null)
            return right;
        
        //���˹��c�~�����ӹ��c��p��q���t����null(���Դ˹��c)
        return null;
    }
}