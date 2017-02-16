package Medium;

import Dependencies.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
/*
�ˆ��}���Ժ��ε����������Ӂ�������:
             1
            / \
           2   3
          / \ / \
         4  57   8
            /
           6
          
in-order:   4 2 5  (1)  6 7 3 8
post-order: 4 5 2  6 7 8 3  (1)

**��������픵�M**
�����򔵽M�����҂����Ե�֪:���������Ԫ�؞�����c�����҂����ԏ����򔵽M���ҵ����Y�c
Ȼ���҂�������������ֱ������򔵽M�ĸ��Y�c���c���Ә�
**��������픵�M**
�������Ә���L�ȣ��҂����Էֱ������򔵽M�е����c���Ә�
���@���f�w�İ�������Ĳ��E�����ɘ���һ���Ø�
*/
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //���x��ֵ
        int in_start = 0; //����(������)�_ʼ��λ��
        int in_end = inorder.length - 1; //����(������)�Y����λ��
        int post_start = 0; //����(������)�_ʼ��λ��
        int post_end = postorder.length - 1; //����(������)�Y����λ��
        
        TreeNode result = buildTree(inorder, in_start, in_end, postorder, post_start, post_end);
        return result;
    }
    
    //���������cǰ���_ʼ�c�Y��λ�Á�õ�Ŀǰ�ĸ��Y�c��Ȼ����ȡ�������Ә�ĸ��Y�c���f�w���@������õ�һ�Ø�
    TreeNode buildTree(int[] inorder, int in_start, int in_end,
                     int[] postorder, int post_start, int post_end) {
        if(in_start > in_end || in_start > in_end)
            return null;
        
        int root_val = postorder[post_end]; //�ҵ�Ŀǰ�Ә�ĸ��Y�c��ֵ **����(������)������һ�����Y�c
        TreeNode root = new TreeNode(root_val);
        
        //����Ŀǰ�Ә�ĸ����c�������λ��
        int root_index_in_inorder = 0;
        for(int i = 0; i < inorder.length; i ++) {
            if(inorder[i] == root_val) {
                root_index_in_inorder = i;
                break;
            }
        }
        
        //�������Ә�
        //��� root_index_in_inorder �K�������Ә���L��, ����Ҫ��-(in_start + 1)��õ����Ә���L��
        root.left = buildTree(inorder, in_start, root_index_in_inorder - 1,
                            postorder, post_start, post_start + root_index_in_inorder - (in_start + 1));
                            
        //�������Ә�
        /* post_start + root_index_in_inorder - in_start =
           post_start + root_index_in_inorder - (in_start + 1) + 1  */          
        root.right = buildTree(inorder, root_index_in_inorder + 1, in_end,
                            postorder, post_start + root_index_in_inorder - in_start, post_end - 1);
                            
        return root;
    }
}