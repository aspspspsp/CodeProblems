package LeetCode.Medium;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
1. �ҵ�ԭ�����е�m-1���ڵ�start����ת��Ĳ��ֽ��ӻظĽڵ��
��dummy��ʼ�ƶ�m-1��
D->1->2->3->4->5->NULL
       |
      st
2. ����p = start->next��ʼ������ΪL = n-m+1�Ĳ�������ת��
            __________
            |                  |
            |                 V
D->1->2<-3<-4    5->NULL             
       |     |           | 
      st    p          h0         
3. ���ӻ�
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
        
        //��head�Ƅӵ�m-1�ĵط�
        for(int i = 0; i < m - 1; i ++)
            head = head.next;
    
    	// ��list���D�^��n-m+1
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