package Medium;

import Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return head;
        

        //分成兩半 一邊比x大 一邊比x_小
        // 1->4->3->2->5->2, x = 3
        //----------------------------
        // 1->2->2->4->3->5
        //     <x  ,  x>=  
        ListNode p = new ListNode(0); //比x小
        ListNode p_dummy = p;
        ListNode q = new ListNode(0); //大於等於x
        ListNode q_dummy = q;
        while(head != null) {
            if(head.val >= x) {
                q.next = head;
                q = q.next;
            } else {
                p.next = head;
                p = p.next;
            }
            head = head.next;
        }
        
        //把兩個listNode接再一起
        p.next = q_dummy.next;
        q.next = null; //關閉尾節點，避免錯誤
        return p_dummy.next;
    }
}