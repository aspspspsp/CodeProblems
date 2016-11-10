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
 * 将链表头尾相接组成一个环，然后走
 * (size - (k % size))步
 * ，后面的节点断开，就是位移后的列表。
 *    0.0.0.0.0
 *    0       0
 *    0.0.0.0.0
 * 
 *    0.0/0.0.0
 *    0       0
 *    0.0.0.0.0
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
            return head;
            
        int size = 1;
        ListNode node = head;
        
        //歷遍所有點，計算ListNode的大小
        while(node.next != null) {
            node = node.next;
            size = size + 1;
        }
        
        //將頭尾相連
        node.next = head;
        
        //計算需要走size - (k % size)步(相當於[size - [size - k]])
        int n = size - (k % size);
        
        //開始走size - (k % size)步
        for(int i = 0; i < n; i ++) {
            node = node.next;
        }
        
        //走了n步後到了尾節點，而到了尾節點之後就是新的頭
        ListNode newHead = node.next;
        
        //將結點斷開
        node.next = null;
        
        return newHead;
    }
}