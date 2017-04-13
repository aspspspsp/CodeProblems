package LeetCode.Medium;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        /* ���sorted_head�������ǣ���head��ͷ������һ������
        ���뵽sorted_head��ͷ��������
           (Ҳ��������sorted_head��惦�Y��)
           �������ﲻ��Ҫsorted_head.next = head; */
        ListNode sorted_head = new ListNode(0);
        
        ListNode pre; 
        ListNode cur;
        ListNode next;
        
        cur = head; //���^�_ʼ���L
        
        //�M������
        while(cur != null) {
            next = cur.next; //��һ���ʂ��M�в����ѽ��{�QԪ��.
            pre = sorted_head; //�M�В����List
            
            //�����ѽ�����(�@�e���f��)�Ĳ��֣���ץ���]������Ĳ��݄tֹͣ
            while(pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            /*�� pre.next == null ���� cur С� pre.next, �҂�ϣ������
              cur��pre.next֮��(���ǌ�preδ����Ĳ����c��)*/
            //�@�r���ǌ�pre�е��������cδ����Ĳ��ָ��_������cur
            cur.next = pre.next;
            pre.next = cur;
            
            cur = next;//��ָ��M�е��Ƶ���һ��
        }
        
        return sorted_head.next;
    }
}