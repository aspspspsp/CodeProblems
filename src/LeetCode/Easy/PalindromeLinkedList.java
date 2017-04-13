package LeetCode.Easy;

import LeetCode.Dependencies.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        
        //�ҵ����c
        ListNode middle = findMiddle(head);
        
        //��倱���߅��һ�뷭�D
        middle.next = reverse(middle.next);
        ListNode half_right = middle.next;
        
        //���߅�c�Ұ�߅�M�б��^
        ListNode half_left = head;
        while(half_right != null && half_left != null &&
              half_right.val == half_left.val) {
            half_right = half_right.next;
            half_left = half_left.next;
        }
        
        //��half_right�]�Кv���꣬��ʾ���ǻ���
        if(half_right == null) {
            return true;
        }
        return false;
    }
    
    //�ҵ����g�c
    ListNode findMiddle(ListNode head) {
        if(head == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    //���D倱�
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
    
}