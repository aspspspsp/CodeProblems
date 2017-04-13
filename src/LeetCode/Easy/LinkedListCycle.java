package LeetCode.Easy;

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
 * 
 * �Oһ��fast����һ�ΰ��L�ɂ��c
 * ���Oһ��slow��ֻ��һ�ΰ��Lһ���c
 * ��fast==slow(�ɂ��c����)����ʾ��listNode��h����֮�t����
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        //�Ofast�cslow�ɂ�listNode
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast != slow) {
            if(fast == null || fast.next == null) {
                return false;
            }
            
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return true;
    }
}