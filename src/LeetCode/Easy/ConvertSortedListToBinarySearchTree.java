package LeetCode.Easy;

import LeetCode.Dependencies.ListNode;
import LeetCode.Dependencies.TreeNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedListToBinarySearchTree {
    //�@�Ø�������湝�c
    ListNode visitedListNode;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        
        //
        visitedListNode = head;
        
        //�ҵ�List node���L��
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len ++;
            temp = temp.next;
        }
        
        //���ö��ַ��혋��BST
        TreeNode treeTop = constructBST(0, len - 1);
        return treeTop;
    } 
    
    // build tree bottom-up
    TreeNode constructBST(int start, int end) {
        if(start > end) {
            return null;
        }
        
        //���ҳ��˅^�g�����g�c
        int middle = (start + end) / 2;
        
        //*****������Ϙ�����(��(С) -> �� -> ��(��))*****
        //���Ҫ�S��ÿ���f�w��Ҫ����С�д�Ĵ��򣬹�С�Y�cҪ��һ����
        //�ҳ��Ә�����Ә�(������BST -- С)
        TreeNode left = constructBST(start, middle - 1);
        //���Ҫ�S��ÿ���f�w��Ҫ����С�д�Ĵ��򣬹��нY�cҪ�ڶ�����
        //��Ŀǰ���L�Ĺ��c����һ���九�c(��)
        TreeNode root = new TreeNode(visitedListNode.val);
        visitedListNode = visitedListNode.next;
        //���Ҫ�S��ÿ���f�w��Ҫ����С�д�Ĵ��򣬹ʴ�Y�cҪ��������
        //�ҳ��Ә�����Ә�(������BST -- ��)
        TreeNode right = constructBST(middle + 1, end);
        
        //�������Ә��c֮ǰ�����Ę九�c�B��
        root.left = left;
        root.right = right;
        
        return root;
    }
}