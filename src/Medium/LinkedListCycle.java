package Medium;

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
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        //先確定是否有環
        while(true) {
            if(fast == null || fast.next == null)
            {
                //遇到null了，说明不存在环
                return false;
            }
            
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                return true;    //fast與slow第一次相遇在Z点
            }
        }
    }
}