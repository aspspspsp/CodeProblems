package Easy;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode firstOfListNodes;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        firstOfListNodes = head;
        
        int sizeOfListNode = 1;
        while(head.next != null) {
            head = head.next;
            sizeOfListNode ++;
        }
        
        head = firstOfListNodes;
        for(int i = 0; i < sizeOfListNode; i ++) {
            head = head.next;
            if(sizeOfListNode - n == i) {
                head.next = head.next;
                i = i + 2;
            } else {
                head.next = head;
            }
        }
        
        return firstOfListNodes;
    }
    
}