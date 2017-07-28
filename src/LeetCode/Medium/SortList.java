package LeetCode.Medium;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return margeSort(head);
    }
    
    ListNode margeSort(ListNode head) {
        //handel special case
        if(head == null || head.next == null)
            return head;
            
        ListNode walker = head;
        ListNode runner = head;
        
        //當runner歷遍整個ListNode後,walker會到ListNode的中間(walker就是中點)
        while(runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        
        //将链表拆成两半
        ListNode right = walker.next;
        walker.next = null;
        ListNode left = head;
        
        //左右两半分别排序
        right = margeSort(right);
        left = margeSort(left);
        
        //合併左右兩邊
        return marge(left, right);
    }
    
    //合併左右兩邊
    ListNode marge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        dummy.next = left;
        ListNode previous = dummy;
        
        //進行排序(插入排序法)
        /*
	將資料分成已排序、未排序兩部份
	依序由未排序中的第一筆(正處理的值)，插入到已排序中的適當位置
	插入時由右而左比較，直到遇到第一個比正處理的值小的值，再插入
	比較時，若遇到的值比正處理的值大或相等，則將值往右移
        */
        while(left != null && right != null) {
            //這邊是進行順序排序
            if(left.val < right.val) {
                left = left.next;
            } else {
                ListNode next = right.next;
                right.next = previous.next;
                previous.next = right;
                right = next;
            }
            
            previous = previous.next;
        }
        
        //避免右邊的鏈表斷鏈(連接剩餘的右邊鏈表)
        if(right != null) {
            previous.next = right;
        }
        
        return dummy.next;
    }
}