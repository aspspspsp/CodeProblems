package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * init:
 *   1->2->3->
 * 1.
 * <-1  2->3->
 * 2.
 * <-1<-2  3->
 * 3.
 * <-1<-2<-3
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //紀錄上一個元素
        ListNode perv = null;
        while(head != null) {
            //暫存指針，指到下一個元素
            ListNode next = head.next;
            
            //將當前指針只到上一個元素
            head.next = perv;
            //再將上一個指針指到當前元素
            perv = head;
            
            //再將當前指針移到下一個元素
            head = next;
        }
        return perv;
    }
}