package src.LeetCode.Algorithms.Medium;

import src.LeetCode.Algorithms.Dependencies.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        //這個鏈表的表頭用來儲存結果的
        ListNode result = head;
        
        //這個鏈表的表頭用來存儲奇數
        ListNode p1 = head;
        
        //這個鏈表的表頭用來存儲偶數，放在指到一開始的表頭後面，用以連接
        ListNode p2 = head.next;
        
        //connect node是用來連接奇數與偶數這兩個鏈表表頭的連接點
        ListNode connect_node = head.next;
        
        while(p1 != null && p2 != null) {
            //因為奇數後面緊跟著偶數，故可以不用做比較是否為偶數，直接交換兩個鏈表元素
            ListNode tmp = p2.next;
            if(tmp == null)
                break;
            
            p1.next = p2.next;
            p1 = p1.next;
            
            p2.next = p1.next;
            p2 = p2.next;
        }
        
        //將奇數與偶數的兩個表頭連接
        p1.next = connect_node;
        
        return result;
    }
}
