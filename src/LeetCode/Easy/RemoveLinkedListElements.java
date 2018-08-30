package src.LeetCode.Easy;

import src.LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        
        if(head == null)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //һ�_ʼ��ָ�ָ��dummy�������^Ԫ����Ҫ�h�����o���h������r
        ListNode cur = dummy;
        
        while(cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        
        return dummy.next;
    }
}