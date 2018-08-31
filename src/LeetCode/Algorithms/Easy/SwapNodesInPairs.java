package src.LeetCode.Algorithms.Easy;

import src.LeetCode.Algorithms.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        
        if(head.next != null) {
        	//與相鄰的另一個listNode交換
            swap(head, head.next);
            
            //若後面還有節點(後兩個)，則在重複呼叫這個方法
            if(head.next.next != null)
            	swapPairs(head.next.next);
        }
        return head;
    }
    
    public void swap(ListNode x, ListNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}