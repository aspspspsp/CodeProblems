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

        //利用dummy來做為頭指標來返回
        ListNode cur = dummy;
        
        while(cur.next != null) {
            //將指標鍊接到要刪除的節點的下一個(不連到它，代表刪除)
            if(cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        
        return dummy.next;
    }
}