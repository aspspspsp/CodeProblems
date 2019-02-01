/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 第一個指針移到虛擬指針
        /*
        0>2
        *
        */
        head = dummy;
        
        // 歷遍這個list
        while(head.next != null && head.next.next != null) {
            /*
            0>2>2>2>3  <=遇到重複節點的^#
            * ^ #
            0>2>2>2>3
            *   ^ #
            0>2>2>2>3
            *     ^ #
            0>2>2>2>3  <=串接*與#
            *       #
            0>3
            */
            if(head.next.val == head.next.next.val) {
                int sameNum = head.next.val;
                while(head.next != null && head.next.val == sameNum)
                    head.next = head.next.next;
            }
            else 
                head = head.next;
        }
        
        return dummy.next;
    }
}
