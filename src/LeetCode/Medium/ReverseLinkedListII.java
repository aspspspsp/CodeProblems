package LeetCode.Medium;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
1. 找到原链表中第m-1个节点start：反转后的部分将接回改节点后。
从dummy开始移动m-1步
D->1->2->3->4->5->NULL
       |
      st
2. 将从p = start->next开始，长度为L = n-m+1的部分链表反转。
            __________
            |                  |
            |                 V
D->1->2<-3<-4    5->NULL             
       |     |           | 
      st    p          h0         
3. 最后接回
            __________
            |                  |
            |                 V
D->1   2<-3<-4    5->NULL             
       |________|                
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m < 1 || m >= n || head == null)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        //將head移動到m-1的地方
        for(int i = 0; i < m - 1; i ++)
            head = head.next;
    
    	// 將list翻轉過來n-m+1
        ListNode pre = head.next;
        ListNode cur = pre.next;
        for(int i = 0; i < n - m; i ++) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        
        head.next.next = cur;
        head.next = pre;
        head = dummy.next;
        
        return head;
    }
}