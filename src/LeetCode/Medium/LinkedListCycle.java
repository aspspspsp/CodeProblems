package LeetCode.Medium;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        //�ȴ_���Ƿ��Эh
        while(true) {
            if(fast == null || fast.next == null)
            {
                //����null�ˣ�˵�������ڻ�
                return false;
            }
            
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                return true;    //fast�cslow��һ��������Z��
            }
        }
    }
}