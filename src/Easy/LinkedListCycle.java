package Easy;

import Dependencies.ListNode;

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
 * 設一個fast，會一次拜訪兩個點
 * 再設一個slow，只會一次拜訪一個點
 * 若fast==slow(兩個點相遇)，表示此listNode為環，反之則不是
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        //設fast與slow兩個listNode
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