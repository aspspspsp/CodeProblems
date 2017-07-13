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
 * 
 * �����:root
 * ������:lt
 * ������:rt
 * �����ӽ��:x
 * ��root��lt�е�x����root��rt�ӵ�x���������ϣ�x��������Ϊ�գ���root���������������Ϊ��������root�����������ա� 
 */
public class FlattenBinaryTreeToLinkedList {
    //紀錄上一個經歷的最後一個節點
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        //̎處理特殊情況
        if(root == null) {
            return;
        }
        
        //將最後一個節點的下一個節點(目前節點)從左移至右
        if(lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        
        //���^��һ�����E�ᣬ���^�m����һ��
        lastNode = root;
        
        //經過上一個步驟後，再繼續往下一層
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        //�����Ә���һ�ӵ�̎��
        flatten(left);
        
        //�����Ә���һ�ӵ�̎��
        flatten(right);
    }
}