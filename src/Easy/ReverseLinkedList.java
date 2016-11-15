package Easy;

import Dependencies.ListNode;

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
            //先暫存目前node的下一個node
            ListNode temp = head.next;
            
            //將目前節點與下一個節點進行倒反
            head.next = perv;
            perv = head;
            
            //移動到下一個節點
            head = temp;
        }
        return perv;
    }
}