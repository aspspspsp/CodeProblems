/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
            
        if(head.next != null) {
            swap(head, head.next);
            if(head.next.next != null)
            swapPairs(head.next.next);
        }
        return head;
    }
    
    public void swap(ListNode x, ListNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}