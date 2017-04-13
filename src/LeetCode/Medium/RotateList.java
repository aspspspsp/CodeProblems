package LeetCode.Medium;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * ������ͷβ������һ������Ȼ����
 * (size - (k % size))��
 * ������Ľڵ�Ͽ�������λ�ƺ���б�
 *    0.0.0.0.0
 *    0       0
 *    0.0.0.0.0
 * 
 *    0.0/0.0.0
 *    0       0
 *    0.0.0.0.0
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
            return head;
            
        int size = 1;
        ListNode node = head;
        
        //�v�������c��Ӌ��ListNode�Ĵ�С
        while(node.next != null) {
            node = node.next;
            size = size + 1;
        }
        
        //���^β���B
        node.next = head;
        
        //Ӌ����Ҫ��size - (k % size)��(�ஔ�[size - [size - k]])
        int n = size - (k % size);
        
        //�_ʼ��size - (k % size)��
        for(int i = 0; i < n; i ++) {
            node = node.next;
        }
        
        //����n���ᵽ��β���c��������β���c֮������µ��^
        ListNode newHead = node.next;
        
        //���Y�c���_
        node.next = null;
        
        return newHead;
    }
}