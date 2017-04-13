package LeetCode.Medium;

import java.util.Random;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LinkedListRandomNode {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    int length = 1;
    ListNode dummy;
    public LinkedListRandomNode(ListNode head) {
        dummy = new ListNode(0);
        dummy.next = head;
        
        while(head.next != null) {
            head = head.next;
            length ++;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rnd = new Random();
        int target = rnd.nextInt(length + 0);
        
        ListNode head = dummy.next;
        for(int i = 0; i < target; i ++) {
            head = head.next;
        }
        
        return head.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */