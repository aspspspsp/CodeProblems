package LeetCode.Easy;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * init:
 *   1->2->3
 * 1.
 * <-1  2->3
 * 2.
 * <-1<-2  3
 * 3.
 * <-1<-2<-3
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode perv = null;
        while(head != null) {
            //�ȕ���Ŀǰnode����һ��node
            ListNode temp = head.next;
            
            //��Ŀǰ���c�c��һ�����c�M�е���
            head.next = perv;
            perv = head;
            
            //�Ƅӵ���һ�����c
            head = temp;
        }
        return perv;
    }
}