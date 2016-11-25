package Medium;

import Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *  
 * 1) 用快慢指针找到中间节点，将链表分成两部分。
 * 2) 对后面一半的链表逆序，这个也是常见的问题了(链表反转)。
 * 3) 合并两个链表。
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
            
        //用快慢指针找到中间节点，将链表分成两部分。
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
        }
        
        //從中間節點將後面一半的表進行逆序
        ListNode cur = walker;
        ListNode perv = null;
        while(cur != null) {
            ListNode nxt = cur.next;
            cur.next = perv;
            perv = cur;
            
            cur = nxt;
        }
        
        //將後面的鏈表合併到前面的鏈表
        ListNode first = head;
        ListNode second = perv;
        while(first != null && second != null && first != second) {
            ListNode temp = second.next;
            
            second.next = first.next;
            first.next = second;
            
            //將first 的指針移到下一個
            first = second.next;
            
            //second ListNode的指針移到下一個
            second = temp;
        }
    }
}