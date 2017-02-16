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
        
        cur = head; //從頭開始拜訪
        
        //進行排序
        while(cur != null) {
            next = cur.next; //下一個準備進行插入已經調換元素.
            pre = sorted_head; //進行掃描的List
            
            //掃描已經排序(這裡為遞增)的部分，若抓到沒有排序的部份則停止
            while(pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            /*當 pre.next == null 或者 cur 小於 pre.next, 我們希望插入
              cur至pre.next之後(就是將pre未排序的部分與ㄆ)*/
            //這時就是將pre中的已排序與未排序的部分隔開，插入cur
            cur.next = pre.next;
            pre.next = cur;
            
            cur = next;//將指針進行到移到下一步
        }
        
        return sorted_head.next;
    }
}