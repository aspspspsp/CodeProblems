package src.LeetCode.Medium;

import src.LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        /* 这个sorted_head的作用是，把head开头的链表一个个的
        插入到sorted_head开头的链表里
           (也就是利用sorted_head來存儲結果)
           所以这里不需要sorted_head.next = head; */
        ListNode sorted_head = new ListNode(0);
        
        ListNode pre; 
        ListNode cur;
        ListNode next;
        
        cur = head; //���^�_ʼ���L
        
        //進行排序
        while(cur != null) {
            next = cur.next; //��һ���ʂ��M�в����ѽ��{�QԪ��.
            pre = sorted_head; //�M�В����List
            
            //�����ѽ�����(�@�e���f��)�Ĳ��֣���ץ���]������Ĳ��݄tֹͣ
            while(pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            /*當 pre.next == null 或者 cur 小於 pre.next, 我們希望插入
            cur至pre.next之後*/
            //�@�r���ǌ�pre�е��������cδ����Ĳ��ָ��_������cur
            cur.next = pre.next;
            pre.next = cur;
            
            cur = next;//��ָ��M�е��Ƶ���һ��
        }
        
        return sorted_head.next;
    }
}