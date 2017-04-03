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
        ListNode p1 = new ListNode(0); //存放小於x的ListNode
        ListNode p1_first = p1;
        ListNode p2 = new ListNode(0); //存放大於等於x的ListNode
        ListNode p2_first = p2;
        
        ListNode cur = head;
        
        //以此遍历原链表，如果节点的值大於等於x，就連到p2下面，反之则放到p1
        while(cur != null) {
            if(cur.val >= x) {
                p2.next = cur;
                p2 = p2.next; //指針移到下一個，避免程序只寫入一個地方
            } else {
                p1.next = cur;
                p1 = p1.next;
            }
            cur = cur.next;
        }
        
        //將p2後面斷乾淨
        p2.next = null;
        
        //將p2放在p1後面
        p1.next = p2_first.next;
        
        return p1_first.next;
        
    }
}