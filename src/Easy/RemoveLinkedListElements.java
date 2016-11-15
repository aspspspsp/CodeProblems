package Easy;

import Dependencies.ListNode;

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
        
        //一開始把指針指向dummy避免了頭元素需要刪除而無法刪除的情況
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